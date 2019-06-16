package com.edu.nju.movie_integration.ansj.vec.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gy
 * @date 2019/6/15 19:07
 */
public class StopWordsUtils {
    private static String filepath = "src/main/java/百度停用词表.txt";
    public static List<String> getStopWords() throws IOException {
        List<String> stopwords = new ArrayList<String>();
        String temp = null;
        BufferedReader bf = new BufferedReader(new FileReader(filepath));
        while((temp = bf.readLine())!= null) {
            stopwords.add(temp);
        }
        return  stopwords;
    }
}
