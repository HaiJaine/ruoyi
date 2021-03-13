package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.OrderVO;

import java.util.List;

public interface OrderMapper {
    List<OrderVO> findOrderList(OrderVO orderVO);
}