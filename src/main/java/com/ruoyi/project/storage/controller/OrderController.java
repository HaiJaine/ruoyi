package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
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
     * @param params 参数
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getOrderList(Params params) {
        startPage();
        List<OrderVO> orderVOList = orderService.findOrderList(params);
        return getDataTable(orderVOList);
    }

    /**
     * 订单详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/info/{id}")
    public TableDataInfo getInfo(@PathVariable Long id) {
        startPage();
        List<OrderVO> orderInfo = orderService.findOrderInfo(id);
        return getDataTable(orderInfo);
    }

    @PutMapping("/operate/{id}/{operate}/{version}")
    public AjaxResult operateOrder(@PathVariable Long id, @PathVariable Integer operate, @PathVariable Long version) {
        int result = orderService.operateOrder(id, operate, version);
        return toAjax(result);
    }
}
