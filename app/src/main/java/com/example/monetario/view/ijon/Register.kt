package com.example.monetario.view.ijon

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.monetario.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Register : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
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
                saveDataUser()

                val snack = Snackbar.make(view!!, "Registration performed successfully", Snackbar.LENGTH_SHORT)

                snack.view.setBackgroundColor(Color.WHITE)
                snack.setTextColor(Color.BLACK)
                snack.show()
            } else {
                val erroAuth: String = try {
                    throw  task.exception!!
                } catch (e: FirebaseAuthWeakPasswordException) {
                    "Enter a password with at least 6 characters"
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    "E-mail invalid"
                } catch (e: FirebaseAuthUserCollisionException) {
                    "This account already exists"
                } catch (e: Exception) {
                    "Error registering user"
                }

                val snack = Snackbar.make(view!!, erroAuth, Snackbar.LENGTH_SHORT)

                snack.view.setBackgroundColor(Color.WHITE)
                snack.setTextColor(Color.BLACK)
                snack.show()
            }
        }
    }
    private fun saveDataUser() {
        val editName: EditText = findViewById(R.id.editName)
        val name = editName.text.toString()

        val db = Firebase.firestore

        val user = HashMap<String, Any>()
        user["name"] = name

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
}