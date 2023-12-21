// UserService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Order createOrder(List<GroceryItem> orderItems) {
        Order order = new Order();
        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }
}
