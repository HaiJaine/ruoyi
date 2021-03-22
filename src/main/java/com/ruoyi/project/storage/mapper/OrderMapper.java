package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.OrderVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<OrderVO> findOrderList(Params params);

    OrderVO findOrderInfo(OrderVO orderVO);

    int deleteOrder(Map<String, Object> map);

    int operateOrder(OrderVO orderInfo);

    List<Integer> findOrderStatus(Map<String, Object> map);
}