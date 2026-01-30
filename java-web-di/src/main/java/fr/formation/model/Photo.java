package fr.formation.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Photo {
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private int albumId;
}
