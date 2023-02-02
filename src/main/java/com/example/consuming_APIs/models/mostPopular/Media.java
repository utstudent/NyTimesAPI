package com.example.consuming_APIs.models.mostPopular;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Media {

    @JsonProperty("type")
    private String type;
    private String subtype;
    @JsonProperty("caption")
    private String caption;
    private String url;
    @JsonProperty("media-metadata")
    private List<Thumbnail> mediaMetadata;
}