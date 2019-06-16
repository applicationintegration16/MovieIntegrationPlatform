package com.edu.nju.movie_integration.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class AutoReply {
    private static final String API_KEY="29f477ea82674fc9a23d794e37f819ce";
    private static final String USER_ID="464772";
    private static final String ADDRESS="http://openapi.tuling123.com/openapi/api/v2";
    private static final String WARNING="错误，请稍后再试";

    public String getReply(String question){

        return null;
    }


    private String normalReply(String question) {
        try {
            URL url = new URL(ADDRESS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");


            int reqType = 0;
            JSONObject reqJson = new JSONObject();
            reqJson.put("reqType",reqType);

            JSONObject perception = new JSONObject();
            JSONObject inputText = new JSONObject();
            inputText.put("text",question);
            perception.put("inputText",inputText);

            // 用户信息
            JSONObject userInfo = new JSONObject();
            userInfo.put("apiKey",API_KEY);
            userInfo.put("userId",USER_ID);

            reqJson.put("perception",perception);
            reqJson.put("userInfo",userInfo);

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(reqJson.toString());
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject jsonObject=new JSONObject(result.toString());
            JSONArray text=jsonObject.getJSONArray("results");
            JSONObject value=text.getJSONObject(0).getJSONObject("values");


            String reply=value.getString("text");

            return reply==null?WARNING:reply;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return WARNING;
    }
}
