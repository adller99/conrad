package de.conrad.codeworkshop.factory.services.order;

import de.conrad.codeworkshop.factory.services.factory.FactoryController;
import de.conrad.codeworkshop.factory.services.order.api.OrderCreateRequest;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.ACCEPTED;

/**
 * @author Andreas Hartmann
 */
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderService {

    FactoryController factoryController;

    /**
     * Validates the input order. If it is valid, it is enqueued in the factory via the factoryController. Either way an
     * appropriate order confirmation is returned.
     */
    @PostMapping("/create")
    public OrderConfirmation createOrder(final OrderCreateRequest orderCreateRequest) {
        orderCreateRequest.validate();

        if (orderCreateRequest.getStatus() == ACCEPTED) {
           val orderConfirmation = OrderConfirmation.accepted();
//            order.setOrderConfirmation(orderConfirmation);

            factoryController.enqueue(orderCreateRequest);

            return orderConfirmation;
        }

        return OrderConfirmation.declined();
    }
}
