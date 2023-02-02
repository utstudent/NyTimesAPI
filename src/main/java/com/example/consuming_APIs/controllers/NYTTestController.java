package com.example.consuming_APIs.controllers;

import com.example.consuming_APIs.models.mostPopular.Article;
import com.example.consuming_APIs.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NYTTestController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/nyt/test")
    public List<Article> getMostPopular(){
        return articleService.getMostPopular();
    }
}
