package com.example.cavdy.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForeignNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_news);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ForeignNewsFragment())
                .commit();
    }
}
