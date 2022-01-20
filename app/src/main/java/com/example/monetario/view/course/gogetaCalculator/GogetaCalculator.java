package com.example.monetario.view.course.gogetaCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.monetario.R;

public class GogetaCalculator extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textValorGorjeta;
    private TextView textValorTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gogeta_calculator);

        editValor = findViewById(R.id.editValor);
        textValorGorjeta = findViewById(R.id.textValorGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textValorTotal = findViewById(R.id.textValorTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText( porcentagem + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}