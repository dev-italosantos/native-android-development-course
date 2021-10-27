package com.example.monetario.view.prizeDraw.constraintLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.monetario.R;
import com.example.monetario.view.prizeDraw.PrizeDrawActivity;

public class ConstraintLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrant);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

    jogarProx();
    }

    private void jogarProx() {
        Button btnProx = findViewById(R.id.btnProx);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConstraintLayout.this, PrizeDrawActivity.class);
                startActivity(intent);
            }
        });
    }
}