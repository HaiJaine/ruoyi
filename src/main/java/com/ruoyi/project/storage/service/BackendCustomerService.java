package com.ruoyi.project.storage.service;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.domain.vo.CustomerVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;
/**
 * @author LongHaijiang
 * @date 2021/3/13 21:12
 */
public interface BackendCustomerService {
    List<CustomerVO> findCustomers(Params params);

    int createCustomer(CustomerVO customerVO) throws CustomException;

    int updateCustomer(CustomerVO customerVO) throws CustomException;

    int operate(String operate, Long[] ids) throws CustomException;

    AjaxResult resetPassword(Long[] ids);

    int deleteCustomers(Long[] ids);
}
