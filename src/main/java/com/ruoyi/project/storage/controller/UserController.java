package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    /**
     * 用户查询（分页，多条件）
     *
     * @param params 查询条件
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getUser(Params params) {
        startPage();
        List<User> users = userService.findUsers(params);
        return getDataTable(users);
    }

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    @PostMapping("/create")
    public AjaxResult createUser(@RequestBody User user) {
        int result = userService.createUser(user);
        return toAjax(result);
    }
}
