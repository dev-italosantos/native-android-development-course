package com.example.monetario.view.iuse

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.monetario.R
import com.example.monetario.view.course.jokenpo.Jokenpo
import com.example.monetario.view.course.phrase.PhraseDay
import com.example.monetario.view.ijon.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Home : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var db: FirebaseFirestore

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        db = FirebaseFirestore.getInstance()

        checkUser()

        proxLayout()

        antLayout()
    }

    fun logout(@Suppress("UNUSED_PARAMETER") view: View?) {
        auth.signOut()
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        val docRef = db.collection("users").document("O1EY32OefNC6udbeXp6H")

        docRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot != null) {
                val etNome: String = documentSnapshot.data?.get("name").toString()
                Log.d(TAG, "dyww Name $etNome")
                configHome(etNome)
            } else {
                Log.d(TAG, "No such document")
            }
        }.addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }
    }

    @SuppressLint("WrongViewCast")
    fun configHome(etNome: String) {
        val textName: TextView = findViewById(R.id.textUsername)
        textName.text = etNome
    }

    private fun checkUser() {
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            val email = firebaseUser.email
            Log.d(TAG, "dyww Email $email")
        } else {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun proxLayout() {
        val btnProx = findViewById<Button>(R.id.btnProx)
        btnProx.setOnClickListener {
            val intent = Intent(this, Jokenpo::class.java)
            startActivity(intent)
        }
    }

    private fun antLayout() {
        val btnAnt = findViewById<Button>(R.id.btnAnt)
        btnAnt.setOnClickListener {
            val intent = Intent(this, PhraseDay::class.java)
            startActivity(intent)
        }
    }
}