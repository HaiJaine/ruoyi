package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.storage.domain.vo.OrderVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.service.BackendOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 21:14
 */
@RestController
@RequestMapping("/backend/order")
public class BackendOrderController extends BaseController {
    @Resource
    private BackendOrderService backendOrderService;

    /**
     * 订单查询（多条件，分页）
     *
     * @param params 参数
     * @return 结果
     */
    @GetMapping("/list")
    public TableDataInfo getOrderList(Params params) {
        startPage();
        List<OrderVO> orderList = backendOrderService.findOrderList(params);
        return getDataTable(orderList);
    }

    /**
     * 订单详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/info/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        startPage();
        OrderVO orderInfo = backendOrderService.findOrderInfo(id);
        return AjaxResult.success(orderInfo);
    }

    /**
     * 订单操作
     *
     * @param id      id
     * @param operate 操作
     * @param version 版本
     * @return 结果
     */
    @PutMapping("/operate/{id}/{operate}/{version}")
    public AjaxResult operateOrder(@PathVariable Long id, @PathVariable Integer operate, @PathVariable Long version) {
        int result = backendOrderService.operateOrder(id, operate, version);
        return toAjax(result);
    }

    /**
     * 删除订单
     *
     * @param ids ids
     * @return 结果
     */
    @DeleteMapping("/delete/{ids}")
    public AjaxResult deleteOrder(@PathVariable Long[] ids) {
        int result = backendOrderService.deleteOrder(ids);
        return toAjax(result);
    }
}
