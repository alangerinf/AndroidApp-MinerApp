package com.mat.app3.transference;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import com.mat.app3.R;
import com.mat.app3.database.entities.Report;
import com.mat.app3.models.ReportTestModel;
import com.mat.app3.transference.ui.main.ReporBasicDataFragment;
import com.mat.app3.transference.ui.main.ResportJobsFragment;
import com.mat.app3.transference.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

import java.util.Objects;

public class ReportTabbetActivity extends AppCompatActivity
        implements
        ReporBasicDataFragment.OnFragmentInteractionListener,
        ResportJobsFragment.OnFragmentInteractionListener {

    private static FloatingActionButton fab;
    private static ViewPager viewPager;
    private static TabLayout tabs;
    private static SectionsPagerAdapter sectionsPagerAdapter;
    ArrayList<String> tittles = new ArrayList<>();

    private static String TAG = ReportTabbetActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();



        declare();
        events();
    }

    private void events() {
        fab.setOnClickListener(v->{


        });
    }

    private void declare() {
        tittles = new ArrayList<>();
        tittles.add(getString(R.string.tab_text_1));
        tittles.add(getString(R.string.tab_text_2));
        PageViewModel.init();
        ReportTestModel reportTestModel = new ReportTestModel();
        PageViewModel.set(reportTestModel);
        sectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager(),tittles);

        fab = findViewById(R.id.fab);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    assert imm != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onFragmentInteraction_upd_eTextDNI(String mensaje) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}