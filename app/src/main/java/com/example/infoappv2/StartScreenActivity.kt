package com.example.infoappv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class StartScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startscreen)
        openInfoActivity()
    }

    private fun openInfoActivity() {
        Timer().schedule(3000){
             Intent(applicationContext, InfoActivity::class.java).also {
                 startActivity(it)
             }
             }
    }
}