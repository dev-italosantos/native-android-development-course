package com.example.monetario.course.phrase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.monetario.R;

import java.util.Random;

public class PhraseDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase_day);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        gerarFrase();
    }

    private void gerarFrase() {
        TextView text = findViewById(R.id.fraseViewDay);
        Button btnNvFr = findViewById(R.id.btnNvFr);

        btnNvFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] frases = {
                        "Tu te tornas eternamente responsável por aquilo que cativas.",
                        "O essencial é invisível aos olhos.",
                        "É loucura odiar todas as rosas porque uma te espetou.",
                        "Era uma raposa igual a cem mil outras. Mas eu fiz dela uma amiga. Ela é agora única no mundo.",
                        "Se tu vens às quatro da tarde, desde as três começarei a ser feliz."
                };

                int numero = new Random().nextInt(5);

                text.setText(frases[numero]);
            }
        });

    }
}