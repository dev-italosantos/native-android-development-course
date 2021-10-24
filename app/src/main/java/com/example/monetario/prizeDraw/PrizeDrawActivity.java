package com.example.monetario.prizeDraw;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.monetario.R;

import java.util.Random;

public class PrizeDrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_draw);
        clickJogar();
    }

    private void clickJogar() {
         Button btnJogar = findViewById(R.id.btnJogar);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView subTitle = findViewById(R.id.labelSubtitle);
                int x = new Random().nextInt(11);
                subTitle.setText("Número: " + x);
            }
        });
    }

}