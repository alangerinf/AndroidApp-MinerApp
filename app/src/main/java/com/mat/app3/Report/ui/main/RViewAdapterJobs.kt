package com.mat.app3.Report.ui.main

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.mat.app3.R
import com.mat.app3.Report.PageViewModel
import com.mat.app3.Report.parseToListJobs
import com.mat.app3.database.MyDatabase
import com.mat.app3.models.Job


class RViewAdapterJobs(internal var ctx: Context, internal var jobList: List<Job>) :
    RecyclerView.Adapter<RViewAdapterJobs.ViewHolder>(), View.OnClickListener {

    private val TAG =
        RViewAdapterJobs::class.java.simpleName

    private var onClickListener: View.OnClickListener? = null


    private var dialog: Dialog? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_report_jobs_item, null, false)

        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = jobList[position]

        holder.tViewJob.text = item.activity
        if (!item.timeStart.isEmpty()) {
            holder.tViewDateStart.text = item.timeStart
        }
        if (!item.timeEnd.isEmpty()) {
            holder.tViewDateEnd.text = item.timeEnd
        }

        if(!item.detail.isEmpty()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.fabComment.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_insert_comment_black_24dp, ctx.getTheme()))
            } else {
                holder.fabComment.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_insert_comment_black_24dp))
            }
        }

        holder.btnDateStart.setOnClickListener { openDialogHoraStart(item, holder) }

        holder.btnDateEnd.setOnClickListener { openDialogHoraEnd(item, holder) }

        holder.fabComment.setOnClickListener{
            showComent(item,holder)
        }

    }

    fun showComent(item: Job, holder: ViewHolder) {

        var coment = item.detail
        dialog = Dialog(ctx)

        dialog!!.setContentView(R.layout.dialog_coment)
        val btnDialogClose = dialog!!.findViewById(R.id.buton_ok)  as Button
        val eTextcoment = dialog!!.findViewById(R.id.eTextComent)  as EditText

        eTextcoment.setText(coment)

        btnDialogClose.setOnClickListener{
            item.detail= eTextcoment.text.toString()
            parseToListJobs.guardar(ctx,jobList);
            dialog!!.dismiss()
            notifyDataSetChanged()
        }

        dialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()


    }

    fun setOnClicListener(listener: View.OnClickListener) {
        this.onClickListener = listener
    }

    override fun onClick(v: View) {
        if (onClickListener != null) {
            onClickListener!!.onClick(v)
        }
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    fun openDialogHoraStart(item: Job, holder: ViewHolder) {

        holder.btnDateStart.error = null
        dialog = Dialog(ctx)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.hourpicker)

        val timePicker = dialog!!.findViewById<TimePicker>(R.id.hour_datePicker1)
        timePicker.setIs24HourView(true)
        val strFecha = holder.btnDateStart.text.toString()
        var hour = 0
        var minute = 0

        try {
            val parts = strFecha.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            hour = Integer.parseInt(parts[0])
            minute = Integer.parseInt(parts[1])

        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }


        if (hour != 0 && minute != 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                timePicker.hour = hour
                timePicker.minute = minute
            }
        }

        val btn_aceptar = dialog!!.findViewById<Button>(R.id.hour_date_btn_aceptar)
        btn_aceptar.setOnClickListener {

            var hourTemp = 0
            var minuteTemp = 0
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                hourTemp = timePicker.hour
                minuteTemp = timePicker.minute
            }


            var hour_ = hourTemp.toString()
            var minute_ = minuteTemp.toString()


            if (hour_.length == 1) {
                hour_ = "0$hour_"
            }

            if (minute_.length == 1) {
                minute_ = "0$minute_"
            }

            val fechaF = "$hour_:$minute_"


            holder.tViewDateStart.text = fechaF

            item.timeStart = fechaF

            parseToListJobs.guardar(ctx,jobList);

            dialog!!.dismiss()

        }
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()
    }

    fun openDialogHoraEnd(item: Job, holder: ViewHolder) {

        holder.btnDateEnd.error = null
        dialog = Dialog(ctx)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.hourpicker)

        val timePicker = dialog!!.findViewById<TimePicker>(R.id.hour_datePicker1)
        timePicker.setIs24HourView(true)
        val strFecha = holder.btnDateEnd.text.toString()
        var hour = 0
        var minute = 0

        try {
            val parts = strFecha.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            hour = Integer.parseInt(parts[0])
            minute = Integer.parseInt(parts[1])
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }

        if (hour != 0 && minute != 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                timePicker.hour = hour
                timePicker.minute = minute
            }
        }

        val btn_aceptar = dialog!!.findViewById<Button>(R.id.hour_date_btn_aceptar)
        btn_aceptar.setOnClickListener {

            var hourTemp = 0
            var minuteTemp = 0
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                hourTemp = timePicker.hour
                minuteTemp = timePicker.minute
            }
            var hour_ = hourTemp.toString()
            var minute_ = minuteTemp.toString()


            if (hour_.length == 1) {
                hour_ = "0$hour_"
            }

            if (minute_.length == 1) {
                minute_ = "0$minute_"
            }

            val fechaF = "$hour_:$minute_"


            holder.tViewDateEnd.text = fechaF

            item.timeEnd = fechaF
            parseToListJobs.guardar(ctx,jobList);

            dialog!!.dismiss()

        }

        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tViewJob: TextView
        internal var tViewTotalHours: TextView

        internal var btnDateStart: Button
        internal var btnDateEnd: Button

        internal var tViewDateStart: TextView
        internal var tViewDateEnd: TextView


        internal var fabComment: FloatingActionButton

        init {

            tViewJob = itemView.findViewById(R.id.fjobitem_tViewJob)
            btnDateStart = itemView.findViewById(R.id.fjobitem_btnDateStart)
            btnDateEnd = itemView.findViewById(R.id.fjobitem_btnDateEnd)
            tViewDateStart = itemView.findViewById(R.id.fjobitem_tViewDateStart)
            tViewDateEnd = itemView.findViewById(R.id.fjobitem_tViewDateEnd)
            tViewTotalHours = itemView.findViewById(R.id.fjobitem_tViewTotalHours)
            fabComment = itemView.findViewById(R.id.fabComent)

        }
    }

}
