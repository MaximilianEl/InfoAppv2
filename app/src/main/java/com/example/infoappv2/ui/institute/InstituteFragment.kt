package com.example.infoappv2.ui.institute

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R
import org.jsoup.Jsoup

class InstituteFragment : Fragment() {

    companion object {
        fun newInstance() = InstituteFragment()
    }

    private lateinit var viewModel: InstituteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_institute, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InstituteViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun getInsData() {

        val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/institute/institut-fuer-management-und-technik/#c8477468"
        val doc = Jsoup.connect(url).get()

        val div_ins = doc.getElementsByClass("col-md-24").size

        println("Text? " + div_ins)
    }

}