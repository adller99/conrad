package de.conrad.codeworkshop.factory.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.conrad.codeworkshop.factory.order.api.Position;
import de.conrad.codeworkshop.factory.order.dto.OrderConfirmation;
import de.conrad.codeworkshop.factory.order.dto.OrderStatus;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MvcIntegrationTest
public class OrderControllerTest {

    private static final String ORDER_CREATION_ENDPOINT = "/order/create";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @ParameterizedTest
    @MethodSource("invalidOrders")
    @SneakyThrows
    public void test_order_request_creation(String title,
                                               int productId,
                                               double quantity,
                                               String status,
                                               ResultMatcher expectedHttpStatus,
                                               OrderStatus expectedOrderStatus) {
        val position = Position.builder()
                .productId(productId)
                .quantity(quantity)
                .build();

        val orderCreationRequest = TestOrderCreateRequest.builder()
                .positions(List.of(position))
                .status(status)
                .build();

        val response = mockMvc.perform(post(ORDER_CREATION_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderCreationRequest)))
                .andExpect(expectedHttpStatus)
                .andReturn();

        val stringResponse = response.getResponse().getContentAsString();
        val orderConfirmation = objectMapper.readValue(stringResponse, OrderConfirmation.class);

        assertEquals(orderConfirmation.getStatus(), expectedOrderStatus);
    }

    private static Stream<Arguments> invalidOrders() {
        return Stream.of(
                //positive scenarios
                Arguments.of("test valid request payload",
                        856_325_478, 50, "PENDING", status().isOk(), OrderStatus.ACCEPTED),

                Arguments.of("test valid request payload - quantity is exactly 42.42",
                        563_254_78, 42.42D, "PENDING", status().isOk(), OrderStatus.ACCEPTED),

                Arguments.of("test valid request payload - quantity is  less than one and larger than 0",
                        563_254_78, 0.3D, "PENDING", status().isOk(), OrderStatus.ACCEPTED),

                //negative scenarios
                Arguments.of("test invalid request: productId has less than 6 digits",
                        965_12, 50, "PENDING", status().isBadRequest(), OrderStatus.DECLINED),

                Arguments.of("test invalid request: status is not PENDING",
                        965_12, 50, "ACCEPTED", status().isBadRequest(), OrderStatus.DECLINED),

                Arguments.of("test invalid request: productId has more than 9 digits",
                        214_748_364_1, 50, "PENDING", status().isBadRequest(), OrderStatus.DECLINED),

                Arguments.of("test invalid request: quantity is not divisible by 10",
                        965_12, 51, "PENDING", status().isBadRequest(), OrderStatus.DECLINED),

                Arguments.of("test invalid request: quantity is not less than one and larger than 0",
                        965_12, 1, "PENDING", status().isBadRequest(), OrderStatus.DECLINED),

                Arguments.of("test invalid request: quantity is negative",
                        965_12, -10, "PENDING", status().isBadRequest(), OrderStatus.DECLINED)
        );
    }
}
