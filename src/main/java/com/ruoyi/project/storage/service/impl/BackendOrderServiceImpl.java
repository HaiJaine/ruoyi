package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.vo.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.mapper.OrderMapper;
import com.ruoyi.project.storage.service.BackendOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LongHaiJiang
 * @date 2021/3/13 21:13
 */
@Service
public class BackendOrderServiceImpl implements BackendOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> findOrderList(Params params) {
        return orderMapper.findOrderList(params);
    }

    @Override
    public OrderVO findOrderInfo(Long id) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        return orderMapper.findOrderInfo(orderVO);
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int operateOrder(Long id, Integer operate, Long version) {
        OrderVO orderInfo = findOrderInfo(id);
        orderInfo.setStatus(operate);
        orderInfo.setUpdateBy(String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId()));
        int result = orderMapper.operateOrder(orderInfo);
        if (result <= 0) {
            throw new CustomException("操作失败");
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int deleteOrder(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("updateBy", String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId()));
        List<Integer> orderStatus = orderMapper.findOrderStatus(map);
        if (!orderStatus.contains(10)) {
            throw new CustomException("选中订单包含未完成订单，删除失败！");
        }
        int result = orderMapper.deleteOrder(map);
        if (result <= 0) {
            throw new CustomException("删除失败");
        }
        return result;
    }
}
