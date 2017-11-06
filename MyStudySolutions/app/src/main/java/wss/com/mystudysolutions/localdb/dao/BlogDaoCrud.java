package wss.com.mystudysolutions.localdb.dao;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import wss.com.mystudysolutions.localdb.DBService;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.BlogHeaderList;
import wss.com.mystudysolutions.models.BlogList;
import wss.com.mystudysolutions.models.BlogsHeader;

/**
 * Created by Chiranjit Jana on 05/11/2017.
 */

public class BlogDaoCrud {

    private static final String CLASS = BlogHeaderDaoCrud.class.getSimpleName();
    private static BlogDao blogDao;
    private Context c;

    public BlogDaoCrud(Context c) {
        this.c = c;
        blogDao=new DBService().DBService(c).blogDao();
    }

    public Article fetchBlogById(Integer postId)
    {
        return blogDao.getBlogById(postId);
    }

    public void setSeenFlag(Article article){
        blogDao.updateBlog(article);
    }



    public   ArrayList<List<Article>>  fectchBlogs() {

        ArrayList<List<Article>> articles = new ArrayList<List<Article>>();
        List<String> headerList=new ArrayList<>();
        List<Article> allBlog = blogDao.getAllBlogs();

        //for carry all the header id
        Set<Integer> headerId=new HashSet<>();
        //for actual use of headerid
        List<Integer> headerIdList = new ArrayList<>();
        //fetching all the disctinct header id
        for (Article singleBlogHeader:allBlog) {
            headerId.add(singleBlogHeader.getBlogHeaderid());
        }

        headerIdList.addAll(headerId);

        for (int x=0;x<headerIdList.size();x++)
        {
            articles.add(blogDao.getBlogByHeader(headerIdList.get(x)));
        }


        return articles;
    }

    public void blogSave(Object body) {

        saveBlog(body);
    }

    private List<Article> saveBlog(Object body) {

        Log.e(CLASS, body.toString());

        BlogList blogList = stringToArray(body.toString(), BlogList.class);


        for (Article blog : blogList.getBlogList()) {
            if (blogDao.isBlogExists(blog.getPostId()) == 0) {
                blog.setClicked(0);
                blogDao.insertSingleBlog(blog);

            }

        }
        return blogDao.getAllBlogs();
    }





    private static <T> T stringToArray(String s, Class<T> clazz) {
        T obj = new Gson().fromJson(s, clazz);
        return obj;
    }





}
