package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.service.CustomerService;
import com.ruoyi.project.storage.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/customer")
public class CustomerController extends BaseController {
    @Resource
    private CustomerService customerService;

    @GetMapping("/list")
    public TableDataInfo getCustomers(Params params) {
        startPage();
        List<User> customers = customerService.findCustomers(params);
        return getDataTable(customers);
    }

    @PostMapping("/create")
    public AjaxResult create(@RequestBody User user){
        int result = customerService.createCustomer(user);
        return toAjax(result);
    }
}
