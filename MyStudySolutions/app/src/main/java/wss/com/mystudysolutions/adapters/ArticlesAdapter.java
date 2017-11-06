package wss.com.mystudysolutions.adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.activites.TopStackActivity;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.listeners.ButtonClickListners;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder> {
    ArrayList<Article> articles;

    ImageLoader imgLoader;
    DisplayImageOptions options;
    Activity activity;

    public ArticlesAdapter(ArrayList<Article> articles, Activity activity) {
        this.articles = articles;
        this.activity = activity;
        imgLoader = SingletoneApp.getImageLoaderInstance();
        options = SingletoneApp.getImageLoaderOptions();

    }

    @Override
    public ArticlesAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticlesAdapter.ArticleViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ArticlesAdapter.ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleDate.setText(article.getCreatedDate());
        holder.articleAuthor.setText("Author @"+article.getAuthor());
        imgLoader.displayImage(article.getImageUrl(), holder.cover, options);

        switch (article.getClicked())
        {
            case 0:
                holder.status.setVisibility(View.VISIBLE);
                break;
            case 1:
                holder.status.setVisibility(View.INVISIBLE);
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.SOURCE, AppConstants.BLOG);
        bundle.putInt(AppConstants.BLOG_ID, article.getPostId());

        holder.cover.setOnClickListener(new ButtonClickListners(AppConstants.NAVIGATE, null,
                new Intent(activity, TopStackActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                        .putExtra(AppConstants.BUNDLE, bundle), activity));

        holder.cv.setOnClickListener(new ButtonClickListners(AppConstants.NAVIGATE, null,
                new Intent(activity, TopStackActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                        .putExtra(AppConstants.BUNDLE, bundle), activity));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_artical)
        CardView cv;

        @BindView(R.id.article_title)
        TextView articleTitle;

        @BindView(R.id.cover)
        ImageView cover;

        @BindView(R.id.article_date)
        TextView articleDate;

        @BindView(R.id.article_author)
        TextView articleAuthor;

        @BindView(R.id.article_status)
        TextView status;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
