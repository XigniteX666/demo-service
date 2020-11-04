package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateArtist implements UseCase<Artist, Artist>{

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist execute(Artist artist) {
        return artistRepository.save(artist);
    }
}
