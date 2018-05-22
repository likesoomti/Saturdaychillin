package com.soomti.saturdaychillin
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val pref = getSharedPreferences("user",0)
        val id = pref.getString("id","")
        val email = pref.getString("email","")

        if (id == null || id == "") {
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
