package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.storage.domain.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 意见管理
 *
 * @author HaiJaine
 * @date 2021/3/12 8:09
 */
@RestController
@RequestMapping("/advice")
public class BackendAdviceController extends BaseController {
    @PostMapping("/list")
    public String getAdviceList() {
        return "test";
    }

    @PostMapping("list1")
    public Order test1() {
        Order order = new Order();
        order.setOrderName("张三");
        order.setUpdateTime(new Date());
        return order;
    }
}
