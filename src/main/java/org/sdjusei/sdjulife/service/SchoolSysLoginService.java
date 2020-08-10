package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.util.SchoolSysAccessUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 学校系统登录服务
 *
 * @author zcz
 * @date 2020/08/10
 */
@Service
public class SchoolSysLoginService {

	@Resource
	private SchoolSysAccessUtil schoolSysAccessUtil;

	public Map<String, String> unifiedLogin(Map<String, String> map) throws Exception {
		//无法获得学号则抛出异常
		if (map.get("stuId") == null)
			throw new CommonException(ResultEnum.STU_ID_MISSING);
		//如果需要验证码却没有输入，抛出异常
		if (map.get("captchaImage") != null && map.get("captchaResponse") == null)
			throw new CommonException(ResultEnum.CAPTCHA_CODE_MISSING);
		//如果map中只有学号，则视为首次请求，调用预请求方法
		if (map.get("password") == null)
			return schoolSysAccessUtil.preUnifiedLogin(map);
		else
			//如果学号密码都不为空，则视为正式进行登录
			return schoolSysAccessUtil.unifiedLogin(map);
	}
}
