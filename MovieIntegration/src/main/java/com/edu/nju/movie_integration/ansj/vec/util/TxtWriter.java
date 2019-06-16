package com.edu.nju.movie_integration.ansj.vec.util;

import java.io.*;

/**
 * @author gy
 * @date 2019/6/15 19:10
 */
public class TxtWriter {
    public static void writeFile(String path , String content) throws FileNotFoundException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true)));
            out.write(content+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}