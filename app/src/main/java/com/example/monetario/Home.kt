package com.example.monetario

import android.Manifest
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.monetario.fragments.AccountFragment
import com.example.monetario.fragments.FavoriteFragment
import com.example.monetario.fragments.HomeFragment
import com.example.monetario.fragments.SettingsFragment
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

        //enviarSms()

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.SEND_SMS),
                1)

        } else {
            receiveMsg()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            receiveMsg()
        }

    }

    private fun receiveMsg() {
        val br = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    for (sms: SmsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        Toast.makeText(applicationContext, sms.displayMessageBody, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        registerReceiver(br, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
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

        btnNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> replaceFragment(homeFragment)
                R.id.menuFavorite -> replaceFragment(favoriteFragment)
                R.id.menuAccount -> replaceFragment(accountFragment)
                R.id.menuSettings -> replaceFragment(settingsFragment)
            }
            true
        }
    }

//    private fun enviarSms() {
//        val btnEnviar: AppCompatButton = findViewById(R.id.btnEnviar)
//
//        btnEnviar.setOnClickListener {
//            val smsManager: SmsManager = SmsManager.getDefault()
//            smsManager.sendTextMessage("085 8548-7814", null, "Oi, sksk test Android", null, null)
//            println("Você é foda que orgulho ksks")
//        }
//    }

    fun onClickLogout(@Suppress("UNUSED_PARAMETER") view: View?) {
        auth.signOut()
        val intent = Intent(this, FormLogin::class.java)
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
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()
        }
    }
}