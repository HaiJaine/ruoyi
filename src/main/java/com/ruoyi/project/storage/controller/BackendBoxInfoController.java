package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.vo.BoxInfoVO;
import com.ruoyi.project.storage.service.BackendBoxInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author LongHaiJiang
 * @date 2021/3/13 8:09
 */
@RequestMapping("/backend/box/info")
@RestController
public class BackendBoxInfoController extends BaseController {
    @Resource
    private BackendBoxInfoService backendBoxInfoService;

    @GetMapping("/list")
    public TableDataInfo getBoxInfoList(BoxInfoVO boxInfoVO) {
        startPage();
        List<BoxInfoVO> boxInfoList = backendBoxInfoService.getBoxInfoList(boxInfoVO);
        return getDataTable(boxInfoList);
    }

    @PostMapping("/create")
    public AjaxResult createBoxInfo(@RequestBody BoxInfoVO boxInfoVO) {
        int result = backendBoxInfoService.createBoxInfo(boxInfoVO);
        return toAjax(result);
    }

    @DeleteMapping("delete/{ids}")
    public AjaxResult deleteBoxInfos(@PathVariable Long[] ids) {
        int result = backendBoxInfoService.deleteBoxInfos(ids);
        return toAjax(result);
    }

}
