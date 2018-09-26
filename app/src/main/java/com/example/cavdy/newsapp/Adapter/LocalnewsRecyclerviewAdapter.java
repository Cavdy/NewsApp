package com.example.cavdy.newsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cavdy.newsapp.News;
import com.example.cavdy.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalnewsRecyclerviewAdapter extends RecyclerView.Adapter<LocalnewsRecyclerviewAdapter.MyViewHolder> {

    private Context mContext;
    private List<News> mData;

    public LocalnewsRecyclerviewAdapter(Context mContext, List<News> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.foreignnews_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.post_heading.setText(mData.get(i).getmTitle());
        Picasso.get().load(mData.get(i).getmUrl()).into(myViewHolder.post_thubmnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.post_thumbnail)
        ImageView post_thubmnail;
        @BindView(R.id.post_heading)
        TextView post_heading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
