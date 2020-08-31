package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.BusInfoDao;
import org.sdjusei.sdjulife.model.domain.BusInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusInfoService {

	@Resource
	private BusInfoDao busInfoDao;

	/**
	 * 获取全部校车信息方法
	 *
	 * @return 校车信息实体类List
	 */
	public List<BusInfo> getAllBusInfo() {
		return busInfoDao.selectAllBusInfo();
	}
}
