package com.xignitex.demoservice.gateway.controller;

import com.xignitex.demoservice.exception.NotFoundException;
import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.usecase.UseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final UseCase<String, Artist> getArtist;
    private final UseCase<Artist, Artist> createArtist;
    private final UseCase<Void, List<Artist>> getAllArtists;

    @ApiOperation("Get an artist based on his id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API called successfully", response = Artist.class),
            @ApiResponse(code = 404, message = "Artist not found")
    })
    @GetMapping(value = "/{id}")
    public Artist getArtistById(@PathVariable("id") final String id) {
        Artist artist = getArtist.execute(id);
        if(artist != null) {
            return artist;
        }else{
            throw new NotFoundException();

        }
    }

    @ApiOperation("Store an artist")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Artist stored", response = Artist.class)
    })
    @PostMapping
    public Artist createCustomer(@RequestBody Artist artist) {
        return createArtist.execute(artist);
    }

    @ApiOperation("Retrieve all the artists")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Artist.class)
    })
    @GetMapping("/all")
    public List<Artist> getAllArtists(){
        return getAllArtists.execute(null);
    }
}

