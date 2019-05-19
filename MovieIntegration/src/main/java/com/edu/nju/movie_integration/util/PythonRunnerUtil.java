package com.edu.nju.movie_integration.util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: py
 * @Date: 2019-05-18 22:32
 * @Version 1.0
 */

/**
 *  PythonRunnerUtil call python implement if necessary
 */
public class PythonRunnerUtil {
    private static final String COMMAND = "python3";

    public static void run(String pythonFilePath, String[] params){
        String[] args = new String[2 + params.length];
        System.out.println(args.length);
        args[0] = COMMAND;
        args[1] = pythonFilePath;
        //  System.out.println(args[0]);
        //  System.out.println(args[1]);
        System.arraycopy(params, 0, args, 2, params.length);
        //    System.out.println(args[2]);
        try {
            Process process = Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            process.waitFor();
            System.out.println("end");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args){
//         String path = "src/main/java/com/edu/nju/movie_integration/pyImpl/douban_film.py";
//         String[] pArgs = {};
//         run(path, pArgs);
//
//    }

}
