package de.conrad.codeworkshop.factory.order.api;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * This POJO is used for Order creation request
 */
@Value
@Jacksonized
@Builder
public class OrderCreateRequest {

    @Valid
    @NotEmpty
    List<Position> positions;

    @NotNull
    OrderCreationStatus status;
}
