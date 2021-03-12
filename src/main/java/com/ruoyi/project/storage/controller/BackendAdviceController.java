package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advice")
public class BackendAdviceController extends BaseController {
    @GetMapping("/list")
    public String getAdviceList(){
        return "test";
    }
}
