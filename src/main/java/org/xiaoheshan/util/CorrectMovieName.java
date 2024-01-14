package org.xiaoheshan.util;

public class CorrectMovieName {
    public static String getMovieName(String movieName) {
        String name = OpenAIAPI.invokeApi("return the correct name of the movie\\{movieName}, and wrap the name by |").getMsg();

        return name;
    }
}
