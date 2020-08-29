package org.sdjusei.sdjulife.dao;

import org.apache.ibatis.annotations.Select;
import org.sdjusei.sdjulife.model.domain.HandbookPage;

import java.util.List;

/**
 * 学生手册持久层
 *
 * @author zcz
 * @date 2020/08/29
 */
public interface HandbookDao {

	@Select("SELECT page_number,title,url FROM handbook")
	List<HandbookPage> selectAllPages();
}
