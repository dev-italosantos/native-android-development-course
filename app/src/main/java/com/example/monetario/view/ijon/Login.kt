package com.example.monetario.view.ijon

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.monetario.view.iuse.Home
import com.example.monetario.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        login()
    }

    fun onClickCadastro(@Suppress("UNUSED_PARAMETER") view: View?) {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    private fun login() {
        val btnEntrar: AppCompatButton = findViewById(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val editEmail: TextInputEditText = findViewById(R.id.editEmail)
            val editPassword: TextInputEditText = findViewById(R.id.editSenha)

            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                val snack =
                    Snackbar.make(it, "This is a simple Snackbar", Snackbar.LENGTH_SHORT)

                snack.view.setBackgroundColor(Color.WHITE)
                snack.setTextColor(Color.BLACK)
                snack.show()
            } else {
                loginUser(it)
            }
        }
    }

    private fun loginUser(view: View) {
        val editEmail: TextInputEditText = findViewById(R.id.editEmail)
        val editPassword: TextInputEditText = findViewById(R.id.editSenha)

        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Handler(Looper.getMainLooper()).postDelayed({
                    home()
                }, 3000)
            } else {
                val erroAuth: String = try {
                    throw  task.exception!!
                } catch (e: FirebaseAuthWeakPasswordException) {
                    "Enter a password with at least 6 characters"
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    "E-mail invalid"
                } catch (e: FirebaseNetworkException) {
                    "Inspect connectivity state"
                } catch (e: Exception) {
                    "Error registering user"
                }

                val snack = Snackbar.make(view, erroAuth, Snackbar.LENGTH_SHORT)

                snack.view.setBackgroundColor(Color.WHITE)
                snack.setTextColor(Color.BLACK)
                snack.show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val user = auth.currentUser
        if (user != null) {
            home()
        }
    }

    private fun home() {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
        finish()
    }
}