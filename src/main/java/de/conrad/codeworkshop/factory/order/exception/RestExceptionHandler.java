package de.conrad.codeworkshop.factory.order.exception;

import de.conrad.codeworkshop.factory.order.OrderController;
import de.conrad.codeworkshop.factory.order.dto.OrderConfirmation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = OrderController.class)
public class RestExceptionHandler {

    //todo: use only classes associated with validations
    @ExceptionHandler(Exception.class)
    public ResponseEntity<OrderConfirmation> handleException(final Exception e) {
        //todo: process errors and send it to the client?

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(OrderConfirmation.declined());
    }
}
