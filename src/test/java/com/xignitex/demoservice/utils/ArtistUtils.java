package com.xignitex.demoservice.utils;

import com.xignitex.demoservice.model.Artist;

public class ArtistUtils {

    public static Artist createTestArtist(){
        Artist artist = new Artist();
        artist.setName("David Bowie");

        return artist;
    }
}
