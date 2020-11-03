package com.xignitex.demoservice;

import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.usecase.GetArtist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DemoServiceApplicationTests {

	@InjectMocks
	private GetArtist getArtist;

	@Test
	void shouldGetArtist() {

		final String id = "123";
		Artist artist = getArtist.execute(id);
		assertThat(artist.getName()).isEqualTo("test1");
	}

}
