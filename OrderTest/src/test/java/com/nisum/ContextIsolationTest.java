package com.nisum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContextIsolationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient paymentGatewayClient; // Only this is mocked

    @Autowired
    private OrderService orderService; // Real bean

    @Autowired
    private OrderRepository orderRepository; // Real bean

    @Test
    void testOrderEndpoint_andContextIsolation() {
        // Prepare request
        OrderRequest request = new OrderRequest();
        request.setAmount(99.99);

        // Call endpoint
        ResponseEntity<String> response = restTemplate.postForEntity("/orders", request, String.class);

        // Assert HTTP response
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Order placed");

        // Verify PaymentGatewayClient mock was called
        verify(paymentGatewayClient, times(1)).charge(99.99);

        // Assert other beans are real and wired
        assertThat(orderService).isNotNull();
        assertThat(orderRepository).isNotNull();
        assertThat(orderRepository.count()).isEqualTo(1);
    }
}
