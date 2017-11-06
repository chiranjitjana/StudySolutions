package wss.com.mystudysolutions.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chiranjit Jana on 04/11/2017.
 */

@Entity(tableName = "blog_header")
public class BlogsHeader {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Integer blogHeaderId;

    @ColumnInfo(name = "blog_header_id")
    @SerializedName("blogs_header_id")
    @Expose
    private Integer headerId;


    @ColumnInfo(name = "header_title")
    @SerializedName("blogs_header_title")
    @Expose
    private String title;


    @ColumnInfo(name = "created_date")
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    @ColumnInfo(name = "created_by")
    @SerializedName("created_by")
    @Expose
    private String createdBy;


    @Ignore
    BlogList blogLists;


    public BlogList getBlogLists() {
        return blogLists;
    }

    public void setBlogLists(BlogList blogLists) {
        this.blogLists = blogLists;
    }

    public Integer getBlogHeaderId() {
        return blogHeaderId;
    }

    public void setBlogHeaderId(Integer blogHeaderId) {
        this.blogHeaderId = blogHeaderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    @Override
    public String toString() {
        return "BlogsHeader{" +
                "title='" + title + '\'' +
                ", headerId='" + headerId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }



}
