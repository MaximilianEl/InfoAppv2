package com.example.infoappv2.ui.campus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R
import com.example.infoappv2.ui.institute.InstituteFragment
import com.example.infoappv2.ui.institute.InstituteViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_campus.*
import kotlinx.android.synthetic.main.fragment_institute.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

@Suppress("UNREACHABLE_CODE")
class CampusFragment : Fragment() {

    companion object {
        fun newInstance() = CampusFragment()
    }

    private lateinit var viewModel: CampusViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_campus, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CampusViewModel::class.java)
        getCampData()
    }

    fun getCampData() {
        thread {
            val url = "https://www.hs-osnabrueck.de/wir/fakultaeten/mkt/campus-lingen"
            val doc = Jsoup.connect(url).get()

            val path1 = "https://www.lingen.de/img_files/header/1920/campus/015418_2139_1.jpg"
            val path2 = "https://www.lingen.de/img_files/header/1920/campus/010288_2141_1.jpg"
            val path3 = "https://www.lingen.de/img_files/header/1920/campus/015063_2138_1.jpg"
            val path4 = "https://www.lingen.de/img_files/header/1920/campus/12792-gueterbahnhof-ansicht-vom-wasserturm-1950_2137_1.jpg"
            val path5 = "https://www.lingen.de/img_files/header/1920/campus/2594-bahnhof-eisenbahnausbesserungswerk-1959_2140_1.jpg"
            val path6 = "https://www.lingen.de/img_files/header/1920/campus/hallen-i-und-ii-innen_2143_1.jpg"
            val path7 = "https://www.hs-osnabrueck.de/fileadmin/_processed_/f/9/csm_Campus_Lingen_2019_neu1_0bea38c581.jpg"
            val path8 = "https://www.hs-osnabrueck.de/fileadmin/_processed_/5/b/csm_Campus_Lingen_2019_neu2_3b3bb482ef.jpg"

            activity?.runOnUiThread {

                Picasso.get().load(path1).resize(1200, 1200).centerCrop().into(camp_img1)
                Picasso.get().load(path2).resize(1200, 1200).centerCrop().into(camp_img2)
                Picasso.get().load(path3).resize(1200, 1200).centerCrop().into(camp_img3)
                Picasso.get().load(path4).resize(1200, 1200).centerInside().into(camp_img4)
                Picasso.get().load(path5).resize(1200, 1200).centerCrop().into(camp_img5)
                Picasso.get().load(path6).resize(1200, 1200).centerCrop().into(camp_img6)
                Picasso.get().load(path7).resize(1200, 1200).centerCrop().into(camp_img7)
                Picasso.get().load(path8).resize(1200, 1200).centerCrop().into(camp_img8)

            }
        }
    }
}