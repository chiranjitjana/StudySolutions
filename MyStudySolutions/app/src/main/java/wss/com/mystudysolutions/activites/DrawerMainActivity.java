package wss.com.mystudysolutions.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.fragments.CoursesFragment;
import wss.com.mystudysolutions.fragments.FragmentNotification;
import wss.com.mystudysolutions.fragments.MasterFeedback;
import wss.com.mystudysolutions.fragments.NewsFragment;
import wss.com.mystudysolutions.models.News;
import wss.com.mystudysolutions.retrofit.services.RetrofitServiceImpl;
import wss.com.mystudysolutions.utils.AppConstants;

public class DrawerMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    /* private TabLayout tabLayout;
     private ViewPager viewPager;*/
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        initUI();

    }

    private void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();

    }

    private void loadData() {
        initNetworkcall(AppConstants.BLOG_HEADERS);
        initNetworkcall(AppConstants.BLOG);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //this will enable hamburger icon to open drawer when click it
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction transaction = getFragmentTransaction();
        CoursesFragment coursesFragment = new CoursesFragment();
        Bundle bundle = null;

        switch (id) {
            case R.id.nav_news:
                bundle = new Bundle();
                ArrayList<News> newsList = new ArrayList<>();
                newsList.add(new News("1", "Heavy Rain In Mumbai", "23 March 2017", "The skies turned dark by 4:30 pm - something that is unusual in the city. The famed skyline of Mumbai is completely invisible with dark clouds engulfing the skies above the Maximum City."));
                newsList.add(new News("1", "Heavy Rain In Mumbai", "23 March 2017", "The skies turned dark by 4:30 pm - something that is unusual in the city. The famed skyline of Mumbai is completely invisible with dark clouds engulfing the skies above the Maximum City."));
                newsList.add(new News("1", "Heavy Rain In Mumbai", "23 March 2017", "The skies turned dark by 4:30 pm - something that is unusual in the city. The famed skyline of Mumbai is completely invisible with dark clouds engulfing the skies above the Maximum City."));


                bundle.putSerializable(AppConstants.NEWS_LIST, newsList);

                NewsFragment newsFragment = new NewsFragment();
                newsFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, newsFragment);
                transaction.commit();
                break;

            case R.id.nav_notifications:
                /*bundle.putSerializable(AppConstants.,newsList);*/

                FragmentNotification fragmentNotification = new FragmentNotification();
               /* newsFragment.setArguments(bundle);*/
                transaction.replace(R.id.content_frame, fragmentNotification);
                transaction.commit();

                break;

            case R.id.nav_courses:
                bundle = new Bundle();
                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.COURSES);
                coursesFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, coursesFragment).commit();
                break;

            case R.id.nav_articals:

                bundle = new Bundle();
                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.ARTICALES);
                coursesFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, coursesFragment).commit();
                break;

            case R.id.nav_syllabus:
                bundle = new Bundle();
                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.SYLLABUS);
                coursesFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, coursesFragment).commit();
                break;

            case R.id.nav_practical_list:
                bundle = new Bundle();
                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.PRACTICAL);
                coursesFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, coursesFragment).commit();
                break;
            case R.id.nav_qb:
                bundle = new Bundle();
                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.QB);
                coursesFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame, coursesFragment).commit();
                break;
            case R.id.nav_feedback:
                bundle = new Bundle();
                MasterFeedback feedback = new MasterFeedback();

                bundle.putString(AppConstants.FRAGMENT_TYPE, AppConstants.FEEDBACK_MASTER);
                feedback.setArguments(bundle);
                transaction.replace(R.id.content_frame, feedback).commit();
                break;


        }


       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initNetworkcall(String type) {
        RetrofitServiceImpl.call(type, getApplicationContext());
    }


    private FragmentTransaction getFragmentTransaction() {
        return getSupportFragmentManager().beginTransaction();
    }


}
