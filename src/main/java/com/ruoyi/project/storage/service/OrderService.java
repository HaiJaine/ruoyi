package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.OrderVO;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:12
 */
public interface OrderService {
    List<OrderVO> findOrderList();
}
