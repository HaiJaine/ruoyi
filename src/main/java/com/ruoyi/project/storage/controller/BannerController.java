package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.service.BannerService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询广告
     *
     * @param param 参数
     * @return 结果
     */
    @RequestMapping("/list")
    public TableDataInfo list(Params param) {
        startPage();
        List<BannerVO> bannerList = bannerService.findBannerList(param);
        return getDataTable(bannerList);
    }

    /**
     * 新增广告
     *
     * @param bannerVO 参数
     * @return 结果
     */
    @PostMapping("/creat")
    public AjaxResult creat(@RequestBody BannerVO bannerVO) {
        int result = bannerService.creat(bannerVO);
        return toAjax(result);
    }

    /**
     * 更新广告表
     *
     * @param bannerVO 参数
     * @return 结果
     */
    @PutMapping("/update")
    public AjaxResult update(@RequestBody BannerVO bannerVO) {
        int result = bannerService.update(bannerVO);
        return toAjax(result);
    }

    @PutMapping("/{operate}/{ids}")
    public AjaxResult operate(@PathVariable String operate, @PathVariable Long[] ids) {
        int result = bannerService.operate(operate,ids);
        return toAjax(result);
    }


}
