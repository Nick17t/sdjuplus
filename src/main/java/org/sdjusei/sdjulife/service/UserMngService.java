package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.UserDao;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.domain.User;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.util.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户管理服务，用于用户的增删查改
 *
 * @author zcz
 * @date 2020/07/17
 */
@Service
@Transactional
public class UserMngService {

	@Resource
	private UserDao userDao;

	/**
	 * 删除用户方法
	 *
	 * @param token 用户token
	 */
	public void delete(String token) {
		Integer userId = TokenUtil.decodeJwtToken(token);
		int flag = userDao.deleteUserById(userId);

		//更新不成功则抛出异常
		if (flag == 0) {
			throw new CommonException(ResultEnum.USER_LOGOFF_FAIL);
		}
	}

	/**
	 * 更新用户信息方法
	 *
	 * @param token 用户token
	 * @param user 用户类对象
	 */
	public void updateInfo(String token, User user) {
		Integer userId = TokenUtil.decodeJwtToken(token);

		//将用户ID存入，变成带用户ID的用户类对象
		user.setUserId(userId);
		int flag = userDao.updateUser(user);

		//更新不成功则抛出异常
		if (flag == 0) {
			throw new CommonException(ResultEnum.USER_UPDATE_FAIL);
		}
	}
}
