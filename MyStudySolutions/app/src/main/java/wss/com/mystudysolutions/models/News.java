package wss.com.mystudysolutions.models;

import java.io.Serializable;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

public class News implements Serializable {
    private String newsId,title,date,description;

    public News(String newsId, String title, String date, String description) {
        this.newsId = newsId;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
