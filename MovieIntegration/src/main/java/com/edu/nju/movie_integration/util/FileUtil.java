package com.edu.nju.movie_integration.util;

/**
 * @Author: py
 * @Date: 2019-05-19 12:43
 * @Version 1.0
 */
import java.io.*;

public class FileUtil {
    private final static String DOUBAN_DATA_PATH = "src/main/resources/dataset/douban.json";

    public static String getDoubanStr() {
        try {
            File file = new File(DOUBAN_DATA_PATH);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s = "";
            while ((s = bReader.readLine()) != null) {
                sb.append(s + "\n");
                System.out.println(s);
            }
            bReader.close();
            String str = sb.toString();
            System.out.println(str);
            return str;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(getDoubanStr());
    }
}
