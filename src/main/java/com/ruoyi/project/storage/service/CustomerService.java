package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;

import java.util.List;

public interface CustomerService {
    List<User> findCustomers(Params params);

    int createCustomer(User user);

    int updateCustomer(User user);

    int operate(String operate, Long[] ids);

    int resetPassword(Long[] ids);

    int updatePassword(String oldPassword, String newPassword);
}
