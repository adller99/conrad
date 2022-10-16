package de.conrad.codeworkshop.factory.order;

import de.conrad.codeworkshop.factory.order.api.OrderCreateRequest;
import de.conrad.codeworkshop.factory.order.dto.OrderConfirmation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validator;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Andreas Hartmann
 */
@RestController
@RequestMapping("/order")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderController {
    OrderService factoryOrderService;

    @PostMapping(value = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderConfirmation createOrder(@Valid @RequestBody final OrderCreateRequest orderCreateRequest) {
        val order = factoryOrderService.createOrder(orderCreateRequest);

        return order.getOrderConfirmation();
    }
}
