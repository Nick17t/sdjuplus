package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.BusInfo;
import org.sdjusei.sdjulife.model.domain.ContactInfo;
import org.sdjusei.sdjulife.model.domain.HandbookPage;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.service.BusInfoService;
import org.sdjusei.sdjulife.service.ContactInfoService;
import org.sdjusei.sdjulife.service.HandbookDownloadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 常用信息控制层，
 * 接收校车、电话黄页和学生手册的查询和更新请求
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "常用信息接口")
@RestController
@RequestMapping("/useful-info")
public class UsefulInfoController {

	@Resource
	private BusInfoService busInfoService;
	@Resource
	private ContactInfoService contactInfoService;
	@Resource
	private HandbookDownloadService handbookDownloadService;

	/**
	 * 校车查询方法
	 *
	 * @return 校车信息实体类List
	 */
	@ApiOperation("校车查询")
	@GetMapping("/bus")
	public Result<List<BusInfo>> getBus() {
		List<BusInfo> busInfoList = busInfoService.getAllBusInfo();
		return Result.success(busInfoList);
	}

	/**
	 * 电话黄页查询方法
	 *
	 * @return 电话黄页实体类List
	 */
	@ApiOperation("电话黄页查询")
	@GetMapping("/yellow-page")
	public Result<List<ContactInfo>> getYellowPage() {
		List<ContactInfo> contactInfoList = contactInfoService.getAllContactInfo();
		return Result.success(contactInfoList);
	}

	/**
	 * 学生手册查询方法
	 *
	 * @return 学生手册单页实体类List
	 */
	@ApiOperation("学生手册查询")
	@GetMapping("/handbook")
	public Result<List<HandbookPage>> getHandbookByPage() {
		List<HandbookPage> pages = handbookDownloadService.getAllPages();
		return Result.success(pages);
	}

}
