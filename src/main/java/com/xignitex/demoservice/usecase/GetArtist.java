package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtist implements UseCase<String, Artist> {

    @Override
    public Artist execute(String request) {
        Artist artist = new Artist();
        artist.setName("test");
        return artist;
    }
}
