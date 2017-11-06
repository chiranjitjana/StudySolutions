package wss.com.mystudysolutions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.listeners.ButtonClickListners;
import wss.com.mystudysolutions.models.Semester;
import wss.com.mystudysolutions.models.Subject;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 29/10/2017.
 */

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.SemesterViewHolder> {
    ArrayList<Subject> subject;

    public SemesterAdapter(ArrayList<Subject> subject) {
        this.subject=subject;

    }

    @Override
    public SemesterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_subject_for_sem, parent, false);
        return new SemesterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SemesterViewHolder holder, int position) {
        Subject subject = this.subject.get(position);
        holder.title.setText(subject.getSubName());
        holder.viewBtn.setOnClickListener(new ButtonClickListners(AppConstants.VIEW_BUTTON,null,null,null));
        holder.viewBtn.setOnClickListener(new ButtonClickListners(AppConstants.DOWNLOAD_BUTTON,null,null,null));
    }

    @Override
    public int getItemCount() {
        return subject.size();
    }

    public class SemesterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.subject_title)
        TextView title;
        @BindView(R.id.subject_cover)
        ImageView cover;
        @BindView(R.id.subject_syllabus_download)
        Button downloadBtn;
        @BindView(R.id.subject_syllabus_view)
        Button viewBtn;



        public SemesterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
