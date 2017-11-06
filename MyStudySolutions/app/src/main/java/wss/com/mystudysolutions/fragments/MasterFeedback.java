package wss.com.mystudysolutions.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.testdata.Test;
import wss.com.mystudysolutions.uicommons.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFeedback extends Fragment {
    @BindView(R.id.feedback_pager)
    ViewPager feedbackPager;

    @BindView(R.id.feedback_tabs)
    TabLayout feedbackTablyout;

    public MasterFeedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_master_feedback, container, false);
        ButterKnife.bind(this,view);
        setupViewPager();
        feedbackTablyout.setupWithViewPager(feedbackPager);

        return view;
    }

    private void setupViewPager() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        List<Fragment> listF=new ArrayList<>();
        listF.add(new FeedbackFormFragment());
        listF.add(new ListPreviousFeedbackFragment());

        adapter.addFragment(listF, Test.getFeedbackHeaderTab());
        feedbackPager.setAdapter(adapter);
    }

}
