package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.ContactInfoDao;
import org.sdjusei.sdjulife.model.domain.ContactInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 电话黄页服务
 *
 * @author zcz
 * @date 2020/08/28
 */
@Service
public class ContactInfoService {

	@Resource
	private ContactInfoDao contactInfoDao;

	/**
	 * 电话黄页获取方法
	 *
	 * @return 电话黄页实体类List
	 */
	public List<ContactInfo> getAllContactInfo() {
		return contactInfoDao.selectAllContactInfo();
	}
}
