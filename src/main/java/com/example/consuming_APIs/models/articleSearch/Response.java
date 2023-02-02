package com.example.consuming_APIs.models.articleSearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Response {

    private List<Doc> docs;
}
