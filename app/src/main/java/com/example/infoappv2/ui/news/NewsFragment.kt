package com.example.infoappv2.ui.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R
import org.jsoup.Jsoup

@Suppress("UNREACHABLE_CODE")
class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel

        getNewsData()
    }

    fun getSomeData() {
        val url = "https://firebase.google.com/"
        val doc = Jsoup.connect(url).get()

        val title = doc.title()
        val links = doc.select("a[href]")

        println(title)

        links.forEach {
                link -> println(link.attr("href"))
        }
    }

    fun getNewsData() {

        val url = "https://www.hs-osnabrueck.de/wir/wir-stellen-uns-vor/nachrichten/"
        val doc = Jsoup.connect(url).get()

        val div_newsitem = doc.getElementById("c18977").text()
        println(div_newsitem)


    }
}