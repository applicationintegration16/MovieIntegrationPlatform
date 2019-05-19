package com.edu.nju.movie_integration.service.Impl;

import com.edu.nju.movie_integration.domain.Movie;
import com.edu.nju.movie_integration.service.JuheService;
import com.edu.nju.movie_integration.service.MovieService;
import com.edu.nju.movie_integration.util.Json2ObjUtil;
import com.edu.nju.movie_integration.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: py
 * @Date: 2019-05-12 14:35
 * @Version 1.0
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    XMLUtil xmlUtil;
    @Autowired
    Json2ObjUtil json2ObjUtil;
    @Autowired
    JuheService juheService;

    @Override
    public List<Movie> getMovie() {
        //TODO: update the empty list
        List<Movie> juhe=juheService.getTodayMovie();
        List<Movie> douban=json2ObjUtil.listMovieFromDouban();
        List<Movie> sum=new ArrayList<>();
        sum.addAll(douban);
        sum.addAll(juhe);
        saveMovie(sum);
        return sum;
    }


    private void saveMovie(List<Movie> sum){
        Document document=xmlUtil.createXml();
        for(Movie movie:sum){
            Map<String,Object> property=new HashMap<String,Object>();
            property.put("id",movie.getId());
            property.put("name",movie.getName());
            property.put("rating",movie.getRating());
            property.put("pic",movie.getPic_url()==null?"":movie.getPic_url());
            xmlUtil.addElement(document,property);
        }
        xmlUtil.writeXml(document,"movie");
    }

}
