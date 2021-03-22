package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.domain.vo.CustomerVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.mapper.CustomerMapper;
import com.ruoyi.project.storage.service.BackendCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackendBackendCustomerServiceImpl implements BackendCustomerService {

    @Resource
    private CustomerMapper customerMapper;

    /**
     * 查询所有客户
     *
     * @param params 参数
     * @return 结果
     */
    @Override
    public List<CustomerVO> findCustomers(Params params) {
        return customerMapper.findCustomers(params);
    }

    /**
     * 查询用户是否存在（通过用户名）
     *
     * @param username 用户名
     * @return 结果
     */
    private Map<String, Object> findCustomerByUsername(String username) {
        return customerMapper.findCustomerByUsername(username);
    }

    /**
     * 查询用户是否存在（通过邮箱）
     *
     * @param email 邮箱
     * @return 结果
     */
    private Map<String, Object> findCustomerByEmail(String email) {
        return customerMapper.findCustomerByEmail(email);
    }

    /**
     * 查询用户是否存在（通过电话号码）
     *
     * @param phoneNumber 电话号码
     * @return 结果
     */
    private Map<String, Object> findCustomerByPhoneNumber(String phoneNumber) {
        return customerMapper.findCustomerByPhoneNumber(phoneNumber);
    }


    /**
     * 新增顾客
     *
     * @param customerVO user
     * @return 结果
     */
    @Override
    public int createCustomer(CustomerVO customerVO) throws CustomException {
        final Map<String, Object> byUsername = findCustomerByUsername(customerVO.getUserName());
        final Map<String, Object> byEmail = findCustomerByEmail(customerVO.getEmail());
        final Map<String, Object> byPhoneNumber = findCustomerByPhoneNumber(customerVO.getPhonenumber());
        if ((Long) byUsername.get("count") > 0) {
            throw new CustomException("新增'" + customerVO.getUserName() + "'失败，登录账号已存在");
        }
        if ((Long) byEmail.get("count") > 0) {
            throw new CustomException("新增'" + customerVO.getUserName() + "'失败，邮箱账号已存在");
        }
        if ((Long) byPhoneNumber.get("count") > 0) {
            throw new CustomException("新增'" + customerVO.getUserName() + "'失败，手机号已存在");
        }
        checkCustomer(customerVO);
        customerVO.setUserType("02");
        customerVO.setCreateTime(new Date());
        customerVO.setCurrentPoints(0L);
        customerVO.setVersion(0L);
        customerVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        customerVO.setPassword(SecurityUtils.encryptPassword("123456"));
        return customerMapper.createCustomer(customerVO);
    }

    /**
     * 检验客户信息（前端传入）
     *
     * @param customerVO 客户
     * @throws CustomException 异常
     */
    private void checkCustomer(CustomerVO customerVO) throws CustomException {
        String userName = customerVO.getUserName();
        if (userName == null) {
            userName = "";
        }
        if (userName.length() >= 16) {
            throw new CustomException("客户名超过16位");
        }
        if (customerVO.getPhonenumber().length() != 11) {
            throw new CustomException("电话号码不为11位");
        }
        if (customerVO.getNickName().length() >= 10) {
            throw new CustomException("姓名超过10位");
        }
        if (!customerVO.getEmail().contains("@")) {
            throw new CustomException("邮箱格式不对");
        }
    }

    /**
     * 编辑客户
     *
     * @param customerVO user
     * @return 结果
     */
    @Override
    public int updateCustomer(CustomerVO customerVO) throws CustomException {
        final Map<String, Object> byEmail = findCustomerByEmail(customerVO.getEmail());
        final Map<String, Object> byPhoneNumber = findCustomerByPhoneNumber(customerVO.getPhonenumber());
        if ((Long) byEmail.get("count") > 0 && (((Long) byEmail.get("userId")).longValue() != customerVO.getUserId().longValue())) {
            throw new CustomException("修改'" + customerVO.getUserName() + "'失败，邮箱账号已存在");
        }
        if ((Long) byPhoneNumber.get("count") > 0 && (((Long) byPhoneNumber.get("userId")).longValue() != customerVO.getUserId().longValue())) {
            throw new CustomException("修改'" + customerVO.getUserName() + "'失败，手机号已存在");
        }
        checkCustomer(customerVO);
        CustomerVO customerMapperUserById = customerMapper.findCustomerById(customerVO.getUserId());
        customerVO.setVersion(customerMapperUserById.getVersion());
        customerVO.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        return customerMapper.updateCustomer(customerVO);
    }

    /**
     * 操作客户（启用，停用，删除）
     *
     * @param operate 操作
     * @param ids     ids
     * @return 结果
     */
    @Override
    public int operate(String operate, Long[] ids) throws CustomException {
        int result = 0;
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        List<String> statuses = customerMapper.findCustomerByIds(map);
        String ENABLE = "0";
        if ("enable".equalsIgnoreCase(operate)) {
            boolean contains = statuses.contains(ENABLE);
            if (contains) {
                throw new CustomException("用户已经启用");
            } else {
                map.put("status", ENABLE);
                result = customerMapper.isStatus(map);
            }
        } else if ("disable".equalsIgnoreCase(operate)) {
            String DISABLE = "1";
            boolean contains = statuses.contains(DISABLE);
            if (contains) {
                throw new CustomException("用户已停用");
            } else {
                map.put("status", DISABLE);
                result = customerMapper.isStatus(map);
            }
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
    public AjaxResult resetPassword(Long[] ids) {
        AjaxResult ajaxResult;
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("ids", ids);
            map.put("password", SecurityUtils.encryptPassword("123456"));
            customerMapper.resetPassword(map);
            ajaxResult = new AjaxResult(HttpStatus.SUCCESS, "重置密码成功");
        } catch (Exception e) {
            ajaxResult = new AjaxResult(HttpStatus.ERROR, "重置密码失败");
        }
        return ajaxResult;
    }

    @Override
    public int deleteCustomers(Long[] ids) {
        int result;
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        List<String> statuses = customerMapper.findCustomerByIds(map);
        boolean contains = statuses.contains("0");
        if (contains) {
            throw new CustomException("选择用户中包含未停用客户，删除失败！");
        } else {
            result = customerMapper.delete(map);
        }
        return result;
    }

}
