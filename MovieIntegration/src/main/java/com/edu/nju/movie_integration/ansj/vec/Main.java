package com.edu.nju.movie_integration.ansj.vec;

import com.edu.nju.movie_integration.ansj.vec.util.TokenizerAnalyzerUtils;
import com.edu.nju.movie_integration.ansj.vec.util.TxtWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gy
 * @date 2019/6/15 19:07
 */

public class Main {
    /**
     * 训练模型
     * @throws IOException
     */
    public static void makeModel() throws IOException {
        Learn learn = new Learn();
        TokenizerAnalyzerUtils.writetest();
        learn.learnFile(new File("src/main/java/test1.txt"));
        learn.saveModel(new File("src/main/java/model.mod"));
    }
    public static void main(String args[]) throws IOException {
        makeModel();

        Word2VEC vec = new Word2VEC();
        vec.loadJavaModel("src/main/java/model.mod");

        List<String> wordList = new ArrayList<String>();
        wordList.add("奇异");
        wordList.add("绯红");
        wordList.add("星");
        wordList.add("灭");
        wordList.add("霸");
        wordList.add("特效");
        wordList.add("心动");
        wordList.add("结局");
//        wordList.add("垃圾");
        for (String word : wordList) {
            TxtWriter.writeFile("src/main/java/result.txt" , word + vec.distance(word).toString());
            System.out.println(word  +
                    vec.distance(word));
        }
    }
}
