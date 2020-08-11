package com.example.infoappv2.ui.institute


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import com.ms.square.android.expandabletextview.ExpandableTextView
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

    }

    fun getInsData() {
        thread {
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468"
            val doc = Jsoup.connect(url).get()

            val text = doc.getElementsByTag("p")
            println(text)

            val firsttext = text[0].text()
            val secondtext = text[1].text()
            val thirdtext = text[2].text()
            val fourthtext = text[3].text()

            val fulltext = firsttext + secondtext + thirdtext + fourthtext

            activity?.runOnUiThread() {
                insText.text = fulltext
            }
        }
    }
}