package com.example.monetario.loginSingup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.monetario.R
import com.example.monetario.view.prizeDraw.PrizeDrawActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailer_login)

        supportActionBar?.hide()
    }

    fun onClickBtnEnter(view: View?) {
        val intent = Intent(this, PrizeDrawActivity::class.java)
        startActivity(intent)
    }
}