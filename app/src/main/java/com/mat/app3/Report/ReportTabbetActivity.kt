package com.mat.app3.Report

import android.content.Context
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.ActionBar

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

import com.mat.app3.R
import com.mat.app3.database.MyDatabase
import com.mat.app3.Report.ui.main.ReporBasicDataFragment
import com.mat.app3.Report.ui.main.ResportJobsFragment
import com.mat.app3.Report.ui.main.SectionsPagerAdapter

import java.util.ArrayList

import java.util.Objects

class ReportTabbetActivity : AppCompatActivity(),
    ReporBasicDataFragment.OnFragmentInteractionListener,
    ResportJobsFragment.OnFragmentInteractionListener {
    internal var tittles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbet)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(true)

        val b = intent.extras



        declare()
        events()
    }



    private fun events() {
        fab!!.setOnClickListener { v ->


        }
    }

    private fun declare() {
        tittles = ArrayList()
        tittles.add(getString(R.string.tab_text_1))
        tittles.add(getString(R.string.tab_text_2))

        Thread{
            PageViewModel.init()
            PageViewModel.setPost(parseToListJobs.parse(MyDatabase.getInstance(this).reportDao().selectAll().get(0)))
        }.start()

        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, tittles)

        fab = findViewById(R.id.fab)
        viewPager = findViewById(R.id.view_pager)
        viewPager!!.adapter = sectionsPagerAdapter

        tabs = findViewById(R.id.tabs)
        tabs!!.setupWithViewPager(viewPager)

    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onFragmentInteraction_upd_eTextDNI(mensaje: String) {

    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    companion object {

        private var fab: FloatingActionButton? = null
        private var viewPager: ViewPager? = null
        private var tabs: TabLayout? = null
        private var sectionsPagerAdapter: SectionsPagerAdapter? = null

        private val TAG = ReportTabbetActivity::class.java.simpleName
    }


}