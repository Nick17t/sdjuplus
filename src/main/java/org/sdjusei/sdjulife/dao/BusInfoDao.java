package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Select;
import org.sdjusei.sdjulife.model.domain.BusInfo;

import java.util.List;

/**
 * 班车信息持久层
 *
 * @author zcz
 * @date 2020/08/27
 */
public interface BusInfoDao {

	@Select("SELECT category,`name`,driver,driver_phone,bus_number,bus_number,schedule,remark FROM bus_info WHERE category=#{category}")
	List<BusInfo> selectBusInfoByCategory(String category);

	@Select("SELECT category,`name`,driver,driver_phone,bus_number,bus_number,schedule,remark FROM bus_info")
	List<BusInfo> selectAllBusInfo();
}
