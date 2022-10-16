package de.conrad.codeworkshop.factory.services.order.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

import java.util.UUID;


import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.ACCEPTED;
import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.DECLINED;

/**
 * @author Andreas Hartmann
 */
@Builder
@Data
public class OrderConfirmation {

    OrderStatus status;
    UUID orderNumber;

    public static OrderConfirmation declined() {
        return OrderConfirmation.builder()
                .orderNumber(UUID.randomUUID())
                .status(DECLINED)
                .build();
    }

    public static OrderConfirmation accepted() {
        return OrderConfirmation.builder()
                .orderNumber(UUID.randomUUID())
                .status(ACCEPTED)
                .build();
    }

//    @Nullable
//    public OrderNumber getOrderNumber() {
//        return orderNumber;
//    }
//
//    @NotNull
//    public OrderStatus getStatus() {
//        return status;
//    }
}
