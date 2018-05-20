package com.soomti.saturdaychillin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.soomti.saturdaychillin.UTIL.REGEX_ID
import com.soomti.saturdaychillin.UTIL.REGEX_PW
import com.soomti.saturdaychillin.UTIL.validateRegex
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.soomti.saturdaychillin.MODEL.User
import com.soomti.saturdaychillin.UTIL.REGEX_EMAIL
import io.realm.Realm


class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 회원가입시
        signupbutton.setOnClickListener(View.OnClickListener {

            if(!(validateRegex(REGEX_ID, user_id.text.toString()))){
                Toast.makeText(applicationContext,"아이디를 다시 입력해주세요.",Toast.LENGTH_LONG).show()
            }

            else if(!validateRegex(REGEX_PW, user_password.text.toString())) {
                Toast.makeText(applicationContext,"비밀번호를 다시 입력해주세요.",Toast.LENGTH_LONG).show()
            }

            else if(!validateRegex(REGEX_PW, user_password2.text.toString())) {
                Toast.makeText(applicationContext,"비밀번호2를 다시 입력해주세요.",Toast.LENGTH_LONG).show()
            }

            else if(!validateRegex(REGEX_EMAIL, user_email.text.toString())) {
                Toast.makeText(applicationContext, "이메일을 다시 입력해주세요.", Toast.LENGTH_LONG).show()
            }
            else {
                val realm = Realm.getDefaultInstance()

                // 데이터 베이스 추가
                realm.executeTransaction { r ->
                    val user = r.createObject(User::class.java, user_id.text.toString())
                    user.password = user_password.text.toString()
                    user.email = user_email.text.toString()
                }

                Toast.makeText(applicationContext,"회원가입이 완료 되었습니다.",Toast.LENGTH_LONG).show()
                intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        })
    }
}
