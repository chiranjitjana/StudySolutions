package wss.com.mystudysolutions.activites;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.fragments.BlogFragment;
import wss.com.mystudysolutions.fragments.CoursesFragment;
import wss.com.mystudysolutions.fragments.PracticalFragment;
import wss.com.mystudysolutions.fragments.QuestionBankFragment;
import wss.com.mystudysolutions.models.QuestionBank;
import wss.com.mystudysolutions.models.Subject;
import wss.com.mystudysolutions.testdata.Test;
import wss.com.mystudysolutions.utils.AppConstants;

public class TopStackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_stack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);

        Bundle bundle = getIntent().getExtras().getBundle(AppConstants.BUNDLE);

        String fragmentType = bundle.getString(AppConstants.SOURCE);
        FragmentTransaction transaction = getFragmentTransaction();
        String subjectId = null;
        switch (fragmentType) {
            case AppConstants.PRACTICAL:
                //the belowe subject code will used for fetching the pratical list for perticular subject
                subjectId = bundle.getString(AppConstants.SUBJECT_CODE);
                PracticalFragment praticalFragment = new PracticalFragment();
                bundle = new Bundle();
                bundle.putString(AppConstants.SUBJECT_CODE, subjectId);
                bundle.putSerializable(AppConstants.PRACTICAL_LIST, Test.getPractical());
                praticalFragment.setArguments(bundle);

                transaction.replace(R.id.content_frame_top_stack, praticalFragment);

                break;
            case AppConstants.QB:
                subjectId = bundle.getString(AppConstants.SUBJECT_CODE);
                QuestionBankFragment qbFragment = new QuestionBankFragment();
                bundle = new Bundle();
                bundle.putString(AppConstants.SUBJECT_CODE, subjectId);
                bundle.putSerializable(AppConstants.QB_LIST, Test.getQB());
                qbFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame_top_stack, qbFragment);

                break;
            case AppConstants.BLOG:
                Integer postId = bundle.getInt(AppConstants.BLOG_ID);
                BlogFragment blogFragment = new BlogFragment();
                bundle = new Bundle();
                bundle.putInt(AppConstants.BLOG_ID, postId);
                blogFragment.setArguments(bundle);
                transaction.replace(R.id.content_frame_top_stack, blogFragment);

                break;


        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }


    @Override
    protected void onPause() {
        super.onPause();
       /* overridePendingTransition( R.anim.slide_in_down, R.anim.slide_out_down );*/
    }

    private FragmentTransaction getFragmentTransaction() {
        return getSupportFragmentManager().beginTransaction();
    }

}
