package com.example.infoappv2.ui.institute


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_institute.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

@Suppress("UNREACHABLE_CODE")
class InstituteFragment : Fragment() {

    companion object {
        fun newInstance() = InstituteFragment()
    }

    private lateinit var viewModel: InstituteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_institute, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InstituteViewModel::class.java)
        getInsData()

        ins_header2.setOnClickListener {
            if (ins_secondtext.length() <= 0 ) {
                ins_secondtext.visibility = VISIBLE
                fillTextTwo()
            } else {
                ins_secondtext.text = ""
                ins_secondtext.visibility = GONE
            }
        }

        ins_header3.setOnClickListener {
            if (ins_thirdtext.length() <= 0 ) {
                ins_thirdtext.visibility = VISIBLE
                fillTextThree()
            } else {
                ins_thirdtext.text = ""
                ins_thirdtext.visibility = GONE
            }
        }

    }

    fun getInsData() {
        thread {
            val url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468"
            val doc = Jsoup.connect(url).get()

            val text = doc.getElementsByTag("p")
            println(text)

            val header = doc.select("a[data-toggle]")
            println(header)

            val firsttext = text[0].text()
            val secondtext = text[1].text()
            val thirdtext = text[2].text()
            val fourthtext = text[3].text()
            val fulltext = firsttext + secondtext + thirdtext + fourthtext

            activity?.runOnUiThread() {
                insText.text = fulltext
                ins_header1.text = header[0].text()
                ins_header2.text = header[1].text()
                ins_header3.text = header[2].text()
            }
        }
    }

    fun fillTextTwo() {
        thread {
            val url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468"
            val doc = Jsoup.connect(url).get()

            val p = doc.getElementsByTag("p")

            val text1 = p[4].text()
            val text2 = p[5].text()
            val text3 = p[6].text()

            val text = text1 + text2 + text3

            activity?.runOnUiThread() {
                ins_secondtext.text = text
            }
        }
    }

    fun fillTextThree() {
        thread {
            val url =
                "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468"
            val doc = Jsoup.connect(url).get()

            val p = doc.getElementsByTag("p")

            val text1 = p[8].text()
            val text2 = p[9].text()
            val text3 = p[10].text()
            println(text3)

            val text = text1 + " " + text2 + " " + text3

            activity?.runOnUiThread() {
                ins_thirdtext.text = text
            }
        }
    }
}