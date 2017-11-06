package wss.com.mystudysolutions.localdb.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.BlogsHeader;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

@android.arch.persistence.room.Dao
public interface BlogDao {
    @Insert
    void insertMultipleBlogList(List<Article> blogs);

    @Insert
    void insertSingleBlog(Article blogsHeader);

    @Query("SELECT * FROM blog")
    List<Article> getAllBlogs();

    @Query("SELECT count(*) FROM blog WHERE post_id=:blog_id")
    Integer  isBlogExists(Integer blog_id);

    @Query("SELECT * FROM blog WHERE header_id=:id ORDER BY _id DESC")
    List<Article> getBlogByHeader(Integer id);


    @Query("SELECT * FROM blog WHERE post_id=:id")
    Article getBlogById(Integer id);

    @Update
    void updateBlog(Article article);


}
