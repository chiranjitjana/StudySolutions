package wss.com.mystudysolutions.localdb;

import android.arch.persistence.room.Room;
import android.content.Context;

import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDao;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

public class DBService {

    private static SSDB con=null;

    public  SSDB DBService(Context c) {
        if(con==null) {
            con = Room.databaseBuilder(c, SSDB.class, "ss-db").allowMainThreadQueries().build();
        }

        return con;
    }





}
