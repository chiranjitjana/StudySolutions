package wss.com.mystudysolutions.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.adapters.PracticalAdapter;
import wss.com.mystudysolutions.adapters.PracticalSubjectAdapter;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.models.Practical;
import wss.com.mystudysolutions.uicommons.GridSpacingItemDecoration;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class PracticalFragment extends Fragment {

    @BindView(R.id.pratical_rv)
    RecyclerView prRecyclerView;

    public PracticalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle=this.getArguments();
        ArrayList<Practical> prList= (ArrayList<Practical>) bundle.getSerializable(AppConstants.PRACTICAL_LIST);
        View view= inflater.inflate(R.layout.fragment_practical, container, false);
        ButterKnife.bind(this,view);
        RecyclerView.LayoutManager mLayoutManager =  new LinearLayoutManager(SingletoneApp.getIntances());

        prRecyclerView.setAdapter(new PracticalSubjectAdapter(prList,this.getActivity()));
        prRecyclerView.setLayoutManager(mLayoutManager);
        prRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }



   /* private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }*/

}
