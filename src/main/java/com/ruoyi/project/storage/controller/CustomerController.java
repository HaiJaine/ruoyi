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

    /**
     * 查询客户
     *
     * @param params 参数
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getCustomers(Params params) {
        startPage();
        List<User> customers = customerService.findCustomers(params);
        return getDataTable(customers);
    }

    /**
     * 新增客户
     *
     * @param user user
     * @return 结果
     */
    @PostMapping("/create")
    public AjaxResult create(@RequestBody User user) {
        int result = customerService.createCustomer(user);
        return toAjax(result);
    }

    /**
     * 更新客户
     *
     * @param user 客户
     * @return 结果
     */
    @PutMapping("update")
    public AjaxResult updateCustomer(@RequestBody User user) {
        int result = customerService.updateCustomer(user);
        return toAjax(result);
    }
}
