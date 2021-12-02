package com.example.monetario.course.jokenpo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monetario.R;

import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    public void selecionaPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionaPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionaTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imageJokenpo = findViewById(R.id.imageJokenpo);
        TextView textResult = findViewById(R.id.textResult);

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imageJokenpo.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageJokenpo.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageJokenpo.setImageResource(R.drawable.tesoura);
                break;
        }
        if (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel") ||
                opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra") ||
                opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura")) {
            textResult.setText("Você perdeu :/");
        } else if (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel") ||
                opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra") ||
                opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura")) {
            textResult.setText("Você ganhou :)");
        } else {
            textResult.setText("Empatamos");
        }

    }
}