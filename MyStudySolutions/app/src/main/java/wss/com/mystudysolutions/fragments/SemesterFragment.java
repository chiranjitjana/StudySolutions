package wss.com.mystudysolutions.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.adapters.PracticalAdapter;
import wss.com.mystudysolutions.adapters.QBAndQPAdapter;
import wss.com.mystudysolutions.adapters.SemesterAdapter;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.models.Semester;
import wss.com.mystudysolutions.uicommons.GridSpacingItemDecoration;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemesterFragment extends Fragment {

    @BindView(R.id.semester_rv)
    @Nullable
    RecyclerView semseterRv;

    public SemesterFragment() {
        // Required empty public constructor

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=null;
        Bundle bundle=this.getArguments();
        String viewType=(String) bundle.getSerializable(AppConstants.FRAGMENT_TYPE);
        RecyclerView.LayoutManager mLayoutManager =  new GridLayoutManager(SingletoneApp.getIntances(), 2);
        Semester sem=(Semester) bundle.getSerializable(AppConstants.SEMESTER);
        view= inflater.inflate(R.layout.fragment_semester, container, false);
        ButterKnife.bind(this,view);
        switch (viewType)
        {
            case AppConstants.SYLLABUS:
                semseterRv.setAdapter(new SemesterAdapter(sem.getSubject()));
                break;

            case AppConstants.PRACTICAL:
                semseterRv.setAdapter(new PracticalAdapter(sem.getSubject(),this.getActivity()));
                break;
            case AppConstants.QB:
                semseterRv.setAdapter(new QBAndQPAdapter(sem.getSubject(),this.getActivity(),viewType));
                break;
            case AppConstants.QP:
                semseterRv.setAdapter(new QBAndQPAdapter(sem.getSubject(),this.getActivity(),viewType));
                break;


        }


        semseterRv.setLayoutManager(mLayoutManager);
        semseterRv.setItemAnimator(new DefaultItemAnimator());
        semseterRv.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));


        return view;
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
