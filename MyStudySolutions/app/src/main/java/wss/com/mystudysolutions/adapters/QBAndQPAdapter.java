package wss.com.mystudysolutions.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.activites.TopStackActivity;
import wss.com.mystudysolutions.listeners.ButtonClickListners;
import wss.com.mystudysolutions.models.Subject;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 31/10/2017.
 */

public class QBAndQPAdapter extends RecyclerView.Adapter<QBAndQPAdapter.QBAndQPViewHolder> {
    ArrayList<Subject> subject;
    String viewType;
    FragmentActivity activity;

    public QBAndQPAdapter(ArrayList<Subject> subject, FragmentActivity activity, String viewType) {
        this.subject = subject;
        this.viewType = viewType;
        this.activity = activity;
    }

    @Override
    public QBAndQPViewHolder onCreateViewHolder(ViewGroup parent, int vtype) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.qb_list_item, parent, false);

        return new QBAndQPViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QBAndQPViewHolder holder, int position) {
        Subject subject = this.subject.get(position);

        Bundle bundle = new Bundle();
        if (viewType == AppConstants.QB)
            bundle.putString(AppConstants.SOURCE, AppConstants.QB);
        else
            bundle.putString(AppConstants.SOURCE, AppConstants.QP);

        bundle.putString(AppConstants.SUBJECT_CODE, subject.getSubId());


        holder.title.setText(subject.getSubName());
        holder.cover.setOnClickListener(new ButtonClickListners(AppConstants.NAVIGATE,
                null
                , new Intent(activity, TopStackActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                .putExtra(AppConstants.BUNDLE, bundle),
                activity));

    }

    @Override
    public int getItemCount() {
        return subject.size();
    }

    public class QBAndQPViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.qb_cv)
        CardView cv;
        @BindView(R.id.question_cover)
        ImageView cover;
        @BindView(R.id.question_title)
        TextView title;


        public QBAndQPViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
