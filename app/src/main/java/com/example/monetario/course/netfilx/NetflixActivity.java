package com.example.monetario.course.netfilx;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.monetario.R;

public class NetflixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

    }
}