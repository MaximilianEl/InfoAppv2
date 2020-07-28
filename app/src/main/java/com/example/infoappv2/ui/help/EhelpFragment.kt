package com.example.infoappv2.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.infoappv2.R

class EhelpFragment : Fragment() {

    private lateinit var ehelpViewModel: EhelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ehelpViewModel =
            ViewModelProviders.of(this).get(EhelpViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ehelp, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        ehelpViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}