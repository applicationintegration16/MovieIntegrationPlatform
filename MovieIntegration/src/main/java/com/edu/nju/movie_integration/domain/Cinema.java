package com.edu.nju.movie_integration.domain;

import lombok.Data;
import java.util.List;

/**
 * @Author: gy
 * @Date: 2019-05-14 20:11
 * @Version 1.0
 */
@Data
public class Cinema {
    private int id;
    private String cityName;
    private String name;
    private String address;
    private String telephone;
    private List<Movie> movies;

    public Cinema(int id, String cityName, String name, String address, String telephone, List<Movie> movies) {
        this.id = id;
        this.cityName = cityName;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.movies = movies;
    }

    public Cinema() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
