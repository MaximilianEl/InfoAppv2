package com.example.infoappv2.ui.imprint

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_imprint.*

class ImprintFragment : Fragment() {

    companion object {
        fun newInstance() = ImprintFragment()
    }

    private lateinit var viewModel: ImprintViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_imprint, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        facebook.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/hs.osnabrueck"))
            startActivity(i)
        }

        insta.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/hs_osnabrueck/"))
            startActivity(i)
        }

        youtube.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/HochschuleOS"))
            startActivity(i)
        }

        twitter.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/HS_Osnabrueck"))
            startActivity(i)
        }

        website.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hs-osnabrueck.de/"))
            startActivity(i)
        }

        viewModel = ViewModelProviders.of(this).get(ImprintViewModel::class.java)
        // TODO: Use the ViewModel

    }

}