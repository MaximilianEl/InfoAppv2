package com.example.infoappv2.ui.person

import android.annotation.SuppressLint
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

            //Variable für die For-Schleife um die genaue Länge herauszulesen
            val div1 = doc.getElementsByClass("az-item").size
            println("Die länge beträgt:" + div1)

            val div = doc.getElementsByClass("az-list-inner-content").html()
            val divOther = div.length


//            val imgDiv = div.getElementsByClass("image-wrapper")
//            val genDiv = div.getElementsByClass("general-Information")
//            val conDiv = div.getElementsByClass("contact-information")
//
//            val img = imgDiv.
//            val name = genDiv.select("[itemprop=name]")
//            val fac = genDiv.select("p")
//            val number = conDiv.select("[itemprop=telephone]")
//            val mail = conDiv.select("[itemprop=email]")
//            val room = conDiv.select("[itemprop=room]")
//            val fax = conDiv.select("[itemprop=faxNumber]")

//            val  imageUrl = img[0].absUrl("src")
//
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