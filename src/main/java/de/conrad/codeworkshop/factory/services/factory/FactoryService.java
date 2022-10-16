package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.OrderCreateRequest;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Andreas Hartmann
 */
@Service
class FactoryService {

    private final ConcurrentLinkedQueue<OrderCreateRequest> manufacturingQueue = new ConcurrentLinkedQueue<>();

    void enqueue(@NonNull final OrderCreateRequest orderCreateRequest) {
//        order.setStatus(OrderStatus.IN_PROGRESS);
        manufacturingQueue.add(orderCreateRequest);
    }
}
