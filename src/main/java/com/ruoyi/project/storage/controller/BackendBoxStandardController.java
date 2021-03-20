package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.service.BackendBoxStandardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backend/box/standard")
public class BackendBoxStandardController extends BaseController {
    @Resource
    private BackendBoxStandardService backendBoxStandardService;

    @GetMapping("/list")
    public TableDataInfo getBoxStandardList(BoxStandardVO boxStandardVO) {
        startPage();
        List<BoxStandardVO> boxStandardList = backendBoxStandardService.getBoxStandardList(boxStandardVO);
        return getDataTable(boxStandardList);
    }

    @GetMapping("/select")
    public AjaxResult getStandardList() {
        List<BoxStandardSelectVO> list = backendBoxStandardService.selectBoxStandardSelectList();
        return AjaxResult.success(list);
    }

    @PostMapping("/create")
    public AjaxResult createBoxStandard(@RequestBody BoxStandardVO boxStandardVO) {
        int result = backendBoxStandardService.createBoxStandard(boxStandardVO);
        return toAjax(result);
    }

    @DeleteMapping("delete/{ids}")
    public AjaxResult deleteBoxStandards(@PathVariable Long[] ids) {
        int result = backendBoxStandardService.deleteBoxStandards(ids);
        return toAjax(result);
    }
}
