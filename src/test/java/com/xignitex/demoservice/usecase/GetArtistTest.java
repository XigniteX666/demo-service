package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.utils.ArtistUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetArtistTest {

    @InjectMocks
    private GetArtist getArtist;

    @Mock
    private ArtistRepository artistRepository;

    @Test
    void shouldGetArtist() {
        final String id = "123";
        Artist test_artist = ArtistUtils.createTestArtist();

        when(artistRepository.findById(eq(id)))
                .thenReturn(Optional.of(test_artist));

        Artist artist = getArtist.execute(id);
        assertThat(artist.getName()).isEqualTo(test_artist.getName());
    }
}
