package wss.com.mystudysolutions.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import wss.com.mystudysolutions.R;
import wss.com.mystudysolutions.models.QuestionBank;
import wss.com.mystudysolutions.utils.AppConstants;

/**
 * Created by Chiranjit Jana on 01/11/2017.
 */

public class QBAdapter extends RecyclerView.Adapter<QBAdapter.QBViewHolder> {

    ArrayList<QuestionBank> qblist;
    FragmentActivity activity;

    public QBAdapter(ArrayList<QuestionBank> qblist, FragmentActivity activity) {
        this.qblist = qblist;
        this.activity = activity;
    }

    @Override
    public QBViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_question_bank, parent, false);
        return new QBViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QBViewHolder holder, int position) {
        QuestionBank questionBank = qblist.get(position);
        holder.title.setText(questionBank.getTitle());

        switch (questionBank.getStatus()) {
            case AppConstants.HIDE:
                holder.status.setVisibility(View.INVISIBLE);
                break;
            case AppConstants.VISIBLE:
                holder.status.setVisibility(View.VISIBLE);
                break;
        }

        holder.descrition.setText(questionBank.getFileName());
        holder.author.setText(questionBank.getAuthor());
        holder.createDate.setText(questionBank.getCreatedDate());

    }

    @Override
    public int getItemCount() {
        return qblist.size();
    }

    public class QBViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.qb_card_view)
        CardView cv;
        @BindView(R.id.qb_title)
        TextView title;
        @BindView(R.id.qb_status)
        TextView status;
        @BindView(R.id.qb_description)
        TextView descrition;
        @BindView(R.id.qb_author)
        TextView author;
        @BindView(R.id.qb_date)
        TextView createDate;

        public QBViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
