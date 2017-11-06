package wss.com.mystudysolutions.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.models.Course;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 28/10/2017.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Course courseList;
    public CourseAdapter(Course courseList)
    {
        this.courseList=courseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_single_courses, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course course = courseList;
        holder.contentHeader.setText(course.getCourseTitle());
        holder.contentDescription.setText(course.getDescription());
        holder.duration.setText(course.getDuration());
        holder.eligiblity.setText(course.getEligiblity());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.course_content_header)
        @Nullable
        TextView contentHeader;

        @BindView(R.id.content_description)
        @Nullable
        TextView contentDescription;

        @BindView(R.id.duration)
        @Nullable
        TextView duration;

        @BindView(R.id.eligiblity)
        @Nullable
        TextView eligiblity;
        public CourseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
