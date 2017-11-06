package wss.com.mystudysolutions.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.models.Practical;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 30/10/2017.
 */

public class PracticalSubjectAdapter extends RecyclerView.Adapter<PracticalSubjectAdapter.PracticalListViewHolder> {

    ArrayList<Practical> prList;
    FragmentActivity activity;
    public PracticalSubjectAdapter(ArrayList<Practical> prList, FragmentActivity activity) {
        this.prList=prList;
        this.activity=activity;
    }


    @Override
    public PracticalListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.practical_list_item, parent, false);
        return new PracticalListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PracticalListViewHolder holder, int position) {
        Practical practical = prList.get(position);
        holder.title.setText(practical.getpTitle());
        holder.description.setText(practical.getpDescription());
        holder.createDate.setText(practical.getCreatedDate());
        holder.author.setText(practical.getAuthor());
        switch (practical.getpType())
        {
            case AppConstants.VIDEO:
                holder.iv.setImageResource(R.drawable.ic_video_player);
                holder.status.setVisibility(View.INVISIBLE);
                break;
            case AppConstants.NONVIDEO:
                holder.iv.setImageResource(R.drawable.ic_document);
                holder.status.setVisibility(View.VISIBLE);
                break;
        }



    }

    @Override
    public int getItemCount() {
        return prList.size();
    }

    public class PracticalListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pr_card_view)
        CardView cv;
        @BindView(R.id.pr_title)
        TextView title;
        @BindView(R.id.pr_status)
        TextView status;
        @BindView(R.id.pr_description)
        TextView description;
        @BindView(R.id.content_type)
        ImageView iv;
        @BindView(R.id.article_author)
        TextView author;
        @BindView(R.id.article_date)
        TextView createDate;

        public PracticalListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
