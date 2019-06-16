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
        String movieReply=aboutMovie(question);
        return movieReply==null?normalReply(question):movieReply;
    }

    private String aboutMovie(String question){
        String result=null;

        String[] khMovie={"流浪地球","后天","星际穿越","2012","雪国列车"};
        String[] aMovie={"泰坦尼克号","两小无猜","砰然心动","你的名字","罗马假日"};
        String[] xMovie={"天才枪手","记忆碎片","禁闭岛","致命魔术","调音师"};
        String[] kMovie={"寂静岭","咒怨","小丑回魂","闪灵","恐怖游轮"};
        String[] dMovie={"欢乐好声音","寻梦环游记","狮子王","头脑特工队","怪物史莱克"};
        String[] dzMovie={"叶问","机械师","A计划","战狼2","英伦对决"};
        String[] fzMovie={"七宗罪","拆弹专家","惊天魔盗团","看不见的客人","唐人街探案1"};
        String[] xj={"三傻大闹宝莱坞","唐伯虎点秋香","侠盗夫妻","大话西游","人在囧途"};
        int index= (int) (Math.random()*5);
        if(question.contains("科幻")){
            result="如果你想看科幻电影，我推荐你看"+khMovie[index];
        }else if(question.contains("爱情")){
            result="爱情电影想看吗？我推荐"+aMovie[index];
        }else if(question.contains("动作电影")){
            result="说起动作电影，"+aMovie[index] +"我很喜欢";
        }else if(question.contains("悬疑")){
            result="提到悬疑电影，"+xMovie[index] +"令我印象深刻";
        }else if(question.contains("恐怖")){
            result=kMovie[index]+"看过吗，给我留下心理阴影的恐怖电影";
        }else if(question.contains("动画")){
            result=dMovie[index]+"是很温馨的动画电影，不知道你看过没";
        }else if(question.contains("犯罪")){
            result=fzMovie[index]+"，我觉得很经典的犯罪电影";
        }else if(question.contains("喜剧")){
            result="说起喜剧，强烈推荐"+xj[index];
        }else if(question.contains("动作电影")){
            result=dzMovie[index]+",让人肾上腺素狂飙的动作电影，看过吗";
        }
        else return null;
        return result;
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
