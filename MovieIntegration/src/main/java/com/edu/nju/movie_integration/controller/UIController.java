package com.edu.nju.movie_integration.controller;

import com.edu.nju.movie_integration.domain.Movie;
import com.edu.nju.movie_integration.service.JuheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UIController {
    @Autowired
    private JuheService juheService;

    @RequestMapping("/movie")
    public List<Movie> getMovieList() {
        Movie test1 = new Movie();
        test1.setName("1");
        List<String> descriptions1 = new ArrayList<>();
        descriptions1.add("test123");
        test1.setDescription(descriptions1);

        Movie test2 = new Movie();
        test1.setName("2");
        List<String> descriptions2 = new ArrayList<>();
        descriptions2.add("test321");
        test1.setDescription(descriptions2);

        List<Movie> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        return list;
    }

    @RequestMapping("/Todaymovie")
    public List<Movie> getTodayMovie() {
        return juheService.getTodayMovie();
    }
}
