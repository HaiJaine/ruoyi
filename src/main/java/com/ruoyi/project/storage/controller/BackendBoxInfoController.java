package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.BoxInfoVO;
import com.ruoyi.project.storage.service.BackendBoxInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
}
