package com.soomti.saturdaychillin.Activities
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*
import android.text.Editable
import android.text.TextWatcher
import com.soomti.saturdaychillin.Helper.REGEX_EMAIL
import com.soomti.saturdaychillin.Helper.REGEX_ID
import com.soomti.saturdaychillin.Helper.REGEX_PW
import com.soomti.saturdaychillin.Helper.validateRegex
import com.soomti.saturdaychillin.Models.createUser
import com.soomti.saturdaychillin.R
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class SignUpActivity : AppCompatActivity() {
    var idFlag = false
    var pwd1Flag = false
    var pwd2Flag = false
    var emailFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        user_id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            // 바뀐 후
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_ID, user_id.text.toString())) {
                    error_msg.text = "아이디는 최소 5자로 입력해 주세요."
                    idFlag = false
                }else{
                    error_msg.text = ""
                    idFlag = true
                }
                setChangedButton(idFlag,pwd1Flag,pwd2Flag,emailFlag)
            }
        })

        user_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_PW, user_password.text.toString())) {
                    error_msg.text = "비밀번호는 최소 8자,특수문자 대문자 소문자를 가지고 있어야 합니다."
                    pwd1Flag = false
                }
                else{
                    error_msg.text = ""
                    pwd1Flag = true
                }
                setChangedButton(idFlag,pwd1Flag,pwd2Flag,emailFlag)
            }
        })

        user_password2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!validateRegex(REGEX_PW, user_password2.text.toString())) {
                    error_msg.text = "비밀번호확인은 최소 8자,특수문자 대문자 소문자를 가지고 있어야 합니다."
                    pwd1Flag =  false
                }
                else if(!(user_password.text.toString() == user_password2.text.toString())){
                    error_msg.text = "비밀번호가 일치하지 않습니다."
                }
                else{
                    error_msg.text = ""
                    pwd2Flag = true
                }
                setChangedButton(idFlag,pwd1Flag,pwd2Flag,emailFlag)
            }
        })

        user_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if(!validateRegex(REGEX_EMAIL, user_email.text.toString())) {
                    error_msg.text = "이메일 형식을 다시 확인해 주세요"
                    emailFlag = false
                }else{
                    error_msg.text = ""
                    emailFlag = true
                }
                setChangedButton(idFlag,pwd1Flag,pwd2Flag,emailFlag)
            }
        })
        // 회원가입시 데이베이스 저장
        signupbutton.setOnClickListener({
            createUser(user_id.text.toString(), user_password.text.toString(), user_email.text.toString())
            toast("회원가입이 완료 되었습니다")
            startActivity<MainActivity>()
            finish()
        })
    }

    fun setChangedButton(id: Boolean,pwd: Boolean,pwd2: Boolean,email: Boolean){
        signupbutton.isEnabled = id && pwd && pwd2 && email
    }
}
