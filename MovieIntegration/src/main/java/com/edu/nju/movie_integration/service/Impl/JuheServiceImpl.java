package com.edu.nju.movie_integration.service.Impl;

import com.edu.nju.movie_integration.domain.Cinema;
import com.edu.nju.movie_integration.domain.Movie;
import com.edu.nju.movie_integration.service.JuheService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gy
 * @Date: 2019-05-14 20:11
 * @Version 1.0
 */

@Service
public class JuheServiceImpl implements JuheService{

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY ="823a386680c1568c429b35c29fdc79cf";

    //3.关键字影院检索
    public List<Cinema> getCitycinemas(String cityname){
        String result =null;
        String cityid = getCityNameToID().get(cityname);
        String url ="http://v.juhe.cn/movie/cinemas.search";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityid",cityid);//城市ID
        params.put("keyword","");//关键字，urlencode utf8
        params.put("page","");//页数，默认1
        params.put("pagesize","");//每页返回条数，默认20
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json
        List<Integer> cinemaId = new ArrayList<Integer>();
        List<Cinema> cinemas = new ArrayList<Cinema>();
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                JSONObject temp = object.getJSONObject("result");
                JSONArray cinemaIds = temp.getJSONArray("data");
                for(int i = 0 ; i < cinemaIds.size() ; i ++){
                    JSONObject current = (JSONObject) cinemaIds.get(i);
                    cinemaId.add(current.getInt("id"));
                }
                for (int i = 0 ; i < cinemaId.size() ; i ++) {
                    cinemas.add(getTargetCinema(cinemaId.get(i)));
                }
                System.out.println(cinemas.size());
                System.out.println(object.get("result"));
                return cinemas;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemas;
    }

    //4.影院上映影片信息
    public Cinema getTargetCinema(int cinemaid){
        String result =null;
        String url ="http://v.juhe.cn/movie/cinemas.movies";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cinemaid",cinemaid);//影院ID
        params.put("movieid","");//指定电影ID，默认全部电影
        params.put("dtype","");//返回数据的格式,xml/json，默认json
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        Cinema cinema = new Cinema();
        List<Movie> movies = new ArrayList<Movie>();
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                JSONObject temp = object.getJSONObject("result");
                JSONObject simpleInfo = temp.getJSONObject("cinema_info");
                System.out.println(simpleInfo);
                cinema.setId(simpleInfo.getInt("id"));
                cinema.setName(simpleInfo.getString("name"));
                cinema.setCityName(simpleInfo.getString("city"));
                cinema.setAddress(simpleInfo.getString("address"));
                cinema.setTelephone(simpleInfo.getString("telephone"));
                String address = simpleInfo.getString("address");
                JSONArray moviesList = temp.getJSONArray("lists");
                for(int i = 0 ; i < moviesList.size() ; i ++){
                    JSONObject current = (JSONObject) moviesList.get(i);
                    int id = current.getInt("movieId");
                    String name = current.getString("movieName");
                    String pic_url = current.getString("pic_url");
                    JSONArray tickets = current.getJSONArray("broadcast");
                    JSONObject ticket = (JSONObject)tickets.get(0);
                    double price = ticket.getDouble("price");
                    Movie movie = new Movie();
                    movie.setCinemaAddress(address);
                    movie.setId(id);
                    movie.setName(name);

                    movie.setPrice(price);
                    movies.add(movie);
                }
                cinema.setMovies(movies);
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            return cinema;
        }
        return cinema;
    }

    //6.支持城市列表
    public static Map<String , String > getCityNameToID(){
        String result =null;
        String url ="http://v.juhe.cn/movie/citys";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json
        Map<String , String> re = new HashMap<String, String>();
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                JSONArray cinemaResult = object.getJSONArray("result");
                for(int i = 0 ; i < cinemaResult.size() ; i ++) {
                    JSONObject currentCity = (JSONObject)cinemaResult.get(i);
                    re.put(currentCity.getString("city_name") , currentCity.getString("id"));
                }
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    public List<Movie> getTodayMovie(){
        String result =null;
        String url ="http://v.juhe.cn/movie/movies.today";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityid","14");//城市ID
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json
        List<Movie> movies = new ArrayList<>();
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                JSONArray movieResult = object.getJSONArray("result");
                for (int i = 0 ; i < movieResult.size() ; i ++) {
                    JSONObject current = (JSONObject) movieResult.get(i);
                    int movieId = current.getInt("movieId");
                    Movie movie = getMovieById(movieId);
                    movies.add(movie);
                }
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    public static void main(String[] args) {
        JuheServiceImpl juheService = new JuheServiceImpl();
        List<Movie> movies = juheService.getTodayMovie();
//        List<Movie> movies = getTodayMovie();
//        for (int i = 0 ; i < movies.size() ; i ++)
//            System.out.println(movies.get(i).getName());
//        getRequest4(967);
//        getRequest5("南京");
//             getRequest6();

    }

    //8.按影片ID检索影片信息
    public static Movie getMovieById(int movieId){
        String result =null;
        String url ="http://v.juhe.cn/movie/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("movieid",movieId);//需要检索的影片id
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json
        Movie resultMovie = new Movie();
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                JSONObject movie = object.getJSONObject("result");
                int id = movieId;
                double rating = movie.getDouble("rating");
                String name = movie.getString("title");
                String pic_url = movie.getString("poster");
                String plot = movie.getString("plot_simple");
                List<String> description = new ArrayList<>();
                description.add(plot);
                resultMovie.setId(id);
                resultMovie.setName(name);
                resultMovie.setRating(rating);
                resultMovie.setPic_url(pic_url);
                resultMovie.setDescription(description);
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMovie;
    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
