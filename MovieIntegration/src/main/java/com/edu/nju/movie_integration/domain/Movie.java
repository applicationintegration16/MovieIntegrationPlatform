package com.edu.nju.movie_integration.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: py
 * @Date: 2019-05-12 14:29
 * @Version 1.0
 */

@Data
@NoArgsConstructor
public class Movie {

    private int id;

    private String name;

    private double rating;

    private List<String> description;

    private String cinemaAddress;

    private double price;

    /**
     * 剩余数量
     */
    private double remain;

    /**
     * 图片
     */
    private String pic_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
