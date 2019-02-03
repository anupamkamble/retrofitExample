package com.example.retrofitxml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.retrofitxml.RetrofitUtils.RetrofitControllerClass

class MainActivity : AppCompatActivity() {


    lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)

        btn.setOnClickListener{
            var controllerClass: RetrofitControllerClass = RetrofitControllerClass()
            controllerClass.loadUserDataPerPage()

        }
    }
}
