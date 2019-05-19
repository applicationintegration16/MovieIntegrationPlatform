package com.edu.nju.movie_integration.service;

import com.edu.nju.movie_integration.domain.Cinema;
import com.edu.nju.movie_integration.domain.Movie;

import java.util.List;

public interface JuheService {
    public List<Movie> getTodayMovie();
    public List<Cinema> getCitycinemas(String cityname);
}
