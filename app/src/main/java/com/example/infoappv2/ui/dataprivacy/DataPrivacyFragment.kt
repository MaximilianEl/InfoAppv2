package com.example.infoappv2.ui.dataprivacy

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R

class DataPrivacyFragment : Fragment() {

    companion object {
        fun newInstance() = DataPrivacyFragment()
    }

    private lateinit var viewModel: DataPrivacyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_privacy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DataPrivacyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}