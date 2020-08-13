package com.example.infoappv2.ui.courses

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_courses.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class CoursesFragment : Fragment() {

    companion object {
        fun newInstance() = CoursesFragment()
    }
    private lateinit var viewModel: CoursesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoursesViewModel::class.java)
        getInsData()

        cour_header1.setOnClickListener {
            if (cour_firstext.visibility == View.GONE ) {
                cour_header1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_firstext.visibility = View.VISIBLE

//                cour_firstext.setOnClickListener{
//                    val openURL = Intent(Intent.ACTION_VIEW)
//                    openURL.data = Uri.parse("https://www.hs-osnabrueck.de/studium/studienangebot/bachelor/allgemeiner-maschinenbau-bsc-standort-lingen-ems/")
//                    startActivity(openURL)}

                val styledString = SpannableString(cour_firstext.text)

                val clickableSpan1A = object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://www.hs-osnabrueck.de/studium/studienangebot/bachelor/allgemeiner-maschinenbau-bsc-standort-lingen-ems/")
                        startActivity(openURL)
                    }}

                styledString.setSpan(clickableSpan1A, 0, 16, 0)

//                textView.setMovementMethod(LinkMovementMethod.getInstance())

            } else {
                cour_header1.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_firstext.visibility = View.GONE
            }
        }

        cour_header2.setOnClickListener {
            if (cour_secondtext.visibility == View.GONE ) {
                cour_header2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_secondtext.visibility = View.VISIBLE
            } else {
                cour_header2.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_secondtext.visibility = View.GONE
            }
        }

        cour_header3.setOnClickListener {
            if (cour_thirdtext.visibility == View.GONE ) {
                cour_header3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_thirdtext.visibility = View.VISIBLE
            } else {
                cour_header3.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_thirdtext.visibility = View.GONE
            }
        }

        cour_header4.setOnClickListener {
            if (cour_fourthtext.visibility == View.GONE ) {
                cour_header4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_fourthtext.visibility = View.VISIBLE
            } else {
                cour_header4.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_fourthtext.visibility = View.GONE
            }
        }

        cour_header5.setOnClickListener {
            if (cour_fifthtext.visibility == View.GONE ) {
                cour_header5.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_fifthtext.visibility = View.VISIBLE
            } else {
                cour_header5.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_fifthtext.visibility = View.GONE
            }
        }

        cour_header6.setOnClickListener {
            if (cour_sixthtext.visibility == View.GONE ) {
                cour_header6.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_sixthtext.visibility = View.VISIBLE
            } else {
                cour_header6.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_sixthtext.visibility = View.GONE
            }
        }

        cour_header7.setOnClickListener {
            if (cour_seventhtext.visibility == View.GONE ) {
                cour_header7.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0)
                cour_seventhtext.visibility = View.VISIBLE
            } else {
                cour_header7.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0)
                cour_seventhtext.visibility = View.GONE
            }
        }

    }

    fun getInsData() {
        thread {
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/studiengaenge/"
            val doc = Jsoup.connect(url).get()

            val text = doc.select("h2[class='hsos-title-separator']")

            val header = doc.select("span[class='az-item-title']")

            activity?.runOnUiThread {
                courheader.text = text.text()
                cour_header1.text = header[0].text()
                cour_header2.text = header[1].text()
                cour_header3.text = header[2].text()
                cour_header4.text = header[3].text()
                cour_header5.text = header[4].text()
                cour_header6.text = header[5].text()
                cour_header7.text = header[6].text()
            }
        }
    }
}