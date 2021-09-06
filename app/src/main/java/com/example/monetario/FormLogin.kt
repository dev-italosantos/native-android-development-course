package com.example.monetario

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class FormLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        supportActionBar?.hide()

    }
    fun onClickCadastro(@Suppress("UNUSED_PARAMETER")view: View?) {
        val intent = Intent(this, FormCadastro::class.java)
        startActivity(intent)
    }
}