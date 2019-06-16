package com.edu.nju.movie_integration.ansj.vec.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gy
 * @date 2019/6/15 19:08
 */
public class TokenizerAnalyzerUtils {
    public TokenizerAnalyzerUtils(){

    }


    public static void main(String args[]) throws IOException {
        String tokenizerResult = getAnalyzerResult("不同于计算机，人类一睁眼就能迅速看到和看明白一个场景，因为人的大脑皮层至少有一半以上海量神经元参与了视觉任务的完成。");
        System.out.println(tokenizerResult);
    }

    /**
     * 给每一条评论分词
     * @param input
     * @return
     * @throws IOException
     */
    public static String getAnalyzerResult(String input) throws IOException {
        //创建分词对象
        StringBuffer sb = new StringBuffer();
        List<String> result = new ArrayList<String>();
        Analyzer anal=new IKAnalyzer(true);
        StringReader reader=new StringReader(input);
        //分词
        TokenStream ts=anal.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        //旧代码在新版本Lucene中出现的异常 , 代码必须在incrementToken()之前调用一次reset()
        ts.reset();
        //遍历分词数据
        while(ts.incrementToken()){
            result.add(term.toString());
        }
        reader.close();
        List<String> stopwords = StopWordsUtils.getStopWords();
        result.removeAll(stopwords);
        for (String str : result)
            sb.append(str).append(" ");
        return sb.toString();
    }


    /**
     * 保存分词文件
     * @throws IOException
     */
    public static void writetest() throws IOException {
        List<String> talks = CSVReader.readCSV();
        System.out.println("talks "+talks.size());
        for(String talk : talks) {
            String result = getAnalyzerResult(talk);
            System.out.println(result);
            TxtWriter.writeFile("src/main/java/test1.txt" , result);
        }
    }
}
