package com.leachchen.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val price = "${'$'}9.99"
        Log.e("mytest",price)

        var a  = "aa"

        Log.e("mytest",a)
    }

}
