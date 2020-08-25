package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.sdjusei.sdjulife.model.domain.User;

/**
 * 用户持久层
 *
 * @author zcz
 * @date 2020/07/17
 */
public interface UserDao {

	@Select("SELECT user_id,stu_id,wx_openid,qq_openid FROM user WHERE wx_open_id=#{openid} OR qq_open_id=#{openid}")
	User searchUserByOpenid(String openid);

	@Select("SELECT user_id,stu_id,wx_openid,qq_openid FROM user WHERE id=#{id}")
	User searchUserById(Integer userId);

	@Insert("INSERT INTO user(wx_openid) VALUES(#{openid})")
	int insertUserFromWx(String openid);

	@Insert("INSERT INTO user(qq_openid) VALUES(#{openid})")
	int insertUserFromQq(String openid);

	@Delete("DELETE user WHERE id=#{userId}")
	int deleteUserById(Integer userId);

	int updateUser(User user);
}
