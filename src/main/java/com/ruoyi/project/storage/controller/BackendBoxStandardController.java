package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.service.BackendBoxStandardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backend/box/standard")
public class BackendBoxStandardController extends BaseController {
    @Resource
    private BackendBoxStandardService backendBoxStandardService;

    @GetMapping("/list")
    public TableDataInfo getBoxStandardList(Params params) {
        List<BoxStandardVO> boxStandardList = backendBoxStandardService.getBoxStandardList(params);
        return getDataTable(boxStandardList);
    }
}
