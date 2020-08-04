package com.example.infoappv2.ui.person

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
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

        personViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    @SuppressLint("ResourceType")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        retrieveWebInfo()
    }

    private fun retrieveWebInfo() {
        thread {
            //Verbindung zur Hochschulseite
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/organisation/personen-a-z/?az=rolle:professor%2Ainnen/"
            val doc = Jsoup.connect(url).get()

            val div_azitem = doc.getElementsByClass("az-item")

            //Variable für die For-Schleife um die genaue Länge herauszulesen
            val divlength = div_azitem.size
            //println("Die länge beträgt:" + divlength)

            val div_scrollviewinfo = div_azitem.first().text()

            //For-Schleife für ScrollView
            val div_collapse = div_azitem.get(0).getElementsByClass("panel-collapse collapse")

            val div_body = div_collapse.get(0).getElementsByClass("panel-body")

            val div_pers = div_body.select("div.person-info").get(0).allElements.html()

//            this.run{
//
//                Picasso.get().load(imageUrl).into(persImage)
//                persName.text = name.text()
//                persFac.text = fac.text()
//                pers_call.text = number.text()
//                pers_email.text = mail.text()
//                pers_room.text = room.text()
//                pers_fax.text = fax.text()

//            }
        }
    }
}