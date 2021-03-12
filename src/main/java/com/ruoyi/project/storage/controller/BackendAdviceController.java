package com.ruoyi.project.storage.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
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
        return getOrders();
    }

    /*
    返回分页
     */
    @PostMapping("page")
    public TableDataInfo test3() {
        startPage();
        List<Order> orders = getOrders();
        return getDataTable(orders);
    }

    private List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        Order order5 = new Order();
        Order order6 = new Order();
        Order order7 = new Order();
        Order order8 = new Order();
        Order order9 = new Order();
        Order order10 = new Order();
        order1.setOrderName("张三");
        order2.setOrderName("李四");
        order3.setOrderName("王五");
        order4.setOrderName("赵六");
        order5.setOrderName("赵六");
        order6.setOrderName("赵六");
        order7.setOrderName("赵六");
        order8.setOrderName("赵六");
        order9.setOrderName("赵六");
        order10.setOrderName("赵六");
        order1.setUpdateTime(new Date());
        order2.setUpdateTime(new Date());
        order3.setUpdateTime(new Date());
        order4.setUpdateTime(new Date());
        order5.setUpdateTime(new Date());
        order6.setUpdateTime(new Date());
        order7.setUpdateTime(new Date());
        order8.setUpdateTime(new Date());
        order9.setUpdateTime(new Date());
        order10.setUpdateTime(new Date());
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
        orders.add(order10);
        return orders;
    }
}
