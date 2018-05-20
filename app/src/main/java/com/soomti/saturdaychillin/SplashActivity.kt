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
        Log.d("id", "test")
        Realm.getDefaultInstance().use { realm ->
            realm.where(User::class.java).findAll().forEach {

                Log.d("id", "${it.id}")
                Log.d("name", "${it.password}")
                Log.d("age", "${it.email}")
            }
        }

        val pref = getSharedPreferences("user",Context.MODE_MULTI_PROCESS or Context.MODE_WORLD_READABLE)

        var id = pref.getString("id","")
        val email = pref.getString("email","")

        if (id == null) {
            Log.d(TAG,"to Main Activity")
            intent = Intent(applicationContext,MainActivity::class.java)
        }else {
            Log.d(TAG,"to Index Activity")
            intent = Intent(applicationContext,IndexActivity::class.java)
            intent.putExtra("id",id)
            intent.putExtra("email",email)
        }
        startActivity(intent)

    }
}
