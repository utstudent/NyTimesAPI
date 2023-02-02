package com.example.consuming_APIs.models.articleSearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Doc {

    @JsonProperty("abstract")
    private String summary;

    @JsonProperty("web_url")
    private String webUrl;

    private List<Multimedia> multimedia;

    private Headline headline;

//    String or date?
    private Date pub_date;

    @JsonProperty("section_name")
    private String section;

    @JsonProperty("subsection_name")
    private String subsection;

    private Byline byline;

    @JsonProperty("_id")
    private String id;

    private String imageUrl;
}
