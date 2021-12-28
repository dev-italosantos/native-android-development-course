package com.example.monetario.view.course.alcoholOrGasoline;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.monetario.R;

public class AlcoholOrGasoline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_or_gasoline);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }
}