package com.xignitex.demoservice;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.usecase.GetArtist;
import com.xignitex.demoservice.utils.ArtistUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DemoServiceApplicationTests {

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
