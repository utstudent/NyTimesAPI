package com.example.consuming_APIs.controllers;

import com.example.consuming_APIs.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "query", required = false) String searchText) {
        if (searchText != null) {
            return searchResults(model, searchText);
        }
        return "search";
    }

    @PostMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "query") String searchText) {
        model.addAttribute("articleList", articleService.getSearchResults(searchText));
        model.addAttribute("query",searchText);
        return "search-results";
    }
}
