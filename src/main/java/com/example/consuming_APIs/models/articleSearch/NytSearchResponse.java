package com.example.consuming_APIs.models.articleSearch;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class NytSearchResponse {

    private String status;
    private String copyright;
    private Response response;
}
