package com.example.consuming_APIs.models.mostPopular;

import com.example.consuming_APIs.models.mostPopular.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class NytResponse {

    private String status;
    private String copyright;
    @JsonProperty("num_results")
    private int numResults;
    private List<Article> results;
}
