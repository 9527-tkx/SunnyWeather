package com.sunnyweather.android

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunnyweather.android.ui.login.ui.ui.login.LoginActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    companion object {
        fun startLogin(context: Context) {
            context.startActivity(Intent(context, LoginActivity().javaClass))
        }

    }

}
