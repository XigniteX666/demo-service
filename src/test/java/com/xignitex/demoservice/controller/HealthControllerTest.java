package com.xignitex.demoservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnOK() throws Exception {
        final ResponseEntity<String> response;

        try {
            final HttpHeaders headers = new HttpHeaders();
            response = testRestTemplate
                    .exchange("/health", GET, new HttpEntity<>(headers), String.class);

            assertThat(response.getStatusCode()).isEqualTo(OK);
        } catch (final RestClientException ex) {
            fail(ex.getMessage());
            return;
        }
    }
}
