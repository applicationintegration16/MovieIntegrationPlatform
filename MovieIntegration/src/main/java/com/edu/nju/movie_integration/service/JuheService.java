package com.edu.nju.movie_integration.service;

import com.edu.nju.movie_integration.domain.Cinema;

import java.util.List;

public interface JuheService {
    public List<Cinema> getCitycinemas(String cityname);
}
