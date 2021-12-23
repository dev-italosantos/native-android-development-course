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
import androidx.fragment.app.Fragment
import com.example.monetario.R
import com.example.monetario.fragments.AccountFragment
import com.example.monetario.fragments.FavoriteFragment
import com.example.monetario.fragments.HomeFragment
import com.example.monetario.fragments.SettingsFragment
import com.example.monetario.view.coronation.constraint.ConstraintLayout
import com.example.monetario.view.course.jokenpo.JokenpoActivity
import com.example.monetario.view.ijon.Login
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        clickFragment()

        layoutConstraint()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.commit()
    }

    private fun clickFragment() {
        val btnNavigationView: BottomNavigationView = findViewById(R.id.btnNavigationView)

        val settingsFragment = SettingsFragment()

        val homeFragment = HomeFragment()

        val favoriteFragment = FavoriteFragment()

        val accountFragment = AccountFragment()

        btnNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> replaceFragment(homeFragment)
                R.id.menuFavorite -> replaceFragment(favoriteFragment)
                R.id.menuAccount -> replaceFragment(accountFragment)
                R.id.menuSettings -> replaceFragment(settingsFragment)
            }
            true
        }
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

    private fun layoutConstraint() {
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }
    }
}