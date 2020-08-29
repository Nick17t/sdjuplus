package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Select;
import org.sdjusei.sdjulife.model.domain.ContactInfo;

import java.util.List;

/**
 * 电话黄页持久层
 *
 * @author zcz
 * @date 2020/08/28
 */
public interface ContactInfoDao {

	@Select("SELECT branch_name,position,phone_number FROM contact_info")
	List<ContactInfo> selectAllContactInfo();
}
