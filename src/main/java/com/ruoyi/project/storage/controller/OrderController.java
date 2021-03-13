package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:14
 */
@RestController
@RequestMapping("/backend/order")
public class OrderController extends BaseController {
    @Resource
    private OrderService orderService;

    @GetMapping("/list")
    public TableDataInfo getOrderList(Params params) {
        startPage();
        List<OrderVO> orderVOList = orderService.findOrderList(params);
        return getDataTable(orderVOList);
    }
}
