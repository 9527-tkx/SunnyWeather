package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent

class SunnyWeatherApplication : Application() {


    companion object {

        const val TOKEN = "mBZV3XDfkouHPmzR" // 填入你申请到的令牌值

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        //封装跳转方法
        fun startIntent(context: Context, clazz: Class<Any>, block: Intent.() -> Unit) {
            var intent = Intent(context, clazz)
            intent.block()
            context.startActivity(intent)



        }

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext


    }

}