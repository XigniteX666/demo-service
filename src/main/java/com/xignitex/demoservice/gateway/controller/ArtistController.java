package com.xignitex.demoservice.gateway.controller;

import com.xignitex.demoservice.model.Artist;
import com.xignitex.demoservice.usecase.UseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final UseCase<String, Artist> getArtist;

    @ApiOperation("Get an artist based on his id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API called successfully", response = Artist.class),
            @ApiResponse(code = 404, message = "Artist not found")
    })
    @GetMapping(value = "/{id}")
    public Artist getArtistById(@PathVariable("id") final String id){
        return getArtist.execute(id);
    }

}
