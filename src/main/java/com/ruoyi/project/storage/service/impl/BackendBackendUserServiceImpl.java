package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.User;
import com.ruoyi.project.storage.domain.vo.UserVO;
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

    /**
     * 查询所有用户
     *
     * @param params 查询条件
     * @return 结果
     */
    @Override
    public List<UserVO> findUsers(Params params) {
        return userMapper.findUsers(params);
    }

    /**
     * 查询用户是否存在（通过用户名）
     *
     * @param username 用户名
     * @return 结果
     */
    private Map<String, Object> findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    /**
     * 查询用户是否存在（通过邮箱）
     *
     * @param email 邮箱
     * @return 结果
     */
    private Map<String, Object> findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    /**
     * 查询用户是否存在（通过电话号码）
     *
     * @param phoneNumber 电话号码
     * @return 结果
     */
    private Map<String, Object> findUserByPhoneNumber(String phoneNumber) {
        return userMapper.findUserByPhoneNumber(phoneNumber);
    }

    /**
     * 新增用户
     *
     * @param userVO userVO
     * @return 结果
     */
    @Override
    public int createUser(UserVO userVO) {
        final Map<String, Object> byUsername = findUserByUsername(userVO.getUserName());
        final Map<String, Object> byEmail = findUserByEmail(userVO.getEmail());
        final Map<String, Object> byPhoneNumber = findUserByPhoneNumber(userVO.getPhonenumber());
        if ((Long) byUsername.get("count") > 0) {
            throw new CustomException("新增'" + userVO.getUserName() + "'失败，登录账号已存在");
        }
        if ((Long) byEmail.get("count") > 0) {
            throw new CustomException("新增'" + userVO.getUserName() + "'失败，邮箱账号已存在");
        }
        if ((Long) byPhoneNumber.get("count") > 0) {
            throw new CustomException("新增'" + userVO.getUserName() + "'失败，手机号已存在");
        }
        userVO.setUserType("01");
        userVO.setCreateTime(new Date());
        userVO.setCurrentPoints(0L);
        userVO.setVersion(0L);
        userVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        userVO.setPassword(SecurityUtils.encryptPassword("123456"));
        return userMapper.createUser(userVO);
    }


    /**
     * 更新用户
     *
     * @param userVO userVO
     * @return 结果
     */
    @Override
    public int updateUser(UserVO userVO) {
        final Map<String, Object> byEmail = findUserByEmail(userVO.getEmail());
        final Map<String, Object> byPhoneNumber = findUserByPhoneNumber(userVO.getPhonenumber());
        if ((Long) byEmail.get("count") > 0 && (((Long) byEmail.get("userId")).longValue() != userVO.getUserId().longValue())) {
            throw new CustomException("修改'" + userVO.getUserName() + "'失败，邮箱账号已存在");
        }
        if ((Long) byPhoneNumber.get("count") > 0 && (((Long) byPhoneNumber.get("userId")).longValue() != userVO.getUserId().longValue())) {
            throw new CustomException("修改'" + userVO.getUserName() + "'失败，手机号已存在");
        }
        userVO.setUpdateTime(new Date());
        userVO.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        return userMapper.updateUser(userVO);
    }

    /**
     * 启用、停用用户
     *
     * @param operate operate
     * @param ids     ids
     * @return 结果
     */
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

    /**
     * 重置密码
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public int resetPassword(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("password", SecurityUtils.encryptPassword("123456"));
        return userMapper.resetPassword(map);
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @return
     */
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

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
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
