package com.example.infoappv2.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_ehelp.*
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import kotlin.concurrent.thread

@Suppress("UNREACHABLE_CODE")
class EhelpFragment : Fragment() {

    companion object {
        fun newInstance() = EhelpFragment()
    }

    private lateinit var viewModel: EhelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ehelp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EhelpViewModel::class.java)

        getSomeData()
    }

    fun getSomeData() {
        thread {
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/erstsemesterinformationen/"
            val doc = Jsoup.connect(url).get()

            val links: Elements = doc.select("a[href]")

            val title = doc.getElementsByTag("h2")

            val text = doc.getElementsByTag("p")

            val strongtext = doc.select("strong")

            activity?.runOnUiThread(){
                ehelp_mainheader.text = title[1].text()
                ehelp_secondheader.text = title[2].text()
                ehelp_headertpo.text = strongtext[17].text()
                ehelp_headertptw.text = strongtext[18].text()
                ehelp_headertpth.text = strongtext[19].text()
                ehelp_headertpfou.text = strongtext[20].text()
                ehelp_headertpfith.text = strongtext[21].text()

                ehelp_firsttext.text = text[0].text()
                ehelp_secondtext.text = text[1].text()
                ehelp_thirdtext.text = text[3].text()
                ehelp_fourthtext.text = text[5].text()
                ehelp_fifthtext.text = text[7].text()
                ehelp_sixthtext.text = text[9].text()
                ehelp_seventhtext.text = text[12].text()
            }
        }
    }
}