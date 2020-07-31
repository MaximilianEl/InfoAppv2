package com.example.infoappv2.ui.chat

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    private lateinit var viewModel: ChatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        // TODO: Use the ViewModel
    }

    /*override fun OnCreate(savedInstanceState: Bundle?, activity: AppCompatActivity){
        super.onCreate(savedInstanceState)
        activity.setContentView(R.layout.fragment_chat)
        activity.setSupportActionBar(toolbar_chat)

        val toolbar: Toolbar = activity.findViewById(R.id.toolbar_chat)
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar!!.title = ""

        val tabLayout : TableLayout = activity.findViewById(R.id.tab_Layout)
        val viewPager : ViewPager = activity.findViewById(R.id.View_Pager)
    }*/
}