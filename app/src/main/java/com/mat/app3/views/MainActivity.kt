package com.mat.app3.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mat.app3.R
import com.mat.app3.Utils.goToActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btnReport.setOnClickListener {
            goToActivity<ForgotPasswordActivity>()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

    }
}
