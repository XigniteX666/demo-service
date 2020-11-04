package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetArtist implements UseCase<String, Artist> {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist execute(String request) {

        Optional<Artist> artist = artistRepository.findById(request);
        if(artist.isPresent()){
            return artist.get();
        }else{
            return null;

        }

    }
}
