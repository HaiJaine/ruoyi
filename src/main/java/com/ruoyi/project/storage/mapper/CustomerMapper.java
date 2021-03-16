package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<User> findCustomers(Params params);

    int createCustomer(User user);

    int updateCustomer(User user);

    int isStatus(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int resetPassword(Map<String, Object> map);

}
