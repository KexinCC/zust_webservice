package org.xiaoheshan;

public class OrderServiceImpl implements OrderService{
    @Override
    public Order getOrder(String id) {
        return new Order(1, "order1", "order1 description");
    }
}
