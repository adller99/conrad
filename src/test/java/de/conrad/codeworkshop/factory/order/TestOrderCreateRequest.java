package de.conrad.codeworkshop.factory.order;

import de.conrad.codeworkshop.factory.order.api.Position;
import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Test Order creation request POJO
 */
@Value
@Builder
public class TestOrderCreateRequest {

    @Valid
    @NotEmpty
    List<Position> positions;

    @NotNull
    String status;

}
