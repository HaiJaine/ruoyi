package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.storage.domain.CustomerVO;
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
     * 查询客户
     *
     * @param params 参数
     * @return 结果
     */
    @Override
    public List<CustomerVO> findCustomers(Params params) {
        List<CustomerVO> customers = customerMapper.findCustomers(params);
        for (CustomerVO customer : customers) {
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

    /**
     * 新增顾客
     *
     * @param customerVO user
     * @return 结果
     */
    @Override
    public int createCustomer(CustomerVO customerVO) throws Exception {
        checkCustomer(customerVO);
        sexStringToNumber(customerVO);
        customerVO.setUserType("02");
        customerVO.setCreateTime(new Date());
        customerVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        customerVO.setPassword(SecurityUtils.encryptPassword("123456"));
        return customerMapper.createCustomer(customerVO);
    }

    /**
     * 检验客户信息（前端传入）
     *
     * @param customerVO 客户
     * @throws Exception 异常
     */
    private void checkCustomer(CustomerVO customerVO) throws Exception {
        String userName = customerVO.getUserName();
        if (userName == null) {
            userName = "";
        }
        if (userName.length() >= 16) {
            throw new Exception("客户名超过16位");
        }
        if (customerVO.getPhoneNumber().length() != 11) {
            throw new Exception("电话号码不为11位");
        }
        if (customerVO.getNickName().length() >= 10) {
            throw new Exception("姓名超过10位");
        }
        if (customerVO.getSex().length() > 1) {
            throw new Exception("性别超过1位");
        }
        if (!customerVO.getEmail().contains("@")) {
            throw new Exception("邮箱格式不对");
        }
    }

    /**
     * 编辑客户
     *
     * @param customerVO user
     * @return 结果
     */
    @Override
    public int updateCustomer(CustomerVO customerVO) throws Exception {
        checkCustomer(customerVO);
        sexStringToNumber(customerVO);
        CustomerVO customerMapperUserById = customerMapper.findUserById(customerVO.getUserId());
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
    public int operate(String operate, Long[] ids) throws Exception {
        int result = 0;
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        List<String> statuses = customerMapper.findCustomerByIds(map);
        String ENABLE = "0";
        if ("enable".equalsIgnoreCase(operate)) {
            boolean contains = statuses.contains(ENABLE);
            if (contains) {
                throw new Exception("用户已经启用");
            } else {
                map.put("status", ENABLE);
                result = customerMapper.isStatus(map);
            }
        } else if ("disable".equalsIgnoreCase(operate)) {
            String DISABLE = "1";
            boolean contains = statuses.contains(DISABLE);
            if (contains) {
                throw new Exception("用户已停用");
            } else {
                map.put("status", DISABLE);
                result = customerMapper.isStatus(map);
            }
        } else if ("delete".equalsIgnoreCase(operate)) {
            boolean contains = statuses.contains(ENABLE);
            if (contains) {
                throw new Exception("选择用户中包含未停用客户，删除失败！");
            } else {
                result = customerMapper.delete(map);
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


    /**
     * 将性别字符串转换为数字
     *
     * @param customerVO user
     */
    private void sexStringToNumber(CustomerVO customerVO) {
        String sex = customerVO.getSex();
        if ("男".equals(sex)) {
            customerVO.setSex("0");
        } else if ("女".equals(sex)) {
            customerVO.setSex("1");
        } else if ("未知".equals(sex)) {
            customerVO.setSex("2");
        }
    }


}
