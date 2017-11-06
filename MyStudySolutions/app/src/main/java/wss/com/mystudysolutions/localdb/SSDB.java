package wss.com.mystudysolutions.localdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import wss.com.mystudysolutions.localdb.dao.BlogDao;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDao;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.BlogsHeader;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */
@Database(entities = {BlogsHeader.class, Article.class}, version = 1)
public abstract class SSDB extends RoomDatabase{
    public abstract BlogHeaderDao blogHeaderDao();
    public abstract BlogDao blogDao();
}
