package com.soomti.saturdaychillin
import android.content.Context
import com.soomti.saturdaychillin.MODEL.User
import java.util.regex.Pattern

val REGEX_ID = "^[a-zA-Z0-9]{5,}$"
val REGEX_PW = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$"
val REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,3}$"

fun validateRegex(regex: String, str: String) : Boolean {
    val matcher = Pattern.compile(regex).matcher(str)
    return matcher.find()
}
fun saveSharedPref(id:String?,email:String?,context:Context){
    val sharedPreference = context.getSharedPreferences("user", 0)
    val editor = sharedPreference.edit()
    editor.putString("id", id)
    editor.putString("email",email)
    editor.commit()
}
fun checkPassword(pwd1:String?,pwd2:String) :Boolean{
    if(pwd1== pwd2) return true
    return false
}
