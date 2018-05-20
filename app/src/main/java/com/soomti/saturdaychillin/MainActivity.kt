package com.soomti.saturdaychillin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.soomti.saturdaychillin.MODEL.User
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginbutton.setOnClickListener(View.OnClickListener {
            val realm = Realm.getDefaultInstance()

            val select_user = realm.where(User::class.java)
                    .equalTo("id", user_id.text.toString())
                    .findFirst()

            if (select_user == null) {
                Toast.makeText(this,"아이디가 존재하지 않습니다.",Toast.LENGTH_LONG).show()
            }
            else if(!(select_user.password == user_password.text.toString())){
                Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
            }else {

                val sharedPreference = this.getSharedPreferences("user", Context.MODE_MULTI_PROCESS or Context.MODE_WORLD_READABLE)
                val editor = sharedPreference.edit()
                editor.putString("id", select_user.id)
                editor.putString("email", select_user.email)
                editor.commit()

                intent = Intent(this,IndexActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        // 회원가입 페이지 이동
        signup_link.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}
