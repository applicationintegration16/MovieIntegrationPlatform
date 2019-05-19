package com.edu.nju.movie_integration.util;

import com.edu.nju.movie_integration.domain.Movie;
import com.google.gson.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: py
 * @Date: 2019-05-19 12:33
 * @Version 1.0
 */
@Component
public class Json2ObjUtil {
    private final static String DOUBAN_DATA_PATH = "src/main/resources/dataset/douban.json";

    public static List<Movie> listMovieFromDouban() {
        List<Movie> movieList = new ArrayList<>();
        List<String> strList = FileUtil.listDoubanStr();

        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            for (String movieStr: strList) {
                JsonObject jObj=(JsonObject) parse.parse(movieStr);
                //System.out.println(jObj.get("title"));
                String name = jObj.get("title").toString();

                System.out.println(jObj.get("rating"));
                String innerStr = jObj.get("rating").toString();
                JsonObject innerJObj = (JsonObject) parse.parse(innerStr);
                double rating = innerJObj.get("average").getAsDouble();

                String altStr = jObj.get("alt").toString();
                System.out.println("**" + altStr);
                String path = "src/main/java/com/edu/nju/movie_integration/pyImpl/img_thief.py";
                PythonRunnerUtil.run(path, new String[]{altStr});

                Movie movie = new Movie();
                movie.setName(name);
                movie.setRating(rating);
                System.out.println(FileUtil.getUrl());
                movie.setPic_url(FileUtil.getUrl());
                movieList.add(movie);

            }

        } catch (JsonIOException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public static void main(String[] args) {
        listMovieFromDouban();
    }

}
