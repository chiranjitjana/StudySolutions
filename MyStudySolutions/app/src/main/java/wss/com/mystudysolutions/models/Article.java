package wss.com.mystudysolutions.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

@Entity(tableName = "blog")
public class Article implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Integer _Id;


    @ColumnInfo(name = "header_id")
    @SerializedName("header_id")
    @Expose
    private Integer blogHeaderid;


    @ColumnInfo(name = "post_id")
    @SerializedName("post_id")
    @Expose
    private Integer postId;


    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;


    @ColumnInfo(name = "created_date")
    @SerializedName("created_date")
    @Expose
    private String createdDate;


    @ColumnInfo(name = "author")
    @SerializedName("author")
    @Expose
    private String author;

    @ColumnInfo(name = "descriptiion")
    @SerializedName("descriptiion")
    @Expose
    private String descriptiion;

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @ColumnInfo(name = "is_seen")
    private Integer clicked;

    public Integer getClicked() {
        return clicked;
    }

    public void setClicked(Integer clicked) {
        this.clicked = clicked;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer get_Id() {
        return _Id;
    }

    public void set_Id(Integer _Id) {
        this._Id = _Id;
    }

    public Integer getBlogHeaderid() {
        return blogHeaderid;
    }

    public void setBlogHeaderid(Integer blogHeaderid) {
        this.blogHeaderid = blogHeaderid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptiion() {
        return descriptiion;
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
