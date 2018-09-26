package com.example.cavdy.newsapp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cavdy.newsapp.Adapter.ForeignnewsHorizontalRecyclerviewAdapter;
import com.example.cavdy.newsapp.Adapter.ForeignnewsRecyclerviewAdapter;
import com.example.cavdy.newsapp.Adapter.LocalnewsRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocalnewsFragment extends Fragment {

    private static final String USGS_REQUEST_URL = "https://content.guardianapis.com/search?q=debate%20AND%20economy&tag=politics/politics&from-date=2014-01-01&api-key=1b4996a8-fa54-4f58-b7ac-2f68cd476e54";

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private LocalnewsRecyclerviewAdapter localnewsRecyclerviewAdapter;

    public static final String LOG_TAG = LocalnewsFragment.class.getName();

    public LocalnewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_localnews, container, false);
        ButterKnife.bind(this, view);

        localnewsRecyclerviewAdapter = new LocalnewsRecyclerviewAdapter(getActivity(), new ArrayList<News>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(localnewsRecyclerviewAdapter);

        LocalnewsFragment.NewsAsyncTask newsAsyncTask = new LocalnewsFragment.NewsAsyncTask();
        newsAsyncTask.execute(USGS_REQUEST_URL);

        return view;
    }

    private class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {

        @Override
        protected List<News> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<News> result = QueryUtils.fetchNewsData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);
        }
    }

}
