package de.conrad.codeworkshop.factory.order.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This validator handles quantity validation for following cases:
 * divisible by 10
 * or less than one and larger than 0
 * or exactly 42.42
 */
public class OrderQuantityValidator implements ConstraintValidator<OrderQuantity, Double> {

    private static final double MAGIC_42_NUMBER = 42.42D;

    @Override
    public boolean isValid(final Double value,
                           final ConstraintValidatorContext context) {
        if (value == MAGIC_42_NUMBER) {
            return true;
        }

        if (value % 10 == 0) {
            return true;
        }

        if (value < 1 && value > 0) {
            return true;
        }

        return false;
    }
}
