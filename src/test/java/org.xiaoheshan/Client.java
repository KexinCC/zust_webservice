package org.xiaoheshan;


import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.xiaoheshan.pojo.ResEntity;

import java.util.List;
import java.util.Scanner;

public class Client {

    Scanner sc = new Scanner(System.in);

    @Test
    public void CorrectMovieService() {
        String movieName = null;
        System.out.println("Please input the name of the movie: ");
        movieName = sc.nextLine();

        String res = HttpUtil.get(STR."http://localhost:8080/correctmoviename/moivename/\{movieName}");

        System.out.println(res);

    }




    @Test
    public void getMovieInfo() {

        String movieName = null;
        System.out.println("Please input the name of the movie: ");
        movieName = sc.nextLine();

        String s = HttpUtil.get(STR."http://localhost:8080/chatservice/sendMessage/return the correct name of the movie\{movieName}, and wrap the name by |");
        movieName = s.split("\\|")[1].trim();


        String res = HttpUtil.get(STR."https://api.wmdb.tv/api/v1/movie/search?q=\{movieName}");
        System.out.println(res);


        String finalMovieName = movieName;
        List<Object> list = JSONArray.parse(res).stream().filter(o -> {
            JSONArray data = ((JSONObject) o).getJSONArray("data");
            String name = data.getJSONObject(0).getString("name");
            String originalName = ((JSONObject) o).getString("originalName");
            return name.equals(finalMovieName) || originalName.equals(finalMovieName);
        }).toList();

        String movieData = list.get(0).toString();
        JSONObject jsonObject = JSON.parseObject(movieData);

        String originalName = jsonObject.getString("originalName");
        String imdbRating = jsonObject.getString("imdbRating");
        String doubanRating = jsonObject.getString("doubanRating");
        String date = jsonObject.getString("year");
        String description = jsonObject.getJSONArray("data").getJSONObject(0).getString("description");
        String posterUri = jsonObject.getJSONArray("data").getJSONObject(0).getString("poster");

        System.out.println("Original Name: " + originalName);
        System.out.println("IMDB Rating: " + imdbRating);
        System.out.println("Douban Rating: " + doubanRating);
        System.out.println("Date Released: " + date);
        System.out.println("Description: " + description);
        System.out.println("Poster URI: " + posterUri);
    }

    @Test
    public void queryMovie() {
        String movieName = null;
        System.out.println("Please input the name of the movie: ");
        movieName = sc.nextLine();


        ResEntity resEntity = new ResEntity(200, movieName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reqEntity", resEntity);


        String res = HttpUtil.post(STR."http://localhost:8080/querymovies/querymovie", jsonObject.toJSONString());
        System.out.println(res);
    }

    @Test
    public void getMovieInfoByRapidApi() {

        String movieName = null;
        System.out.println("Please input the name of the movie: ");
        movieName = sc.nextLine();

        String s = HttpUtil
                .createRequest(Method.GET, "https://moviesdatabase.p.rapidapi.com/titles/tt1228705")
                .header("X-RapidAPI-Key", "1441711a22msh80ed47980c595fap16b9bcjsnefe6fa37bd45")
                .header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
                .execute()
                .body();

        System.out.println(JSONObject.parseObject(s).toString());

    }




}
