package wss.com.mystudysolutions.localdb.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import wss.com.mystudysolutions.models.BlogsHeader;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */



@android.arch.persistence.room.Dao
public interface BlogHeaderDao {
    @Insert
    void insertMultipleBlogHeaderList(List<BlogsHeader> blogsHeaders);

    @Insert
    void insertSingleBlogHeaderList(BlogsHeader blogsHeader);

    @Query("SELECT * FROM blog_header ORDER BY blog_header_id asc")
    List<BlogsHeader> getAllBlogHeaders();

    @Query("SELECT count(*) FROM blog_header WHERE blog_header_id=:header_id")
    Integer isHeaderExists(Integer header_id);
}
