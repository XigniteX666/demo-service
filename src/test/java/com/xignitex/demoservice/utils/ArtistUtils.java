package com.xignitex.demoservice.utils;

import com.xignitex.demoservice.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistUtils {

    public static Artist createTestArtist(){
        Artist artist = new Artist();
        artist.setName("David Bowie");

        return artist;
    }


    public static List<Artist> createTestArtistList(){
        List<Artist> artistList = new ArrayList<>();
        artistList.add(createTestArtist());
        artistList.add(createTestArtist());
        artistList.add(createTestArtist());

        return artistList;
    }
}
