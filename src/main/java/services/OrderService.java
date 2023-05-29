package services;

import model.Order;
import repos.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order makeOrder(Order orderDto) {
        return orderRepository.addOrder(orderDto);
    }

    public Order getOrder(Integer orderId) {
        return orderRepository.getOrderById(orderId);
    }
}
