package com.example.cavdy.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocalnewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localnews);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LocalnewsFragment())
                .commit();
    }
}
