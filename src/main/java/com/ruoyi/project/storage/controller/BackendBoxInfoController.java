package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/backend/box/info")
@RestController
public class BackendBoxInfoController extends BaseController {

    @GetMapping("/list")
    public TableDataInfo getBoxInfoList() {
        return null;
    }
}
