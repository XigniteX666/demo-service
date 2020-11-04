package com.xignitex.demoservice.gateway.artistgateway;

import com.xignitex.demoservice.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
}
