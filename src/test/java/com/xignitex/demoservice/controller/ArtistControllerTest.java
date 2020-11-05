package com.xignitex.demoservice.controller;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.utils.ArtistUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ArtistRepository artistRepository;

    @Test
    void shouldCreateArtist() throws Exception {
        final ResponseEntity<Artist> response;
        Artist testArtist = ArtistUtils.createTestArtist();
        when(artistRepository.save(testArtist)).thenReturn(testArtist);
        try {
            final HttpHeaders headers = new HttpHeaders();
            response = testRestTemplate
                    .exchange("/artist", POST, new HttpEntity<>(testArtist, headers), Artist.class);

            assertThat(response.getStatusCode()).isEqualTo(OK);
            assertThat(response.getBody().getName()).isEqualTo(testArtist.getName());
        } catch (final RestClientException ex) {
            fail(ex.getMessage());
            return;
        }
    }

    @Test
    void shouldReturnArtist() throws Exception {
        Artist testArtist = ArtistUtils.createTestArtist();
        when(artistRepository.findById(testArtist.getId())).thenReturn(Optional.of(testArtist));
        final HttpHeaders headers = new HttpHeaders();

        String url = "/artist/" + testArtist.getId();

        try {
            final ResponseEntity<Artist> response = testRestTemplate
                    .exchange(url, GET, new HttpEntity<>(headers), Artist.class);
            assertThat(response.getStatusCode()).isEqualTo(OK);
            assertThat(response.getBody().getName()).isEqualTo(testArtist.getName());
        } catch (final RestClientException ex) {
            fail(ex.getMessage());
            return;
        }
    }

    @Test
    void shouldReturnAllArtist() throws Exception {
        List<Artist> testArtistList = ArtistUtils.createTestArtistList();
        when(artistRepository.findAll()).thenReturn(testArtistList);
        final HttpHeaders headers = new HttpHeaders();

        String url = "/artist/all";

        try {
            final ResponseEntity<List<Artist>> response = testRestTemplate
                    .exchange(url, GET, new HttpEntity<>(headers), new ParameterizedTypeReference<List<Artist>>(){});
            assertThat(response.getStatusCode()).isEqualTo(OK);
            assertThat(response.getBody().size()).isEqualTo(testArtistList.size());
        } catch (final RestClientException ex) {
            fail(ex.getMessage());
            return;
        }
    }
}

