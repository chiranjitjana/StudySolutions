package wss.com.mystudysolutions.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.activites.TopStackActivity;
import wss.com.mystudysolutions.application.SingletoneApp;
import wss.com.mystudysolutions.listeners.ButtonClickListners;
import wss.com.mystudysolutions.models.Subject;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class PracticalAdapter extends RecyclerView.Adapter<PracticalAdapter.PracticalHolder> {

    ArrayList<Subject> subject;
    Activity activity;



    public PracticalAdapter(ArrayList<Subject> subject, Activity activity) {
        this.subject = subject;
        this.activity = activity;
    }


    @Override
    public PracticalAdapter.PracticalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.practical_subject, parent, false);
        return new PracticalAdapter.PracticalHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PracticalAdapter.PracticalHolder holder, int position) {
        Subject subject = this.subject.get(position);
        holder.subTitle.setText(subject.getSubName());

        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.SOURCE,AppConstants.PRACTICAL);
        bundle.putString(AppConstants.SUBJECT_CODE, subject.getSubId());

        holder.viewButton.setOnClickListener(new ButtonClickListners(AppConstants.NAVIGATE,
                null
                , new Intent(activity, TopStackActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                .putExtra(AppConstants.BUNDLE,bundle),
                activity)
        );
    }

    @Override
    public int getItemCount() {
        return subject.size();
    }


    public class PracticalHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.practical_sub_title)
        TextView subTitle;
        @BindView(R.id.practical_sub_cover)
        ImageView subImage;
        @BindView(R.id.practical_syllabus_view)
        Button viewButton;


        public PracticalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
