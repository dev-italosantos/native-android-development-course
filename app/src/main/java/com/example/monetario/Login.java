package com.example.monetario;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.monetario.view.prizeDraw.constraint.ConstraintLayout;
import com.example.monetario.view.prizeDraw.netfilx.NetflixActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        login();
    }

    private void login() {
        Button btnProx = findViewById(R.id.btnEnter);

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ConstraintLayout.class);
                startActivity(intent);
            }
        });
    }
}