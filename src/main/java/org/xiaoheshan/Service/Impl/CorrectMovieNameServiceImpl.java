package org.xiaoheshan.Service.Impl;

import org.xiaoheshan.Service.CorrectMovieNameService;
import org.xiaoheshan.util.CorrectMovieName;

public class CorrectMovieNameServiceImpl implements CorrectMovieNameService {

    @Override
    public String getMovieName(String movieName) {
        return CorrectMovieName.getMovieName(movieName);
    }
}
