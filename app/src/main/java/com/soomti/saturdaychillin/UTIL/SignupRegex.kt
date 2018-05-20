package com.soomti.saturdaychillin.UTIL

import android.util.Log
import java.util.regex.Pattern

val REGEX_ID = "^[a-zA-Z0-9]{5,}$"
val REGEX_PW = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$"
val REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,3}$"

fun validateRegex(regex: String, str: String) : Boolean {
    val matcher = Pattern.compile(regex).matcher(str)
    return matcher.find()
}
