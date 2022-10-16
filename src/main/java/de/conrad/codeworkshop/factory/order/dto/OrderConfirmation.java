package de.conrad.codeworkshop.factory.order.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static de.conrad.codeworkshop.factory.order.dto.OrderStatus.ACCEPTED;
import static de.conrad.codeworkshop.factory.order.dto.OrderStatus.DECLINED;


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
}
