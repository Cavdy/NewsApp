package com.example.cavdy.newsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cavdy.newsapp.News;
import com.example.cavdy.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalNewsAdapter extends ArrayAdapter<News> {

    @BindView(R.id.title) TextView title;
    @BindView(R.id.author) TextView author;
    @BindView(R.id.date) TextView date;
    @BindView(R.id.section) TextView section;

    public LocalNewsAdapter(Context context) {
        super(context, -1, new ArrayList<News>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView
                    = LayoutInflater.from(getContext()).inflate(R.layout.foreignnews_layout, parent, false);
        }
        ButterKnife.bind(this, convertView);

        News currentNews = getItem(position);
        title.setText(currentNews.getmTitle());
        author.setText(currentNews.getmAuthor());
        date.setText(currentNews.getmDate());
        section.setText(currentNews.getmSection());

        return convertView;
    }

}
