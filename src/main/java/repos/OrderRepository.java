package repos;

import model.Dish;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

    List<Order> orders = new ArrayList<>();

    default Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

    default Order getOrderById(Integer orderId) {
        // Находим заказ по указанному id
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
