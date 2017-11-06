package wss.com.mystudysolutions.localdb.dao;

import android.content.Context;

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
 * Created by Chiranjit Jana on 06/11/2017.
 */

public class FetcherData {
    private static final String CLASS = FetcherData.class.getSimpleName();
    private static BlogDao blogDao;
    private static BlogHeaderDao blogHeaderDao;

    private Context c;

    public FetcherData(Context c) {
        this.c = c;
        blogDao = new DBService().DBService(c).blogDao();
        blogHeaderDao = new DBService().DBService(c).blogHeaderDao();
    }

    //fetch all the blogs
    public BlogHeaderList getBlogs() {
        BlogHeaderList blogHeaderList = new BlogHeaderList();

        List<BlogsHeader> allBlogHeaders = blogHeaderDao.getAllBlogHeaders();

        //for actual use of headerid
        List<Integer> headerIdList = new ArrayList<>();
        //fetching all the disctinct header id
        for (BlogsHeader singleBlogHeader : allBlogHeaders) {
            headerIdList.add(singleBlogHeader.getHeaderId());
        }

        for (int k = 0; k < allBlogHeaders.size(); k++) {
            List<Article> articalList = blogDao.getBlogByHeader(headerIdList.get(k));
            BlogList blogList = new BlogList();
            blogList.setBlogList(articalList);
            allBlogHeaders.get(k).setBlogLists(blogList);
        }
        blogHeaderList.setHeaderList(allBlogHeaders);
        return blogHeaderList;
    }

    //fetching all the blog header
    public List<String> fetchHeader(BlogHeaderList blogs) {
        List<BlogsHeader> headerList = blogs.getHeaderList();
        List<String> ls = new ArrayList<String>();
        for (BlogsHeader header : headerList) {
            ls.add(header.getTitle());
        }
        return ls;
    }

    //fetching all the blog post
    public Object fetchBlogListFragments(BlogHeaderList blogs) {
        ArrayList<ArrayList<Article>> articles = new ArrayList<ArrayList<Article>>();

        List<BlogsHeader> headerList = blogs.getHeaderList();

        for (BlogsHeader header : headerList) {
            ArrayList<Article> blogList = (ArrayList<Article>) header.getBlogLists().getBlogList();
            articles.add(blogList);
        }

        return articles;
    }
}
