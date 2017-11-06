package wss.com.mystudysolutions.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import wss.com.mystudysolutions.localdb.dao.BlogDaoCrud;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDao;
import wss.com.mystudysolutions.localdb.dao.BlogHeaderDaoCrud;
import wss.com.mystudysolutions.localdb.dao.FetcherData;
import wss.com.mystudysolutions.models.Article;
import wss.com.mystudysolutions.models.BlogHeaderList;
import wss.com.mystudysolutions.models.Course;
import wss.com.mystudysolutions.testdata.Test;
import wss.com.mystudysolutions.utils.AppConstants;
import wss.com.mystudysolutions.uicommons.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {




    @BindView(R.id.courses_pager)
    ViewPager coursesPager;

    @BindView(R.id.courses_tabs)
    TabLayout coursesTablyout;


    public CoursesFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        //fetching the type of fragment
        String type = bundle.getString(AppConstants.FRAGMENT_TYPE);
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        ButterKnife.bind(this, view);
        //setup the view pager
        setupViewPager(type);
        coursesTablyout.setupWithViewPager(coursesPager);
        return view;
    }


    //setup the viewPager
    private void setupViewPager(String type) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setCourses(adapter, type);
        coursesPager.setAdapter(adapter);
    }


    private void setCourses(ViewPagerAdapter adapter, String type) {
        List<Fragment> listF = null;

        switch (type) {
            case AppConstants.COURSES:
                //fetch the data from sqlite and list
                listF = getCourseDetailsFragments(Test.getGenericData());
                adapter.addFragment(listF,  Test.getGenericHeaderForTablayout(Test.getGenericData()));
                break;

            case AppConstants.ARTICALES:
                //fetch the data from sqlite and list
                FetcherData data=new FetcherData(getContext());
                BlogHeaderList blogs = data.getBlogs();



                listF = getArticlesCourseDetailsFragments(data.fetchBlogListFragments(blogs));
                adapter.addFragment(listF, data.fetchHeader(blogs));
                break;
            case AppConstants.SYLLABUS:
                listF = getSemesterCourseDetailsFragments(Test.getGenericData());
                adapter.addFragment(listF,  Test.getGenericHeaderForTablayout(Test.getGenericData()));
                break;

            case AppConstants.PRACTICAL:
                listF = getPracticalCourseDetailsFragments(Test.getGenericData());
                adapter.addFragment(listF,  Test.getGenericHeaderForTablayout(Test.getGenericData()));
                break;

            case AppConstants.QB:
                listF = getQBCourseDetailsFragments(Test.getGenericData());
                adapter.addFragment(listF,  Test.getGenericHeaderForTablayout(Test.getGenericData()));
                break;


        }

    }

    private List<Fragment> getQBCourseDetailsFragments(Object courses) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<Course> local=(ArrayList<Course>)courses;

        for (Course course : local) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.QB);
            bundle.putSerializable(AppConstants.QB, course);
            SingleCourseFragment singleCourseFragment = new SingleCourseFragment();
            singleCourseFragment.setArguments(bundle);
            listF.add(singleCourseFragment);
        }

        return listF;
    }

    private List<Fragment> getPracticalCourseDetailsFragments(Object data) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<Course> local=(ArrayList<Course>)data;

        for (Course course : local) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.PRACTICAL);
            bundle.putSerializable(AppConstants.PRACTICAL, course);
            SingleCourseFragment singleCourseFragment = new SingleCourseFragment();
            singleCourseFragment.setArguments(bundle);
            listF.add(singleCourseFragment);
        }

        return listF;
    }


    private List<Fragment> getSemesterCourseDetailsFragments(Object data) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<Course> local=(ArrayList<Course>)data;
        for (Course course : local) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.SYLLABUS);
            bundle.putSerializable(AppConstants.SYLLABUS, course);
            SingleCourseFragment singleCourseFragment = new SingleCourseFragment();
            singleCourseFragment.setArguments(bundle);
            listF.add(singleCourseFragment);
        }

        return listF;
    }

    public static List<Fragment> getArticlesCourseDetailsFragments(Object data) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<ArrayList<Article>> local=( ArrayList<ArrayList<Article>>)data;
        for (ArrayList<Article> singleCourse : local) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.ARTICALES);
            bundle.putSerializable(AppConstants.ARTICALES, singleCourse);
            SingleCourseFragment singleCourseFragment = new SingleCourseFragment();
            singleCourseFragment.setArguments(bundle);
            listF.add(singleCourseFragment);
        }
        return listF;
    }

    @NonNull
    public static List<Fragment> getCourseDetailsFragments(Object data) {
        List<Fragment> listF = new ArrayList<>();
        ArrayList<Course> local=( ArrayList<Course>)data;
        for(Course singleCourse:local)
        {   Bundle bundle = new Bundle();
            bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.COURSES);
            bundle.putSerializable(AppConstants.COURSES, singleCourse);
            SingleCourseFragment singleCourseFragment = new SingleCourseFragment();
            singleCourseFragment.setArguments(bundle);
            listF.add(singleCourseFragment);

        }

        return listF;
    }

}
