package com.example.infoappv2.ui.disclaimer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.infoappv2.R

class DisclaimerFragment : Fragment() {

    companion object {
        fun newInstance() = DisclaimerFragment()
    }

    private lateinit var viewModel: DisclaimerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_disclaimer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DisclaimerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}