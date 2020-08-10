package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.UserDao;
import org.sdjusei.sdjulife.domain.Code2SessionResult;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.domain.User;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.util.OpenidUtil;
import org.sdjusei.sdjulife.util.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户登录服务，用于处理用户的登录过程
 *
 * @author zcz
 * @date 2020/07/17
 */
@Service
@Transactional
public class UserLoginService {

	@Resource
	private OpenidUtil openidUtil;
	@Resource
	private UserDao userDao;

	/**
	 * 登录
	 *
	 * @param userLoginMsg 登录请求，包含小程序签发的code和平台标记（标记请求来源）
	 * @return 登录成功时，返回Token
	 * @throws Exception openid获取和token创建时的异常
	 */
	public String login(String code, String platform) throws Exception {
		//如果缺失字段则返回错误信息
		if (code == null || platform == null || "".equals(code) || "".equals(platform)) {
			throw new CommonException(ResultEnum.MINI_PRO_LOGIN_INFO_MISSING);
		}

		//从腾讯服务器获取openid
		Code2SessionResult code2SessionResult = openidUtil.jsCode2Session(code, platform);

		//检查用户是否存在，不存在则进行“注册”，无论是否存在，最后都要通过userId生成Token返回给前端
		User user = userDao.searchUserByOpenid(code2SessionResult.getOpenId());
		if (user == null) {
			user = register(code2SessionResult.getOpenId(), platform);
		}
		return TokenUtil.createJwtToken(user.getUserId().toString());
	}

	/**
	 * 注册
	 *
	 * @param openid   从微信或QQ的API获取到的openid
	 * @param platform 请求发起平台
	 * @return 返回注册后的用户实体
	 */
	public User register(String openid, String platform) {
		int flag = 0;
		if ("wx".equalsIgnoreCase(platform)) {
			flag = userDao.insertUserFromWx(openid);
		} else if ("qq".equalsIgnoreCase(platform)) {
			flag = userDao.insertUserFromQq(openid);
		}

		//如果插入失败，则注册失败
		if (flag == 0) {
			throw new CommonException(ResultEnum.USER_REGISTER_FAIL);
		}
		return userDao.searchUserByOpenid(openid);
	}
}
