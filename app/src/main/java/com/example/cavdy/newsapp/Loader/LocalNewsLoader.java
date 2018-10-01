package com.example.cavdy.newsapp.Loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.example.cavdy.newsapp.News;
import com.example.cavdy.newsapp.Query.LocalQueryUtils;
import com.example.cavdy.newsapp.Query.SportQueryUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.example.cavdy.newsapp.ForeignNewsFragment.LOG_TAG;

public class LocalNewsLoader extends AsyncTaskLoader<List<News>>{
    public LocalNewsLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        List<News> newsList = null;
        try {
            URL url = LocalQueryUtils.createUrl();
            String jsonResponse = LocalQueryUtils.makeHttpRequest(url);
            newsList = LocalQueryUtils.extractFeatureFromJson(jsonResponse);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error Loader LoadInBackground: ", e);
        }
        return newsList;
    }
}
