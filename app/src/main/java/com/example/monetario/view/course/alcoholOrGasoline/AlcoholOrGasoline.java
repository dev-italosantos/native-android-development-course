package com.example.monetario.view.course.alcoholOrGasoline;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.monetario.R;
import com.google.android.material.textfield.TextInputEditText;

public class AlcoholOrGasoline extends AppCompatActivity {
    private TextInputEditText editPriceAlcohol, editPriceGasoline;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_or_gasoline);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        editPriceAlcohol = findViewById(R.id.editPriceAlcohol);
        editPriceGasoline = findViewById(R.id.editPriceGasoline);
        textResult = findViewById(R.id.textResult);
    }

    public void calculatePrice(View view) {
        String priceAlcohol = editPriceAlcohol.getText().toString();
        String priceGasoline = editPriceGasoline.getText().toString();

        Boolean camposValidados = validarCampos(priceAlcohol, priceGasoline);

        if (camposValidados ) {
            Double valueAlcohol = Double.parseDouble(priceAlcohol);
            Double valueGasoline = Double.parseDouble(priceGasoline);

            Double result = valueAlcohol / valueGasoline;

            if ( result >= 0.7 ) {
                textResult.setText("Melhor utilizar Gasolina");
            } else {
                textResult.setText("Melhor utilizar Alcool");
            }

        } else {
            textResult.setText("Preencha todos os campos promeiro!");
        }
    }

    public Boolean validarCampos(String pAlcohol, String pGasoline) {

        Boolean camposValidados = true;

        if (pAlcohol == null || pAlcohol.equals("")) {
            camposValidados = false;
        } else if (pGasoline == null || pGasoline.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}