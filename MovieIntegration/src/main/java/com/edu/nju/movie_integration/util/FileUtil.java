package com.edu.nju.movie_integration.util;

/**
 * @Author: py
 * @Date: 2019-05-19 12:43
 * @Version 1.0
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private final static String DOUBAN_DATA_PATH = "src/main/resources/dataset/douban.json";

    private final static String URL_PATH = "src/main/resources/dataset/tmp.txt";

    public static List<String> listDoubanStr() {
        try {
            File file = new File(DOUBAN_DATA_PATH);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            List<String> strList = new ArrayList<>();
            String s = "";
            while ((s = bReader.readLine()) != null) {
                //System.out.println(s);
                strList.add(s);
            }
            bReader.close();
            return strList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static String getUrl() {
        try {
            File file = new File(URL_PATH);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            List<String> strList = new ArrayList<>();
            String s = bReader.readLine();
            bReader.close();
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        for (String str: listDoubanStr()) {
            System.out.println(str);
        }

    }
}
