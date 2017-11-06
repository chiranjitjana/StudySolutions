package wss.com.mystudysolutions.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.adapters.PracticalSubjectAdapter;
import wss.com.mystudysolutions.adapters.QBAdapter;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.models.QuestionBank;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionBankFragment extends Fragment {

    @BindView(R.id.qp_qb_rv)
    RecyclerView rv;


    public QuestionBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.qb_and_qp_layout, container, false);
        ButterKnife.bind(this,view);
        Bundle arguments = this.getArguments();

        ArrayList<QuestionBank> qblist=(ArrayList<QuestionBank>)arguments.getSerializable(AppConstants.QB_LIST);
        RecyclerView.LayoutManager mLayoutManager =  new LinearLayoutManager(SingletoneApp.getIntances());

        rv.setAdapter(new QBAdapter(qblist,this.getActivity()));
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());

        return view;
/*        return inflater.inflate(R.layout.fragment_question_bank, container, false);*/
    }

}
