package org.sdjusei.sdjulife.service;

import org.sdjusei.sdjulife.dao.HandbookDao;
import org.sdjusei.sdjulife.model.domain.HandbookPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生手册下载服务
 *
 * @author zcz
 * @date 2020/08/29
 */
@Service
public class HandbookDownloadService {

	@Resource
	private HandbookDao handbookDao;

	/**
	 * 获取全部文章信息
	 *
	 * @return 学生手册单页实体类List
	 */
	public List<HandbookPage> getAllPages(){
		return handbookDao.selectAllPages();
	}
}
