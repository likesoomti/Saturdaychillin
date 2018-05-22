package com.soomti.saturdaychillin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.soomti.saturdaychillin.Helper.checkPassword
import com.soomti.saturdaychillin.Helper.saveSharedPref
import kotlinx.android.synthetic.main.activity_main.*
import com.soomti.saturdaychillin.Models.isUser
import com.soomti.saturdaychillin.R
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginbutton.setOnClickListener({
            val loginUser = isUser(user_id.text.toString())
            if (loginUser != null){
                if(!checkPassword(loginUser.password, user_password.text.toString())){
                    saveSharedPref(loginUser.id, loginUser.email, this)
                    startActivity<IndexActivity>("id" to loginUser.id, "email" to loginUser.email)
                    finish()
                }
                else toast("비밀번호가 일치하지 않습니다.")
            }
            else toast("아이디가 존재하지 않습니다.")
        })

        signup_link.setOnClickListener({
            startActivity<SignUpActivity>()
            finish()
        })
    }
}
