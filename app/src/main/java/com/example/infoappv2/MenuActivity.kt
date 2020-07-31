package com.example.infoappv2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        /**
         * The DrawerMenuLayout is the Main Class for all Fragments inside the App. In this Class the
         * Navigation Drawer and the Floating Action Buttons(FAB) are declared.
         */
        @Suppress("DEPRECATION")
        class DrawerMenuLayout : AppCompatActivity() {
            private var fabInsta: FloatingActionButton? = null
            private var fabTwitter: FloatingActionButton? = null
            private var fabFaceBook: FloatingActionButton? = null
            private var fabYoutube: FloatingActionButton? = null

            /**
             * The Is fab open.
             */
            var isFabOpen = false
            private var mAppBarConfiguration: AppBarConfiguration? = null

            /**
             * The onCreate method sets thecontentView on the activity_drawer_layout. Also the Navigation
             * Drawer and as well the FAB's are declared. The DrawerLayout sets different Views for each
             * Button inside the NavigationDrawer. The FABs uses an onClick method to open and close the
             * FabMenu.
             */
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_menu)
                val toolbar =
                    findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)
                val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
                val navigationView = findViewById<NavigationView>(R.id.nav_view)
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                mAppBarConfiguration = AppBarConfiguration.Builder(
                    R.id.nav_game, R.id.nav_campus, R.id.nav_persons, R.id.nav_calender,
                    R.id.nav_chat, R.id.nav_courses, R.id.nav_feedback, R.id.nav_imprint,
                    R.id.nav_institute, R.id.nav_options, R.id.nav_stops, R.id.nav_news,
                    R.id.nav_ehelp).setDrawerLayout(drawer)
                    .build()
                val navController =
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                NavigationUI.setupActionBarWithNavController(
                    this,
                    navController,
                    mAppBarConfiguration!!
                )
                NavigationUI.setupWithNavController(navigationView, navController)
                val fab =
                    findViewById<View>(R.id.fab) as FloatingActionButton
                fabInsta = findViewById<View>(R.id.fab1) as FloatingActionButton
                fabTwitter = findViewById<View>(R.id.fab2) as FloatingActionButton
                fabFaceBook = findViewById<View>(R.id.fab3) as FloatingActionButton
                fabYoutube = findViewById<View>(R.id.fab4) as FloatingActionButton
                fab.setOnClickListener {
                    if (!isFabOpen) {
                        showFabMenu()
                    } else {
                        closeFabMenu()
                    }
                }
                fabInsta!!.setOnClickListener {
                    val url = "https://www.instagram.com/hs_osnabrueck/?hl=de"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                fabTwitter!!.setOnClickListener {
                    val url =
                        "https://twitter.com/HS_Osnabrueck?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                fabFaceBook!!.setOnClickListener {
                    val url = "https://www.facebook.com/hs.osnabrueck"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                fabYoutube!!.setOnClickListener {
                    val url = "https://www.youtube.com/user/HochschuleOS"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
            }

            /**
             * The showFabMenu method shows the Buttons on different Y-Axis positions than the closeFabMenu
             * method.
             */
            @SuppressLint("WrongConstant")
            private fun showFabMenu() {
                isFabOpen = true
                fabInsta!!.animate().translationY(-resources.getDimension(R.dimen.standard_60))
                fabTwitter!!.animate()
                    .translationY(-resources.getDimension(R.dimen.standard_105))
                fabFaceBook!!.animate()
                    .translationY(-resources.getDimension(R.dimen.standard_155))
                fabYoutube!!.animate()
                    .translationY(-resources.getDimension(R.dimen.standard_205))
            }

            private fun closeFabMenu() {
                isFabOpen = false
                fabInsta!!.animate().translationY(0f)
                fabTwitter!!.animate().translationY(0f)
                fabFaceBook!!.animate().translationY(0f)
                fabYoutube!!.animate().translationY(0f)
            }

            override fun onSupportNavigateUp(): Boolean {
                val navController =
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                return NavigationUI.navigateUp(navController, mAppBarConfiguration!!) ||
                        super.onSupportNavigateUp()
            }
        }


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_game, R.id.nav_campus, R.id.nav_persons, R.id.nav_calender, R.id.nav_chat,
                R.id.nav_courses, R.id.nav_feedback, R.id.nav_imprint, R.id.nav_institute,
                R.id.nav_options, R.id.nav_stops, R.id.nav_news, R.id.nav_ehelp
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}