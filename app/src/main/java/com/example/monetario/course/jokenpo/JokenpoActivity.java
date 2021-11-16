package com.example.monetario.course.jokenpo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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

    public void selecionaPedra(View view) {

    }

    public void selecionaPapel(View view) {

    }

    public void selecionaTesoura(View view) {

    }

    public void opcaoSelecionada(String opcaoSelecionada) {

    }
}