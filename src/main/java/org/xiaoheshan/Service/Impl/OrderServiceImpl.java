package org.xiaoheshan.Service.Impl;


import org.xiaoheshan.pojo.Order;
import org.xiaoheshan.Service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrder(String id) {
        Order order = new Order(1, "order1", "order1 description");
        return order;
    }
}
