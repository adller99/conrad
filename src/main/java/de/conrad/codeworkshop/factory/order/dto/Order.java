package de.conrad.codeworkshop.factory.order.dto;

import de.conrad.codeworkshop.factory.order.api.Position;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.List;

/**
 * This class represents Order entity
 */
@Value
@Builder
@With
public class Order {

    List<Position> positions;

    OrderConfirmation orderConfirmation;

    OrderStatus status;

}
