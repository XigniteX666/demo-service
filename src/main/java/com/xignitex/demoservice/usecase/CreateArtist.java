package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CreateArtist implements UseCase<Artist, Artist>{

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist execute(Artist artist) {
        log.info("Creating artist {}.", artist.getName());
        return artistRepository.save(artist);
    }
}
