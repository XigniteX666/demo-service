package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.utils.ArtistUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllArtistsTests {

    @InjectMocks
    private GetAllArtists getAllArtists;

    @Mock
    private ArtistRepository artistRepository;

    @Test
    void shouldCreateArtist() {

        List<Artist> artistListExpected = ArtistUtils.createTestArtistList();

        when(artistRepository.findAll())
                .thenReturn(artistListExpected);


        List<Artist> artistListActual = getAllArtists.execute(null);
        assertThat(artistListActual.size()).isEqualTo(artistListExpected.size());
    }
}
