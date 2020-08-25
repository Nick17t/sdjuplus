package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Insert;
import org.sdjusei.sdjulife.model.domain.Feedback;

/**
 * 反馈信息持久层
 *
 * @author zcz
 * @date 2020/08/25
 */
public interface FeedbackDao {

	@Insert("INSERT INTO feedback(user_id,title,describe) VALUES(#{userId},#{title},#{describe})")
	int insertFeedback(Feedback feedback);
}
