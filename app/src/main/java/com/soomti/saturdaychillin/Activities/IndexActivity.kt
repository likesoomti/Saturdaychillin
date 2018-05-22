package com.soomti.saturdaychillin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.soomti.saturdaychillin.R
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val intent = intent
        id.text = intent.getStringExtra("id")
        email.text = intent.getStringExtra("email")
    }
}
