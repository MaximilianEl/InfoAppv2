package com.example.infoappv2.ui.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import com.example.infoappv2.ui.courses.CoursesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_person.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class PersonFragment : Fragment() {

    private lateinit var personViewModel: PersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personViewModel =
            ViewModelProviders.of(this).get(PersonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_person, container, false)

        retrieveWebInfo()
        personViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    private fun retrieveWebInfo() {
        thread {
            val doc = Jsoup.connect("https://www.tutorialspoint.com/android/index.htm").get()

            val imageElements = doc.getElementsByClass("img-responsive")
            val textElements = doc.getElementsByTag("h1")

            val  imageUrl = imageElements[0].absUrl("src")

            this.run{
                textTitle1.text = textElements[0].text()
                Picasso.get().load(imageUrl).into(imgTitle)
            }
        }
    }
}