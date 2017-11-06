package wss.com.mystudysolutions.retrofit.services;

import android.content.Context;

import retrofit2.Call;
import wss.com.mystudysolutions.retrofit.RetrofitClient;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 04/11/2017.
 */

public class RetrofitServiceImpl {
    static Call<String> call = null;
    static RetrofitService apiService =
            RetrofitClient.getClient().create(RetrofitService.class);

    public static void call(String responseType, Context c) {

        switch (responseType) {
            case AppConstants.BLOG_HEADERS:
                call = apiService.getBlogsHeader();
                call.enqueue(new RetrofitCallBack(responseType,c));
                break;
            case AppConstants.BLOG:
                call = apiService.getBlogs();
                call.enqueue(new RetrofitCallBack(responseType,c));
                break;
        }

    }


}
