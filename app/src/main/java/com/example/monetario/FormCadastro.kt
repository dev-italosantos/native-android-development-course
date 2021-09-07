package com.example.monetario

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()
    }

    fun onClickBtnCadastra(@Suppress("UNUSED_PARAMETER")view: View?) {

        val editName: EditText = findViewById(R.id.editName)
        val editEmail: EditText = findViewById(R.id.editEmail)
        val editPassword: EditText = findViewById(R.id.editSenha)

        val name = editName.text.toString()
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            val snack = Snackbar.make(view!!, "This is a simple Snackbar", Snackbar.LENGTH_SHORT)

            snack.view.setBackgroundColor(Color.WHITE)
            snack.setTextColor(Color.BLACK)
            snack.show()
        } else {
            cadastroUser(view)
        }
    }

    private fun cadastroUser(view: View?) {

        val editEmail: EditText = findViewById(R.id.editEmail)
        val editPassword: EditText = findViewById(R.id.editSenha)

        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val snack = Snackbar.make(view!!, "Registration performed successfully", Snackbar.LENGTH_SHORT)

                snack.view.setBackgroundColor(Color.WHITE)
                snack.setTextColor(Color.BLACK)
                snack.show()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }
    
}