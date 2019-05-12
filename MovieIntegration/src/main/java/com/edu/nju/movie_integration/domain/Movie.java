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


}
