package org.xiaoheshan.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.util.Date;

@XmlRootElement(name = "Movie")
public class Movie {
    private String originalName;
    private String imdbRating;
    private String doubanRating;
    private Date date;
    private String description;
    private String posterUri;


    public Movie() {
    }

    public Movie(String originalName, String imdbRating, String doubanRating, Date date, String description, String posterUri) {
        this.originalName = originalName;
        this.imdbRating = imdbRating;
        this.doubanRating = doubanRating;
        this.date = date;
        this.description = description;
        this.posterUri = posterUri;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDoubanRating() {
        return doubanRating;
    }

    public void setDoubanRating(String doubanRating) {
        this.doubanRating = doubanRating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUri() {
        return posterUri;
    }

    public void setPosterUri(String posterUri) {
        this.posterUri = posterUri;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "originalName='" + originalName + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", doubanRating='" + doubanRating + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", posterUri='" + posterUri + '\'' +
                '}';
    }
}
