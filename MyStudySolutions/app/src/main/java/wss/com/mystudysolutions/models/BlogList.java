package wss.com.mystudysolutions.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

public class BlogList {

    @SerializedName("blogs")
    @Expose
    private List<Article> blogList = new ArrayList<>();

    public List<Article> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Article> blogList) {
        this.blogList = blogList;
    }
}
