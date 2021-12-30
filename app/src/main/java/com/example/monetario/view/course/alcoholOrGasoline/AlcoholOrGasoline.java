package com.example.monetario.view.course.alcoholOrGasoline;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.monetario.R;
import com.google.android.material.textfield.TextInputEditText;

public class AlcoholOrGasoline extends AppCompatActivity {
    private TextInputEditText editPriceAlcohol, editPriceGasoline;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_or_gasoline);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        editPriceAlcohol = findViewById(R.id.editPriceAlcohol);
        editPriceGasoline = findViewById(R.id.editPriceGasoline);
    }
}