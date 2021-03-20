package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.domain.UserVO;
import com.ruoyi.project.storage.mapper.UserMapper;
import com.ruoyi.project.storage.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackendBackendUserServiceImpl implements BackendUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVO> findUsers(Params params) {
        return userMapper.findUsers(params);
    }

    @Override
    public int createUser(UserVO userVO) {
        userVO.setUserType("01");
        userVO.setCreateTime(new Date());
        userVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        userVO.setPassword(SecurityUtils.encryptPassword("123456"));
        return userMapper.createUser(userVO);
    }

//    private void sexStringToNumber(UserVO userVO) {
//        String sex = userVO.getSex();
//        if ("男".equals(sex)) {
//            userVO.setSex("0");
//        } else if ("女".equals(sex)) {
//            userVO.setSex("1");
//        } else if ("未知".equals(sex)) {
//            userVO.setSex("2");
//        }
//    }

    @Override
    public int updateUser(UserVO userVO) {
//        sexStringToNumber(userVO);
        userVO.setUpdateTime(new Date());
        userVO.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        return userMapper.updateUser(userVO);
    }

    @Override
    public int operate(String operate, Long[] ids) {
        int result = 0;
        Map<String, Object> map = new HashMap<>();
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

    @Override
    public int deleteUsers(Long[] ids) {
        int result;
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        List<String> statuses = userMapper.findCustomerByIds(map);
        boolean contains = statuses.contains("0");
        if (contains) {
            throw new CustomException("选择用户中包含未停用客户，删除失败！");
        } else {
            result = userMapper.delete(map);
        }
        return result;
    }
}
