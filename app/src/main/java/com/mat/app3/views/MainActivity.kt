package com.mat.app3.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mat.app3.R
import com.mat.app3.Utils.goToActivity
import com.mat.app3.database.MyDatabase
import com.mat.app3.database.entities.Report
import com.mat.app3.Report.ReportTabbetActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var TAG : String = "TAGMainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()


        Thread {

            var db = MyDatabase.getInstance(applicationContext)

            var todos = db.reportDao().selectAll()

            if (todos.isNotEmpty()) { // va ha llamar a lo q  nesecite en la actividad siguiente
                main_btnReport.text= "Report (Continuar)"
            }

        }.start()


        main_btnReport.setOnClickListener {

            Thread {

                var db = MyDatabase.getInstance(applicationContext)

                var todos = db.reportDao().selectAll()

                if (todos.isNotEmpty()) { // va ha llamar a lo q  nesecite en la actividad siguiente
                    Log.i(TAG, todos.get(0).toString())
                } else {
                    db.reportDao().insert(Report())
                    Log.i(TAG, "insertando")

                }
                goToActivity<ReportTabbetActivity>()
                overridePendingTransition(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
            }.start()
        }
    }
}
