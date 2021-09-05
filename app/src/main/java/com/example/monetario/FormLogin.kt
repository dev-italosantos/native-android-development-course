package com.example.monetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FormLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        getSupportActionBar()?.hide()

    }
    fun onClickCadastro(view: View?) {
        val intent = Intent(this, FormCadastro::class.java)
        startActivity(intent)
    }
}