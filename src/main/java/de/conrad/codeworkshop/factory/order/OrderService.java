package de.conrad.codeworkshop.factory.order;

import de.conrad.codeworkshop.factory.factory.FactoryService;
import de.conrad.codeworkshop.factory.order.api.OrderCreateRequest;
import de.conrad.codeworkshop.factory.order.dto.Order;
import de.conrad.codeworkshop.factory.order.dto.OrderConfirmation;
import de.conrad.codeworkshop.factory.order.dto.OrderStatus;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Andreas Hartmann
 */
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderService {

    FactoryService factoryService;

    /**
     * Creates order
     */
    @PostMapping("/create")
    public Order createOrder(@NonNull final OrderCreateRequest orderCreateRequest) {
        val orderConfirmation = OrderConfirmation.accepted();

        val order = Order.builder()
                .status(OrderStatus.ACCEPTED) //this step might be an overkill - it could go from PENDING -> IN_PROGRESS
                .positions(orderCreateRequest.getPositions())
                .orderConfirmation(orderConfirmation)
                .build();

        factoryService.enqueue(order);

        return order;
    }
}
