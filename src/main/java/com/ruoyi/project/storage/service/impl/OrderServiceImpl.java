package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.mapper.OrderMapper;
import com.ruoyi.project.storage.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:13
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> findOrderList(Params params) {
        return orderMapper.findOrderList(params);
    }

    @Override
    public List<OrderVO> findOrderInfo(Long id) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        return orderMapper.findOrderInfo(orderVO);
    }

    @Override
    public int operateOrder(Long id, Integer operate, Long version) {
        //TODO 操作订单业务逻辑
        return 0;
    }
}
