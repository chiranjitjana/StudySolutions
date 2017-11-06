package wss.com.mystudysolutions.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.adapters.ArticlesAdapter;
import wss.com.mystudysolutions.adapters.CourseAdapter;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.Course;
import wss.com.mystudysolutions.models.Semester;
import wss.com.mystudysolutions.uicommons.GridSpacingItemDecoration;
import wss.com.mystudysolutions.uicommons.ViewPagerAdapter;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

public class SingleCourseFragment extends Fragment {

    @BindView(R.id.courses_rv)
    @Nullable
    RecyclerView courseRecyclerView;

    @BindView(R.id.article_rv)
    @Nullable
    RecyclerView articleRecyclerView;


    @BindView(R.id.semester_pager)
    @Nullable
    ViewPager semesterPager;

    @BindView(R.id.semester_tabs)
    @Nullable
    TabLayout semesterTablyout;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = null;
        Bundle bundle = this.getArguments();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SingletoneApp.getIntances());
        String type = bundle.getString(AppConstants.FRAGMENT_TYPE);




        switch (type) {
            case AppConstants.COURSES:
                Course course = (Course) bundle.getSerializable(AppConstants.COURSES);
                view = inflater.inflate(R.layout.fragment_course_details, container, false);
                ButterKnife.bind(this, view);
                courseRecyclerView.setAdapter(new CourseAdapter(course));
                courseRecyclerView.setLayoutManager(mLayoutManager);
                courseRecyclerView.setItemAnimator(new DefaultItemAnimator());
                break;

            case AppConstants.ARTICALES:


                ArrayList<Article> articles = (ArrayList<Article>) bundle.getSerializable(AppConstants.ARTICALES);
                view = inflater.inflate(R.layout.layout_articles_and_lectures, container, false);
                ButterKnife.bind(this, view);

                articleRecyclerView.setAdapter(new ArticlesAdapter(articles,getActivity()));
                mLayoutManager = new GridLayoutManager(SingletoneApp.getIntances(), 2);
                articleRecyclerView.setLayoutManager(mLayoutManager);
                articleRecyclerView.setItemAnimator(new DefaultItemAnimator());
                articleRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                break;

            case AppConstants.SYLLABUS:
                view = inflater.inflate(R.layout.fragment_child_tablayout, container, false);
                ButterKnife.bind(this, view);
                Course syllabus = (Course) bundle.getSerializable(AppConstants.SYLLABUS);
                ArrayList<Semester> semesters = syllabus.getSemesters();
                setupViewPager(semesters, AppConstants.SYLLABUS);
                semesterTablyout.setupWithViewPager(semesterPager);
                break;

            case AppConstants.PRACTICAL:
                view = inflater.inflate(R.layout.fragment_child_tablayout, container, false);
                ButterKnife.bind(this, view);
                Course practicals = (Course) bundle.getSerializable(AppConstants.PRACTICAL);
                ArrayList<Semester> practical = practicals.getSemesters();
                setupViewPager(practical, AppConstants.PRACTICAL);
                semesterTablyout.setupWithViewPager(semesterPager);
                break;

            case AppConstants.QB:
                view = inflater.inflate(R.layout.fragment_child_tablayout, container, false);
                ButterKnife.bind(this, view);
                Course qb = (Course) bundle.getSerializable(AppConstants.QB);
                ArrayList<Semester> qb_sems = qb.getSemesters();
                setupViewPager(qb_sems, AppConstants.QB);
                semesterTablyout.setupWithViewPager(semesterPager);
                break;

        }

        return view;
    }

    //setup the viewPager
    private void setupViewPager(Object data, String viewType) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setDataAndTitle(adapter, data, viewType);
        semesterPager.setAdapter(adapter);
    }

    private void setDataAndTitle(ViewPagerAdapter adapter, Object data, String viewType) {
        List<Fragment> listF = null;
        listF = fetchFragment(data, viewType);
        adapter.addFragment(listF, fetchTabHeader(data));
    }


    private List<Fragment> fetchFragment(Object data, String viewType) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<Semester> listSem = (ArrayList<Semester>) data;
        for (Semester sem : listSem) {
            Bundle bundle = new Bundle();
            switch (viewType) {
                case AppConstants.SYLLABUS:
                    bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.SYLLABUS);
                    bundle.putSerializable(AppConstants.SEMESTER, sem);

                    break;

                case AppConstants.PRACTICAL:
                    bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.PRACTICAL);
                    bundle.putSerializable(AppConstants.SEMESTER, sem);

                    break;
                case AppConstants.QB:
                    bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.QB);
                    bundle.putSerializable(AppConstants.SEMESTER, sem);
                    break;
            }
            SemesterFragment singleSemFragment = new SemesterFragment();
            singleSemFragment.setArguments(bundle);
            listF.add(singleSemFragment);

        }


        return listF;
    }

    private List<String> fetchTabHeader(Object data) {
        ArrayList<Semester> listCourses = (ArrayList<Semester>) data;
        List<String> header = new ArrayList<>();
        for (Semester sem : listCourses) {
            header.add(sem.getSemName());
        }
        return header;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
