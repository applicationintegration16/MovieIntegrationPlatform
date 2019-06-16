package com.edu.nju.movie_integration.ansj.vec.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author gy
 * @date 2019/6/15 19:10
 */
public class CSVReader {
     private static String filepath = "src/main/java/data.csv";
     public static List<String> readCSV() {
         File csv = new File(filepath);  // CSV文件路径
         BufferedReader br = null;
         try
         {
             br = new BufferedReader(new FileReader(csv));
         } catch (FileNotFoundException e)
         {
             e.printStackTrace();
         }
         List<String> allString = new ArrayList<String>();
         String line = "";
         String[] everyLine = new String[6];
         try {
             while ((line = br.readLine()) != null)  //读取到的内容给line变量
             {
                 everyLine = line.split(",");
                 if(everyLine.length != 1)
                     allString.add(everyLine[5]);
             }
             System.out.println("csv表格中所有行数："+allString.size());
         } catch (IOException e)
         {
             e.printStackTrace();
         }
         return allString;
     }
}
