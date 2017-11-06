package wss.com.mystudysolutions.retrofit.services;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import wss.com.mystudysolutions.utils.RestConstants;

/**
 * Created by Chiranjit Jana on 20/10/2017.
 */

public interface RetrofitService {
    @GET(RestConstants.ALLBLOGS)
    Call<String> getBlogs();

    @GET(RestConstants.ALL_BLOGS_HEADER)
    Call<String> getBlogsHeader();

}
