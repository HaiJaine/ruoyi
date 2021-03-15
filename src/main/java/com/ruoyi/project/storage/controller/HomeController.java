package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/backend/home")
public class HomeController extends BaseController {

    @Resource
    private UserService userService;

    @PutMapping("/updatePassword/{oldPassword}/{newPassword}")
    public AjaxResult updatePassword(@PathVariable String oldPassword, @PathVariable String newPassword) {
        int result = userService.updatePassword(oldPassword, newPassword);
        return toAjax(result);
    }
}