package wss.com.mystudysolutions.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.localdb.dao.BlogDaoCrud;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {

    @BindView(R.id.img_blog)
    ImageView cover;

    @BindView(R.id.title_blog)
    TextView title;

    @BindView(R.id.blog_author)
    TextView author;

    @BindView(R.id.blog_description)
    TextView description;

    @BindView(R.id.blog_created_date)
    TextView createdDate;

    DisplayImageOptions options;

    ImageLoader imgLoader;

    public BlogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgLoader = SingletoneApp.getImageLoaderInstance();
        options = SingletoneApp.getImageLoaderOptions();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle arguments = this.getArguments();
        Integer blogId=arguments.getInt(AppConstants.BLOG_ID);

        Article article = new BlogDaoCrud(getContext()).fetchBlogById(blogId);

        View view= inflater.inflate(R.layout.fragment_blog, container, false);
        ButterKnife.bind(this,view);
        title.setText(article.getTitle());
        author.setText(article.getAuthor());
        description.setText(article.getDescriptiion());
        createdDate.setText(article.getCreatedDate());
        imgLoader.displayImage(article.getImageUrl(),cover,options);
        article.setClicked(1);
        new BlogDaoCrud(getContext()).setSeenFlag(article);
        return view;
    }

}
