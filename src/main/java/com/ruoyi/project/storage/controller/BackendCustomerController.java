package com.ruoyi.project.storage.controller;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.CustomerVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.service.BackendCustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backend/customer")
public class BackendCustomerController extends BaseController {
    @Resource
    private BackendCustomerService backendCustomerService;

    /**
     * 查询客户
     *
     * @param params 参数
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getCustomers(Params params) {
        startPage();
        List<CustomerVO> customers = backendCustomerService.findCustomers(params);
        return getDataTable(customers);
    }

    /**
     * 新增客户
     *
     * @param customerVO user
     * @return 结果
     */
    @PostMapping("/create")
    public AjaxResult create(@RequestBody CustomerVO customerVO) throws CustomException {
        int result = backendCustomerService.createCustomer(customerVO);
        return toAjax(result);
    }

    /**
     * 更新客户
     *
     * @param customerVO 客户
     * @return 结果
     */
    @PutMapping("/update")
    public AjaxResult updateCustomer(@RequestBody CustomerVO customerVO) {
        int result = backendCustomerService.updateCustomer(customerVO);
        return toAjax(result);
    }

    /**
     * 客户操作（启用/停用/删除）
     *
     * @param operate 操作
     * @param ids     ids
     * @return 结果
     */
    @PutMapping("/{operate}/{ids}")
    public AjaxResult operate(@PathVariable String operate, @PathVariable Long[] ids) throws Exception {
        int result = backendCustomerService.operate(operate, ids);
        return toAjax(result);
    }

    @DeleteMapping("/delete/{ids}")
    public AjaxResult deleteCustomers(@PathVariable Long[] ids) {
        int result = backendCustomerService.deleteCustomers(ids);
        return toAjax(result);
    }

    /**
     * 重置密码
     *
     * @param ids ids
     * @return 结果
     */
    @PutMapping("/reset/{ids}")
    public AjaxResult resetPassword(@PathVariable Long[] ids) {
        return backendCustomerService.resetPassword(ids);
    }
}
