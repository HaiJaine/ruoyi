package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:12
 */
public interface OrderService {
    List<OrderVO> findOrderList(Params params);

    List<OrderVO> findOrderInfo(Long id);

    int operateOrder(Long id, Integer operate, Long version);

    int deleteOrder(Long[] ids);
}
