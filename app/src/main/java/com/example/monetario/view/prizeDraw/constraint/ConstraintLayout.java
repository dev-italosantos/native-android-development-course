package com.example.monetario.view.prizeDraw.constraint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.monetario.R;
import com.example.monetario.course.jokenpo.JokenpoActivity;
import com.example.monetario.course.netfilx.NetflixActivity;
import com.example.monetario.course.phrase.PhraseDay;

public class ConstraintLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrant);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        antLayout();

        proxLayout();
    }
//    app:endIconMode="clear_text"

    private void proxLayout() {
        Button btnProx = findViewById(R.id.btnProx);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConstraintLayout.this, JokenpoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void antLayout() {
        Button btnAnt = findViewById(R.id.btnAnt);

        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConstraintLayout.this, PhraseDay.class);
                startActivity(intent);
            }
        });
    }
}