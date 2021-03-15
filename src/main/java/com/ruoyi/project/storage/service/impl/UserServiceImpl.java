package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.mapper.UserMapper;
import com.ruoyi.project.storage.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findUsers(Params params) {
        List<User> users = userMapper.findUsers(params);
        for (User user : users) {
            String sex = user.getSex();
            if ("0".equals(sex)) {
                user.setSex("男");
            } else if ("1".equals(sex)) {
                user.setSex("女");
            } else if ("2".equals(sex)) {
                user.setSex("未知");
            }
        }
        return users;
    }

    @Override
    public int createUser(User user) {
        String sex = user.getSex();
        if ("男".equals(sex)) {
            user.setSex("0");
        } else if ("女".equals(sex)) {
            user.setSex("1");
        } else if ("未知".equals(sex)) {
            user.setSex("2");
        }
        user.setUserType("01");
        user.setCreateTime(new Date());
        user.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        return userMapper.createUser(user);
    }
}
