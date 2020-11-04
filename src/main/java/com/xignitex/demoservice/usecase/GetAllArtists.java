package com.xignitex.demoservice.usecase;

import com.xignitex.demoservice.gateway.artistgateway.ArtistRepository;
import com.xignitex.demoservice.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllArtists implements UseCase<Void, List<Artist>> {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> execute(Void request) {
        return artistRepository.findAll();
    }
}
