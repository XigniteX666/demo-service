package com.xignitex.demoservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Artist {

    @Id
    private String id;
    private String name;
    private List<Image> images;
    private List<Genre> genres;
    private String url;
    private String description;

}
