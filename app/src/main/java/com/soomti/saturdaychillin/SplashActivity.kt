package com.soomti.saturdaychillin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import android.content.Context.MODE_MULTI_PROCESS
import android.util.Log
import com.soomti.saturdaychillin.MODEL.User
import java.lang.reflect.Member


class SplashActivity : AppCompatActivity() {
    val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val pref = getSharedPreferences("user",0)
        val id = pref.getString("id","")
        val email = pref.getString("email","")

        if (id == null) {
            intent = Intent(applicationContext,MainActivity::class.java)
        }
        else {
            intent = Intent(applicationContext,IndexActivity::class.java)
            intent.putExtra("id",id)
            intent.putExtra("email",email)
        }
        startActivity(intent)

    }
}
