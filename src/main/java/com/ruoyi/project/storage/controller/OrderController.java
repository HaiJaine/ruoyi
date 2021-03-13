package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.domain.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.service.OrderService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 订单查询（多条件，分页）
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo getOrderList(Params params) {
        startPage();
        List<OrderVO> orderVOList = orderService.findOrderList(params);
        return getDataTable(orderVOList);
    }

    @GetMapping("/info/{id}")
    public TableDataInfo getInfo(@PathVariable Long id) {
        startPage();
        List<OrderVO> orderInfo = orderService.findOrderInfo(id);
        return getDataTable(orderInfo);
    }
}
