package com.example.consuming_APIs.services;

import com.example.consuming_APIs.models.articleSearch.Doc;
import com.example.consuming_APIs.models.articleSearch.Multimedia;
import com.example.consuming_APIs.models.articleSearch.NytSearchResponse;
import com.example.consuming_APIs.models.mostPopular.Article;
import com.example.consuming_APIs.models.mostPopular.NytResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Value("${searchUrl}")
    private String searchUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            for (Article article: response.getResults()) {
                if(!article.getMedia().isEmpty() && !article.getMedia().get(0).getMediaMetadata().isEmpty()) {
                    article.setImageUrl(article.getMedia().get(0).getMediaMetadata().get(article.getMedia().get(0).getMediaMetadata().size()-1).getUrl());
                    results.add(article);
                }
            }
            return results;
        } else {
            return results;
        }
    }

    public List<Doc> getSearchResults(String searchText) {
        ResponseEntity<NytSearchResponse> responseEntity = restTemplate.getForEntity(searchUrl + searchText + "&api-key=" + apikey, NytSearchResponse.class);
        List<Doc> results = new ArrayList<>();
        System.out.println(responseEntity);

        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            for (Doc doc: responseEntity.getBody().getResponse().getDocs()) {
                boolean containsMedia = false;
                for (Multimedia multimedia: doc.getMultimedia()) {
                    if (multimedia.getSubtype().equals("largeHorizontal375")) {
                        doc.setImageUrl("https://www.nytimes.com/" + multimedia.getUrl());
                        containsMedia = true;
                    }
                }
                if (containsMedia){
                    results.add(doc);
                }
            }
            System.out.println(results);
            return results;
        } else {
            return results;
        }
    }
}