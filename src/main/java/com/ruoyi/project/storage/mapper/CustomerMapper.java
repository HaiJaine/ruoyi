package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.CustomerVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<CustomerVO> findCustomers(Params params);

    int createCustomer(CustomerVO customerVO);

    int updateCustomer(CustomerVO customerVO);

    int isStatus(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int resetPassword(Map<String, Object> map);

    List<String> findCustomerByIds(Map<String, Object> ids);

    CustomerVO findCustomerById(Long id);

    Map<String, Object> findCustomerByUsername(String username);

    Map<String, Object> findCustomerByEmail(String email);

    Map<String, Object> findCustomerByPhoneNumber(String phoneNumber);
}
