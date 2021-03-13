package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.BannerParam;
import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:09
 */
@RestController
@RequestMapping("/backend/advertisement")
public class BannerController extends BaseController {

    @Resource
    private BannerService bannerService;

    @RequestMapping("/list")
    public TableDataInfo list(BannerParam param) {
        startPage();
        List<BannerVO> bannerList = bannerService.findBannerList(param);
        return getDataTable(bannerList);
    }
}
