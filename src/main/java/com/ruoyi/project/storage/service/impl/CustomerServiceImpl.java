package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.mapper.CustomerMapper;
import com.ruoyi.project.storage.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        sexStringToNumber(user);
        user.setUserType("02");
        user.setCreateTime(new Date());
        user.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        return customerMapper.createCustomer(user);
    }

    @Override
    public int updateCustomer(User user) {
        sexStringToNumber(user);
        user.setUpdateTime(new Date());
        user.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        return customerMapper.updateCustomer(user);
    }

    @Override
    public int operate(String operate, Long[] ids) {
        int result = 0;
        Map<String, Object> map = new HashMap();
        map.put("ids", ids);
        if ("enable".equalsIgnoreCase(operate)) {
            map.put("status", 0);
            result = customerMapper.isStatus(map);
        } else if ("disable".equalsIgnoreCase(operate)) {
            map.put("status", 1);
            result = customerMapper.isStatus(map);
        } else if ("delete".equalsIgnoreCase(operate)) {
            result = customerMapper.delete(map);
        }
        return result;
    }

    @Override
    public int resetPassword(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("password", SecurityUtils.encryptPassword("123456"));
        return customerMapper.resetPassword(map);
    }


    private void sexStringToNumber(User user) {
        String sex = user.getSex();
        if ("男".equals(sex)) {
            user.setSex("0");
        } else if ("女".equals(sex)) {
            user.setSex("1");
        } else if ("未知".equals(sex)) {
            user.setSex("2");
        }
    }
}
