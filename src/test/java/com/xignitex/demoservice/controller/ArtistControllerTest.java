package com.xignitex.demoservice.controller;

import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.utils.ArtistUtils;
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

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldCreateArtist() throws Exception{
        final ResponseEntity<Artist> response;
        try {

            Artist testArtist = ArtistUtils.createTestArtist();
            final HttpHeaders headers = new HttpHeaders();
            response = testRestTemplate
                    .exchange("/artist", POST, new HttpEntity<>(testArtist, headers), Artist.class);

            assertThat(response.getStatusCode()).isEqualTo(OK);
        } catch (final RestClientException ex) {
            fail(ex.getMessage());
            return;
        }
    }

}
