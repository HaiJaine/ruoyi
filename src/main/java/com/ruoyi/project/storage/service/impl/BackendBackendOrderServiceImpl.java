package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.Order;
import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.mapper.OrderMapper;
import com.ruoyi.project.storage.service.BackendOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:13
 */
@Service
public class BackendBackendOrderServiceImpl implements BackendOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> findOrderList(Params params) {
        return orderMapper.findOrderList(params);
    }

    @Override
    public List<OrderVO> findOrderInfo(Long id) {
        Order order = new Order();
        order.setId(id);
        return orderMapper.findOrderInfo(order);
    }

    @Override
    public int operateOrder(Long id, Integer operate, Long version) {
        //TODO 操作订单业务逻辑
        return 0;
    }

    @Override
    public int deleteOrder(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        return orderMapper.deleteOrder(map);
    }
}
