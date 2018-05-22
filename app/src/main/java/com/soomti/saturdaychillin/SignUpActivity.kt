package com.soomti.saturdaychillin
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.soomti.saturdaychillin.MODEL.User
import io.realm.Realm
import android.text.Editable
import android.text.TextWatcher
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class SignUpActivity : AppCompatActivity() {
    var id_flag = false
    var pwd1_flag = false
    var pwd2_flag = false
    var email_flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        user_id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            // 바뀐 후
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_ID, user_id.text.toString())) {
                    id_error_msg.text = "아이디는 최소 5자로 입력해 주세요."
                    id_flag = false
                }else{
                    id_error_msg.text = ""
                    id_flag = true
                }
                setChangedButton(id_flag,pwd1_flag,pwd2_flag,email_flag)
            }
        })

        user_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_PW, user_password.text.toString())) {
                    pwd_error_msg.text = "비밀번호는 최소 8자,특수문자 대문자 소문자를 가지고 있어야 합니다."
                    pwd1_flag = false
                }
                else{
                    pwd_error_msg.text = ""
                    pwd1_flag = true
                }
                setChangedButton(id_flag,pwd1_flag,pwd2_flag,email_flag)
            }
        })

        user_password2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!validateRegex(REGEX_PW, user_password2.text.toString())) {
                    pwd2_error_msg.text = "비밀번호확인은 최소 8자,특수문자 대문자 소문자를 가지고 있어야 합니다."
                    pwd2_flag =  false
                }
                else if(!(user_password.text.toString() == user_password2.text.toString())){
                    pwd2_error_msg.text = "비밀번호가 일치하지 않습니다."
                }
                else{
                    pwd2_error_msg.text = ""
                    pwd2_flag = true
                }
                setChangedButton(id_flag,pwd1_flag,pwd2_flag,email_flag)
            }
        })

        user_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_EMAIL, user_email.text.toString())) {
                    email_error_msg.text = "이메일 형식을 다시 확인해 주세요"
                    email_flag = false
                }else{
                    email_error_msg.text = ""
                    email_flag = true
                }
                setChangedButton(id_flag,pwd1_flag,pwd2_flag,email_flag)
            }
        })

        // 회원가입시 데이베이스 저장
        signupbutton.setOnClickListener({
            val realm = Realm.getDefaultInstance()

            // 데이터 베이스 추가
            realm.executeTransaction { r ->
                val user = r.createObject(User::class.java, user_id.text.toString())
                user.password = user_password.text.toString()
                user.email = user_email.text.toString()
            }
            toast("회원가입이 완료 되었습니다")
            startActivity<MainActivity>()
            finish()
        })
    }

    fun setChangedButton(id: Boolean,pwd: Boolean,pwd2: Boolean,email: Boolean){
        signupbutton.isEnabled = id && pwd && pwd2 && email
    }
}
