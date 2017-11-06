package wss.com.mystudysolutions.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.adapters.NewsAdapter;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.models.News;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    @BindView(R.id.rv_news)
    RecyclerView recyclerView;


    public NewsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        ArrayList<News> newsList=(ArrayList<News>) bundle.getSerializable(AppConstants.NEWS_LIST);
        View view= inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this,view);
        recyclerView.setAdapter(new NewsAdapter(newsList));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SingletoneApp.getIntances());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
