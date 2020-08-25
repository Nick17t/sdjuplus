package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.FeedbackDao;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.model.domain.Feedback;
import org.sdjusei.sdjulife.model.domain.ResultEnum;
import org.sdjusei.sdjulife.util.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 反馈提交接口
 *
 * @author zcz
 * @date 2020/08/25
 */
@Service
public class FeedbackSubmitService {

	@Resource
	private FeedbackDao feedbackDao;

	/**
	 * 反馈信息提交方法
	 *
	 * @param token token，用于读取用户ID
	 * @param feedback 反馈信息主体
	 */
	public void submit(String token, Feedback feedback) {
		feedback.setUserId(TokenUtil.decodeJwtToken(token));
		int flag = feedbackDao.insertFeedback(feedback);

		//插入失败则抛出异常
		if(flag==0){
			throw new CommonException(ResultEnum.FEEDBACK_SUBMIT_FAIL);
		}
	}
}
