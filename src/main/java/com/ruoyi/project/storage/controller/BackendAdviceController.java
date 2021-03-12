package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.storage.domain.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 意见管理
 *
 * @author HaiJaine
 * @date 2021/3/12 8:09
 */
@RestController
@RequestMapping("/advice")
public class BackendAdviceController extends BaseController {
    @PostMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("test1")
    public Order test1() {
        Order order = new Order();
        order.setOrderName("张三");
        order.setUpdateTime(new Date());
        return order;
    }

    @PostMapping("test2")
    public List<Order> test2() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        order1.setOrderName("张三");
        order2.setOrderName("李四");
        order3.setOrderName("王五");
        order4.setOrderName("赵六");
        order1.setUpdateTime(new Date());
        order2.setUpdateTime(new Date());
        order3.setUpdateTime(new Date());
        order4.setUpdateTime(new Date());
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        return orders;
    }
}
