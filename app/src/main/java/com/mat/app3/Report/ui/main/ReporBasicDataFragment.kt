package com.mat.app3.Report.ui.main

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.DatePicker

import androidx.fragment.app.Fragment

import com.mat.app3.R
import com.mat.app3.database.MyDatabase
import kotlinx.android.synthetic.main.fragment_report_basics.*

import java.util.Date
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ReporBasicDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReporBasicDataFragment : Fragment() {

    private val TAG = ReporBasicDataFragment::class.java.simpleName


    private var mListener: OnFragmentInteractionListener? = null

    private var dialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_report_basics, container, false)
        return root
    }


    fun onButtonPressed(uri: String) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction_upd_eTextDNI(uri)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    val handler = Handler()

    override fun onStart() {
        super.onStart()
        events()

        Thread{

            var db = MyDatabase.getInstance(activity!!)
            var temp = db.reportDao().selectAll().get(0)


            handler.post {
                if(!temp.date.equals("")){
                    fbasic_tViewDate.text = temp.date
                }

                fBasic_eTextEmail.setText(temp.email)
                fBasic_eTextOT.setText(temp.ot)
                fBasic_eTextBoss.setText(temp.boss)
                fBasic_eTextOpName.setText(temp.opName)
                fBasic_eTextNumEquipo.setText(temp.numEquipo)

                if(temp.Petroleum!=0f){
                    fBasic_eTextPetroleo.setText(""+temp.Petroleum)
                }

                if(temp.horometerStart!=0f){
                    fBasic_eTextHoroStart.setText(""+temp.horometerStart)
                }


                if(temp.horometerEnd!=0f){
                    fBasic_eTextHoroEnd.setText(""+temp.horometerEnd)
                }

                var turnosList = resources.getStringArray(R.array.array_turno)

                if(!temp.turn.equals("")){
                    for (i in 0..turnosList.size-1) {
                            if(temp.turn.equals(turnosList.get(i))){
                                fBasic_spnTurno.setSelection(i)
                            }
                    }
                }
            }


        }.start()


    }


    private fun events() {
        Log.d(TAG, "events")

        fbasic_btnData.setOnClickListener{
            openDialogFecha()
        }


        fBasic_eTextEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val text = fBasic_eTextEmail.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextEmail.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        data.email = text
                        db.reportDao().update(data)

                    }.start()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        fBasic_eTextOT.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val text = fBasic_eTextOT.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextOT.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        data.ot = text
                        db.reportDao().update(data)

                    }.start()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })



        fBasic_eTextBoss.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextBoss.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextBoss.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        data.boss = text
                        db.reportDao().update(data)

                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        fBasic_eTextOpName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextOpName.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextOpName.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        data.opName = text
                        db.reportDao().update(data)

                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        fBasic_eTextNumEquipo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextNumEquipo.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextNumEquipo.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        data.numEquipo = text
                        db.reportDao().update(data)

                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        fBasic_spnTurno.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                    Thread{
                        var text = fBasic_spnTurno.getSelectedItem().toString()
                        var db = MyDatabase.getInstance(activity)
                        var data = db.reportDao().selectAll().get(0)
                        data.turn = text
                        db.reportDao().update(data)
                    }.start()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // your code here
            }

        })




        fBasic_eTextPetroleo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextPetroleo.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextPetroleo.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        try {
                            data.Petroleum = text.toFloat()
                            db.reportDao().update(data)
                        }catch (e : java.lang.Exception){

                            Toast.makeText(activity!!,e.toString(),Toast.LENGTH_LONG).show()
                        }
                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })



        fBasic_eTextHoroStart.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextHoroStart.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextHoroStart.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        try {
                            data.horometerStart = text.toFloat()
                            db.reportDao().update(data)
                        }catch (e : java.lang.Exception){
                            Toast.makeText(activity!!,e.toString(),Toast.LENGTH_LONG).show()
                        }
                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })

        fBasic_eTextHoroEnd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

                val text = fBasic_eTextHoroEnd.text.toString()

                if (text.equals(" ")) {
                    fBasic_eTextHoroEnd.setText("")
                } else {
                    Thread{
                        var db = MyDatabase.getInstance(activity)

                        var data = db.reportDao().selectAll().get(0)
                        try {
                            data.horometerEnd = text.toFloat()
                            db.reportDao().update(data)
                        }catch (e : java.lang.Exception){
                            Toast.makeText(activity!!,e.toString(),Toast.LENGTH_LONG).show()
                        }
                    }.start()
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })
    }




    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    fun openDialogFecha() {
        fbasic_tViewDate.error = null
        dialog = Dialog(activity!!)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.datepicker)

        val datePicker = dialog!!.findViewById<DatePicker>(R.id.datePicker)

        val strFecha = fbasic_tViewDate.text.toString()
        var year = 0
        var month = 0
        var day = 0
        try {
            val parts = strFecha.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            year = Integer.parseInt(parts[0])
            month = Integer.parseInt(parts[1]) - 1
            day = Integer.parseInt(parts[2])
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }


        if (year != 0 && month != 0 && day != 0) {
            datePicker.updateDate(year, month, day)
        }

        val btn_aceptar = dialog!!.findViewById<Button>(R.id.btn_aceptar)
        btn_aceptar.setOnClickListener { view ->
            val day1 = datePicker.dayOfMonth
            val month1 = datePicker.month + 1
            val year1 = datePicker.year

            var dia = day1.toString()
            var mes = month1.toString()
            val anio = year1.toString()

            if (dia.length == 1) {
                dia = "0$dia"
            }

            if (mes.length == 1) {
                mes = "0$mes"
            }

            val date = Date()
            date.year = Integer.parseInt(anio)
            date.month = Integer.parseInt(mes + 1)
            date.date = Integer.parseInt(dia)

            val fechaF = "$anio-$mes-$dia"

            fbasic_tViewDate.text = fechaF

            //guardar en db
            Thread{

                var db = MyDatabase.getInstance(activity)
                var data  = db.reportDao().selectAll().get(0)
                data.date = fechaF
                db.reportDao().update(data)

            }.start()

            dialog!!.dismiss()

            //BuscarServicios();
        }

        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction_upd_eTextDNI(mensaje: String)
    }

    companion object {


        fun newInstance(): ReporBasicDataFragment {
            val fragment = ReporBasicDataFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

        internal lateinit var root: View
    }
}// Required empty public constructor
