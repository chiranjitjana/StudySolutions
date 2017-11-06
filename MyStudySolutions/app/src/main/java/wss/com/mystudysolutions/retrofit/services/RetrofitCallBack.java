package wss.com.mystudysolutions.retrofit.services;

/**
 * Created by Chiranjit Jana on 04/11/2017.
 */

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wss.com.mystudysolutions.localdb.dao.BlogDaoCrud;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDao;
import wss.com.mystudysolutions.localdb.DBService;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDaoCrud;
import wss.com.mystudysolutions.models.BlogHeaderList;
import wss.com.mystudysolutions.models.BlogsHeader;
import wss.com.mystudysolutions.utils.AppConstants;

public class RetrofitCallBack implements Callback<String> {

    private static final String CLASS = RetrofitCallBack.class.getSimpleName();


    private String responseType;
    private Context c;

    public RetrofitCallBack(String responseType, Context c) {
        this.responseType = responseType;
        this.c = c;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        Object body = response.body();
        switch (responseType) {
            case AppConstants.BLOG_HEADERS:
                BlogHeaderDaoCrud blogHeader=new BlogHeaderDaoCrud(c);
                blogHeader.blogHeaderSave(body);
                break;
            case AppConstants.BLOG:
                BlogDaoCrud blog=new BlogDaoCrud(c);
                blog.blogSave(body);
                break;

        }
    }



    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Log.e(CLASS, t.getLocalizedMessage());
    }


}
