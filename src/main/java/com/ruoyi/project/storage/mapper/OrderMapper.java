package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

public interface OrderMapper {
    List<OrderVO> findOrderList(Params params);
}