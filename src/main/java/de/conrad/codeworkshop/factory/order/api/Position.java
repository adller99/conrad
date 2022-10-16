package de.conrad.codeworkshop.factory.order.api;

import de.conrad.codeworkshop.factory.order.validation.OrderQuantity;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @author Andreas Hartmann
 */
@Value
@Jacksonized
@Builder
public class Position {

    private static final int PRODUCT_ID_MIN_DIGITS = 100_000;
    private static final int PRODUCT_ID_MAX_DIGITS = 999_999_999;

    @Range(min = PRODUCT_ID_MIN_DIGITS, max = PRODUCT_ID_MAX_DIGITS)
    int productId;

    @OrderQuantity
    double quantity;
}
