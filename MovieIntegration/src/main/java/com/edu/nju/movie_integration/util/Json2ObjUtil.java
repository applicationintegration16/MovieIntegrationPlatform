package com.edu.nju.movie_integration.util;

import com.edu.nju.movie_integration.domain.Movie;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: py
 * @Date: 2019-05-19 12:33
 * @Version 1.0
 */
public class Json2ObjUtil {
    private final static String DOUBAN_DATA_PATH = "src/main/resources/dataset/douban.json";

    public static List<Movie> listMovieFromDouban() {
        List<Movie> movieList = new ArrayList<>();
        JSONObject jObject = new JSONObject();

        return movieList;
    }
}
