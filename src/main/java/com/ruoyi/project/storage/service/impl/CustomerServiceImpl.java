package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.mapper.CustomerMapper;
import com.ruoyi.project.storage.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<User> findCustomers(Params params) {
        List<User> customers = customerMapper.findCustomers(params);
        for (User customer : customers) {
            String sex = customer.getSex();
            if ("0".equals(sex)) {
                customer.setSex("男");
            } else if ("1".equals(sex)) {
                customer.setSex("女");
            } else if ("2".equals(sex)) {
                customer.setSex("未知");
            }
        }
        return customers;

    }

    @Override
    public int createCustomer(User user) {
        return 0;
    }

    @Override
    public int updateCustomer(User user) {
        return 0;
    }

    @Override
    public int operate(String operate, Long[] ids) {
        return 0;
    }

    @Override
    public int resetPassword(Long[] ids) {
        return 0;
    }

    @Override
    public int updatePassword(String oldPassword, String newPassword) {
        return 0;
    }
}
