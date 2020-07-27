package com.example.infoappv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    private val introSlideAdapter = IntroSlideAdapter(
        listOf(
            IntroSlide(
                "Willkommen am Campus Lingen!",
            "Die InfoApp der Hochschule Osnabrück bietet euch alle Informationen die Ihr zum Studienstart am Campus Lingen benötigt." +
                       "Außerdem bieten wir euch coole Spiele die Ihr spielen könnt während Ihr in der auf dem Campus wartet.",
                R.drawable.hs_os
            ),
            IntroSlide(
              "Alles was Du brauchst!",
                "Hol dir Kontakte, Informationen, News und vieles mehr!",
                R.drawable.firstimage
            ),
            IntroSlide(
                "Schreibe mit Dozenten!",
                "Um mit Dozenten schreiben zu könne muss eine Mobilfunknummer hinterlegt sein.",
                R.drawable.ic_baseline_chat_24_white
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        introSliderViewPager.adapter = introSlideAdapter
    }

}