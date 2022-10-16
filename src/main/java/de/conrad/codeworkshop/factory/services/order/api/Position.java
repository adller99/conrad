package de.conrad.codeworkshop.factory.services.order.api;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

/**
 * @author Andreas Hartmann
 */
@Value
@Jacksonized
@Builder
public class Position {
    int productId;
    int quantity;

//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }
//
//    public BigDecimal getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(BigDecimal quantity) {
//        this.quantity = quantity;
//    }
}
