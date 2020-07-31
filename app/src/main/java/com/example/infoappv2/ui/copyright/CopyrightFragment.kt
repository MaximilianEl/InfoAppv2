package com.example.infoappv2.ui.copyright

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R

class CopyrightFragment : Fragment() {

    companion object {
        fun newInstance() = CopyrightFragment()
    }

    private lateinit var viewModel: CopyrightViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_copyright, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CopyrightViewModel::class.java)
        // TODO: Use the ViewModel
    }

}