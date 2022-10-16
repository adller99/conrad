package de.conrad.codeworkshop.factory.services.order;

import de.conrad.codeworkshop.factory.services.order.api.OrderCreateRequest;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Andreas Hartmann
 */
@RestController
@RequestMapping("/order")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderController {

    OrderService factoryOrderService;

    @PostMapping("/create")
    public OrderConfirmation createOrder(@Valid @RequestBody final OrderCreateRequest orderCreateRequest) {
        return factoryOrderService.createOrder(orderCreateRequest);
    }
}
