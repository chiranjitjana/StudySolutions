package wss.com.mystudysolutions.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wss.com.mystudysolutions.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPreviousFeedbackFragment extends Fragment {


    public ListPreviousFeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_previous_feedback, container, false);
    }

}
