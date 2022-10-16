package de.conrad.codeworkshop.factory.factory;

import de.conrad.codeworkshop.factory.order.dto.Order;
import de.conrad.codeworkshop.factory.order.dto.OrderStatus;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Andreas Hartmann
 */
@Service
public class FactoryService {

    private final ConcurrentLinkedQueue<Order> manufacturingQueue = new ConcurrentLinkedQueue<>();

    /**
     * Changes order status to {@link OrderStatus#IN_PROGRESS} and puts it onto a queue
     * @param order order
     */
    public void enqueue(@NonNull final Order order) {
        val orderInProgress = order.withStatus(OrderStatus.IN_PROGRESS);
        manufacturingQueue.add(orderInProgress);
    }
}
