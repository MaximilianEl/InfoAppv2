package com.example.infoappv2

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.infoappv2.ui.chat.ChatFragment
import kotlinx.android.synthetic.main.activity_chat.*

class ChatMainThing : AppCompatActivity() {

    //eine sexy 7

    fun OnCreateView(
        savedInstanceState: Bundle
    ){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat)
        setSupportActionBar(toolbar_chat)

        val toolbar: Toolbar = findViewById(R.id.toolbar_chat)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        val viewPager : ViewPager = findViewById(R.id.View_Pager)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(ChatFragment(), "Chats")

        viewPager.adapter = viewPagerAdapter
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
    {
        private val fragments: ArrayList<Fragment> = ArrayList<Fragment>()
        private val titles: ArrayList<String> = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment, title: String){
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]

        }
    }

}