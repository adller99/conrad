package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.OrderCreateRequest;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Andreas Hartmann
 */
@RestController
@RequestMapping("/factory")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class FactoryController {

    FactoryService factoryService;

    @PostMapping(value = "/enqueue")
    public final HttpStatus enqueue(@NonNull final OrderCreateRequest orderCreateRequest) {
        HttpStatus response = OK;

        try {
            factoryService.enqueue(orderCreateRequest);
        } catch (final Exception exception) {
            response = INTERNAL_SERVER_ERROR;
        }

        return response;
    }
}
