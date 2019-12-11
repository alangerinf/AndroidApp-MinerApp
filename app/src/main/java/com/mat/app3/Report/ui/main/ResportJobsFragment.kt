package com.mat.app3.Report.ui.main

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.mat.app3.R
import com.mat.app3.database.MyDatabase
import com.mat.app3.Report.PageViewModel
import com.mat.app3.Report.parseToListJobs

class ResportJobsFragment : Fragment() {


    private var mListener: OnFragmentInteractionListener? = null
    private var pageViewModel: PageViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_report_jobs, container, false)

        return root
    }

    override fun onStart() {
        super.onStart()

        val fadd = view!!.findViewById<FloatingActionButton>(R.id.fjobs_fabAddJob)

        flpa_rView = view!!.findViewById(R.id.recyclerView)

        fadd.setOnClickListener {
            val listItems = resources.getStringArray(R.array.array_trabajos)

            val mBuilder = AlertDialog.Builder(activity)
            mBuilder.setTitle(
                R.string.select_job
            )
            mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
                Toast.makeText(activity, listItems[i], Toast.LENGTH_SHORT).show()
                anhadirJob(listItems[i])
                dialogInterface.dismiss()
            }
            val mDialog = mBuilder.create()
            mDialog.show()
        }

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java)
        pageViewModel!!.get().observe(this, Observer { jobList ->
            Log.d(TAG, "tamaaño " + jobList.size)
            adapter = RViewAdapterJobs(activity!!, jobList)
            //  new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(flpa_rView);
            ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(flpa_rView)
            flpa_rView.adapter = adapter

            val tViewSinItems = view!!.findViewById<TextView>(R.id.tViewSin)
            tViewSinItems.visibility = if (jobList.size > 0) View.INVISIBLE else View.VISIBLE
        })


    }

    private val itemTouchHelperCallBack =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val index =
                    viewHolder.adapterPosition//esto tiene q ir arriba porq la programacion reaccitva elimina de inmediato en el recycler view sin actualizar
                val item = PageViewModel.removeJob(index)
                Thread{
                    parseToListJobs.guardar(activity!!,PageViewModel.getMutable())
                }.start()

                val snackbar = Snackbar.make(root, "Se elímino un Trabajo", Snackbar.LENGTH_LONG)
                snackbar.setAction(
                    "Deshacer"
                ) {
                    PageViewModel.addJob(index, item)
                    parseToListJobs.guardar(activity!!,PageViewModel.getMutable())
                }

                snackbar.show()
            }
        }
    private fun  anhadirJob(jobName: String) {

        val handler = Handler()
        Thread{

                val dao = MyDatabase.getInstance(activity).reportDao()

                val report = dao.selectAll()[0]
                if (report.trab1.isEmpty()) {
                    report.trab1 = jobName
                    dao.update(report)

                }else{
                    if (report.trab2.isEmpty()) {
                        report.trab2 = jobName
                        dao.update(report)
                    }else{

                        if (report.trab3.isEmpty()) {
                            report.trab3 = jobName
                            dao.update(report)
                        }else{

                            if (report.trab4.isEmpty()) {
                                report.trab1 = jobName
                                dao.update(report)
                            }else{
                                if (report.trab5.isEmpty()) {
                                    report.trab5 = jobName
                                    dao.update(report)
                                }else{


                                    if (report.trab6.isEmpty()) {
                                        report.trab6 = jobName
                                        dao.update(report)

                                    }else{

                                        handler.post {
                                            Toast.makeText(
                                                activity,
                                                getString(R.string.error_add_actividaddes),
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            PageViewModel.setPost(parseToListJobs.parse(dao.selectAll().get(0)))
        }.start()
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
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

    override fun onDetach() {
        super.onDetach()
        mListener = null
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
        fun onFragmentInteraction(uri: Uri)

    }

    companion object {

        internal lateinit var adapter: RViewAdapterJobs

        // TODO: Rename and change types and number of parameters
        fun newInstance(): ResportJobsFragment {
            val fragment = ResportJobsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

        internal lateinit var root: View

        internal lateinit var flpa_rView: RecyclerView

        internal var TAG = ResportJobsFragment::class.java.simpleName
    }


}// Required empty public constructor

