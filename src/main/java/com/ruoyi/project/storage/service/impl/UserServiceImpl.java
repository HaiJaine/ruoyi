package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.mapper.UserMapper;
import com.ruoyi.project.storage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        sexStringToNumber(user);
        user.setUserType("01");
        user.setCreateTime(new Date());
        user.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        return userMapper.createUser(user);
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

    @Override
    public int updateUser(User user) {
        sexStringToNumber(user);
        user.setUpdateTime(new Date());
        user.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        return userMapper.updateUser(user);
    }

    @Override
    public int operate(String operate, Long[] ids) {
        int result = 0;
        Map<String, Object> map = new HashMap();
        map.put("ids", ids);
        if ("enable".equalsIgnoreCase(operate)) {
            map.put("status", 0);
            result = userMapper.isStatus(map);
        } else if ("disable".equalsIgnoreCase(operate)) {
            map.put("status", 1);
            result = userMapper.isStatus(map);
        } else if ("delete".equalsIgnoreCase(operate)) {
            result = userMapper.delete(map);
        }
        return result;
    }

    @Override
    public int resetPassword(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("password", SecurityUtils.encryptPassword("123456"));
        return userMapper.resetPassword(map);
    }

    @Override
    public int updatePassword(String oldPassword, String newPassword) {
        int result = 0;
        User user = new User();

        //判断输入旧密码与当前用户的旧密码是否相等
        if (SecurityUtils.matchesPassword(oldPassword, SecurityUtils.getLoginUser().getPassword())) {
            user.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
            user.setPassword(SecurityUtils.encryptPassword(newPassword));
            result = userMapper.updatePassword(user);
        }
        return result;
    }
}
