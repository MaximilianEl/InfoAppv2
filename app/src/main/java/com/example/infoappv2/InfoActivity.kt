package com.example.infoappv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
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
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        buttonNext.setOnClickListener {
            if (introSliderViewPager.currentItem + 1 < introSlideAdapter.itemCount) {
                introSliderViewPager.currentItem += 1
            }  else {
                Intent(applicationContext, MenuActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        textSkipIntro.setOnClickListener {
            Intent(applicationContext, MenuActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.indicator_inactive
                )
            )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}