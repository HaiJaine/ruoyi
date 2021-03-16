package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Order;
import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<OrderVO> findOrderList(Params params);

    List<OrderVO> findOrderInfo(Order order);

    int deleteOrder(Map<String, Object> map);
}