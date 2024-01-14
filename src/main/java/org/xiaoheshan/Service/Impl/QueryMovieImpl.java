package org.xiaoheshan.Service.Impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.xiaoheshan.Service.QueryMovie;
import org.xiaoheshan.pojo.Movie;
import org.xiaoheshan.pojo.ReqEntity;

import java.util.Date;
import java.util.List;

public class QueryMovieImpl implements QueryMovie {

    /**
     * query movie by movie name
     * @param reqEntity
     * @return
     */
    @Override
    public Movie queryMovie(ReqEntity reqEntity) {
        String movieName = reqEntity.getMsg();

        // correct the movie name
        String s = HttpUtil.get(STR."http://localhost:8080/chatservice/sendMessage/返回这个电影正确的名字: \{movieName}, 并用 | 包裹");
        movieName = s.split("\\|")[1].trim();

        // query movie by movie name
        String res = HttpUtil.get(STR."https://api.wmdb.tv/api/v1/movie/search?q=\{movieName}");

        // filter the movie by movie name
        String finalMovieName = movieName;
        List<Object> list = JSONArray.parse(res).stream().filter(o -> {
            JSONArray data = ((JSONObject) o).getJSONArray("data");
            String name = data.getJSONObject(0).getString("name");
            String originalName = ((JSONObject) o).getString("originalName");
            return name.equals(finalMovieName) || originalName.equals(finalMovieName);
        }).toList();

        JSONObject o = JSON.parseObject(list.get(0).toString());
        JSONArray dataArray = o.getJSONArray("data");
        JSONObject data = dataArray.getJSONObject(0);

        // get the movie info
        String originalName = o.getString("originalName");
        String posterUri = data.getString("poster");
        String description = data.getString("description");
        Date date = DateUtil.parse(o.getString("dateReleased"));
        String doubanRating = o.getString("doubanRating");
        String imdbRating = o.getString("imdbRating");


        // return the movie
        return new Movie(originalName, posterUri, doubanRating, date, description, imdbRating);
    }

}
