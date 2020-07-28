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

class CampusFragment : Fragment() {

    private lateinit var campusViewModel: CampusViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        campusViewModel =
            ViewModelProviders.of(this).get(CampusViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_campus, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        campusViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}