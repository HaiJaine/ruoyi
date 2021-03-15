package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public TableDataInfo getUser(Params params) {
        startPage();
        List<User> users = userService.findUsers(params);
        return getDataTable(users);
    }
}
