package de.conrad.codeworkshop.factory.services.order.api;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.*;


/**
 * This POJO xxxxtodo
 */
@Value
@Jacksonized
@Builder
public class OrderCreateRequest {

    List<Position> positions;
    OrderConfirmation orderConfirmation;
//    @Builder.Default
    OrderStatus status = PENDING;

    public void validate() {
//        if (!positions.isEmpty() && status == PENDING) {
//            status = ACCEPTED;
//        } else {
//            status = DECLINED;
//        }
    }
}
