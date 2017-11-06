package wss.com.mystudysolutions.localdb.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import wss.com.mystudysolutions.localdb.DBService;
import wss.com.mystudysolutions.models.BlogHeaderList;
import wss.com.mystudysolutions.models.BlogsHeader;


/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

public class BlogHeaderDaoCrud {
    private static final String CLASS = BlogHeaderDaoCrud.class.getSimpleName();
    private static BlogHeaderDao blogHeaderDao;
    private Context c;

    public BlogHeaderDaoCrud(Context c) {
        this.c = c;
        blogHeaderDao = new DBService().DBService(c).blogHeaderDao();
    }

    public void blogHeaderSave(Object body) {

        saveBlogHeader(body);
    }

    public  List<String> fectchBlogsHeader() {
        List<String> headerList=new ArrayList<>();
        List<BlogsHeader> allBlogHeaders = blogHeaderDao.getAllBlogHeaders();

        for (BlogsHeader singleBlogHeader:allBlogHeaders) {
            headerList.add(singleBlogHeader.getTitle());
        }
        return headerList;
    }



    private static <T> T stringToArray(String s, Class<T> clazz) {
        T obj = new Gson().fromJson(s, clazz);
        return obj;
    }


/*
    protected class BackgroundTask extends AsyncTask<Object, Void, Object> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Object doInBackground(Object... objects) {
            String targetViewType = ((CustomObject) objects[0]).getTargetViewType();
            Object obj=null;
            switch (targetViewType) {

                case AppConstants.BLOG_HEADERS:
                    obj=saveBlogHeader(((CustomObject) objects[0]).getData());
                    break;


            }


            return obj;
        }

        @Override
        protected void onPostExecute(Object val) {
            super.onPostExecute(val);
            String targetViewType = ((CustomObject) val).getTargetViewType();
            switch (targetViewType) {

                case AppConstants.BLOG_HEADERS:

                    break;


            }


        }
    }
*/


    private List<BlogsHeader> saveBlogHeader(Object objects) {


        Log.e(CLASS, objects.toString());

        BlogHeaderList blogHeaderList = stringToArray(objects.toString(), BlogHeaderList.class);


        for (BlogsHeader blogHeader : blogHeaderList.getHeaderList()) {
            if (blogHeaderDao.isHeaderExists(blogHeader.getHeaderId()) == 0) {
                blogHeaderDao.insertSingleBlogHeaderList(blogHeader);

            }

        }
        return blogHeaderDao.getAllBlogHeaders();
    }


}
