package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.vo.OrderVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

/**
 * @author LongHaijiang
 * @date 2021/3/13 21:12
 */
public interface BackendOrderService {
    List<OrderVO> findOrderList(Params params);

    OrderVO findOrderInfo(Long id);

    int operateOrder(Long id, Integer operate, Long version);

    int deleteOrder(Long[] ids);
}
