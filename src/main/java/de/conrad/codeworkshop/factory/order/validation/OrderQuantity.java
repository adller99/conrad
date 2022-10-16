package de.conrad.codeworkshop.factory.order.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = OrderQuantityValidator.class)
@Documented
public @interface OrderQuantity {

    String message() default "The quantity doesn't meet required criteria";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
