package online.store.services;

import online.store.model.Order;
import online.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private final OrderRepository orderRepository;

    private final long maxNumberOfItems;

    public OrdersService(OrderRepository orderRepository, @Value("${products.service.max-number-of-items:25}")long maxNumberOfItems) {
        this.orderRepository = orderRepository;
        this.maxNumberOfItems = maxNumberOfItems;
    }

    public void placeOrders(Iterable<Order> orders) {
        validateNumberOfItemsOrdered(orders);

        orderRepository.saveAll(orders);
    }

    public void validateNumberOfItemsOrdered(Iterable<Order> orders){
        long totalNumberOfItems = 0;
        for (Order order: orders){
            totalNumberOfItems += order.getQuantity();
        }
        if (totalNumberOfItems > maxNumberOfItems){
            throw new IllegalStateException(String.format("Number of products %d exceeded the limit of %d",
                    totalNumberOfItems, maxNumberOfItems));
        }
    }


}
