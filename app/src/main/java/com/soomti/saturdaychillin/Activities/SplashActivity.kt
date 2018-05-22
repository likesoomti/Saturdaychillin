package com.soomti.saturdaychillin.Activities
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.soomti.saturdaychillin.R
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val pref = getSharedPreferences("user",0)

        if (pref == null)
            startActivity<MainActivity>()
        else {
            val id = pref.getString("id","")
            val email = pref.getString("email","")
            startActivity<IndexActivity>("id" to id, "email" to email)
        }
    }
}
