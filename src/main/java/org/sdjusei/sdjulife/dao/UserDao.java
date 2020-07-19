package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.sdjusei.sdjulife.domain.User;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层类
 *
 * @author zcz
 * @date 2020/07/17
 */
@Repository
public interface UserDao {
	@Select("SELECT user_id,stu_id,wx_openid,qq_openid FROM user WHERE wx_open_id=#{openid} OR qq_open_id=#{openid}")
	User searchUserByOpenid(String openid);

	@Select("SELECT user_id,stu_id,wx_openid,qq_openid FROM user WHERE id=#{id}")
	User searchUserById(Integer userId);

	@Insert("INSERT INTO user(wx_openid) VALUES(#{openid)")
	Integer insertUserFromWx(String openid);

	@Insert("INSERT INTO user(qq_openid) VALUES(#{openid)")
	Integer insertUserFromQq(String openid);

	Integer deleteUserById(User user);

	Integer updateUser(User user);
}
