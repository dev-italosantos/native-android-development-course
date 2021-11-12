package com.example.monetario.course.jokenpo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.monetario.R;

public class JokenpoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }
}