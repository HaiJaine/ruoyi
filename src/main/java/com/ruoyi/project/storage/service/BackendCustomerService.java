package com.ruoyi.project.storage.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.domain.CustomerVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

public interface BackendCustomerService {
    List<CustomerVO> findCustomers(Params params);

    int createCustomer(CustomerVO customerVO) throws Exception;

    int updateCustomer(CustomerVO customerVO) throws Exception;

    int operate(String operate, Long[] ids) throws Exception;

    AjaxResult resetPassword(Long[] ids);
}
