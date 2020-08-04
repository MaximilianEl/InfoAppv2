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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
        getNewsData()
    }

    fun getNewsData() {

        val url = "https://www.hs-osnabrueck.de/wir/wir-stellen-uns-vor/nachrichten/"
        val doc = Jsoup.connect(url).get()

        val div_newsitem = doc.getElementsByClass("news-list-item").html()
        println("Du Hure" + div_newsitem)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
    }


}