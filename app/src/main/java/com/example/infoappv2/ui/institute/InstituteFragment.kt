package com.example.infoappv2.ui.institute

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_institute.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class InstituteFragment : Fragment() {

    private lateinit var instituteViewModel: InstituteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        instituteViewModel =
            ViewModelProviders.of(this).get(InstituteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_institute, container, false)
        return root
    }

    @SuppressLint("ResourceType")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getInsData()
    }

    fun getInsData() {
        thread {
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/"
            val doc = Jsoup.connect(url).get()
            val div_instext = doc.getElementsByClass("col-md-24")

            //For-Schleife eventuell?
            //val div_psize = div_instext.select("p").size
            //println(div_psize)

            val div_pOne = div_instext.select("p")[0].text()
            //println(div_pOne)
            val div_pTwo = div_instext.select("p")[1].text()
            //println(div_pTwo)
            val div_pThree = div_instext.select("p")[2].text()
            //println(div_pThree)
            val div_pFour = div_instext.select("p")[3].text()
            //println(div_pFour)

            val div_Text = div_pOne + div_pTwo + div_pThree + div_pFour
            println(div_Text)

            this.run {
                insText.text = div_Text
            }
        }
    }
}