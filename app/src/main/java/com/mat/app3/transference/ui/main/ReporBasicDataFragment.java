package com.mat.app3.transference.ui.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.integration.android.IntentIntegrator;
import com.ibao.alanger.worktime.R;
import com.ibao.alanger.worktime.models.VO.external.TrabajadorVO;
import com.ibao.alanger.worktime.models.VO.internal.TareoDetalleVO;
import com.ibao.alanger.worktime.models.VO.internal.TareoVO;
import com.ibao.alanger.worktime.views.transference.CustomScannerActivity;
import com.ibao.alanger.worktime.views.transference.PageViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static com.ibao.alanger.worktime.views.transference.CustomScannerActivity.EXTRA_HOUR;
import static com.ibao.alanger.worktime.views.transference.CustomScannerActivity.REQUEST_QR;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReporBasicDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReporBasicDataFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String TAG = ReporBasicDataFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private static String mParam1;
    private static TareoVO mParamTAREOVOB;

    private OnFragmentInteractionListener mListener;


    private static TextInputEditText ftp_tieTextHour;
    private static TextInputEditText ftp_tieTextDNI;
    private static FloatingActionButton ftp_fabSetTime;
    private static FloatingActionButton ftp_fabSetCancel;
    private static FloatingActionButton ftp_fabQR;
    private static FloatingActionButton ftp_fabRestart;
    private static MaterialButton ftp_btnAdd;

    public ReporBasicDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param paramTareoVOB Parameter 2.
     * @return A new instance of fragment ReporBasicDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReporBasicDataFragment newInstance(String param1, TareoVO paramTareoVOB) {
        ReporBasicDataFragment fragment = new ReporBasicDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putSerializable(ARG_PARAM2, paramTareoVOB);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParamTAREOVOB = (TareoVO) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    static View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_add_personal, container, false);
        return root;
    }


    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction_upd_eTextDNI(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        declare();
        events();

    }

    private Handler handlerHourUpdater = new Handler();
    private Runnable runHourUpdater = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Actualizando hora");
            ftp_tieTextHour.setText(getHour());
            handlerHourUpdater.postDelayed(this,1000);
        }
    };

    private void events() {
        Log.d(TAG,"events");

        startHourCounter();

        ftp_fabSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker(ftp_tieTextHour);
            }
        });

        ftp_fabSetCancel.setOnClickListener(v->{
            startHourCounter();
        });


        ftp_fabRestart.setOnClickListener(v->{
            startHourCounter();
            ftp_tieTextDNI.setText("");
            ftp_tieTextDNI.requestFocus();
            ((InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .showSoftInput(ftp_tieTextDNI, InputMethodManager.SHOW_FORCED);
        });

        ftp_fabQR.setOnClickListener(v->{
            IntentIntegrator intentIntegrator =new IntentIntegrator(getActivity());
            intentIntegrator
                    .setOrientationLocked(false)
                    .setCaptureActivity(CustomScannerActivity.class)
                    .setRequestCode(REQUEST_QR)
                    .addExtra(EXTRA_HOUR,isCounterRun?"":""+ftp_tieTextHour.getText().toString())
                    .addExtra(CustomScannerActivity.EXTRA_MODE,CustomScannerActivity.EXTRA_MODE_ADD_TRABAJADORES)
                    .addExtra(CustomScannerActivity.EXTRA_TAREO,mParamTAREOVOB)
                    .initiateScan();
        });

        ftp_btnAdd.setOnClickListener(v->{
            String dni = ftp_tieTextDNI.getText().toString();
            String time[] = ftp_tieTextHour.getText().toString().split(":");
            int hour = Integer.valueOf(time[0]);
            int minutes = Integer.valueOf(time[1]);

            if(dni.length()==8){

                if(verificarDNI(dni)){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    date.setHours(hour);
                    date.setMinutes(minutes);
                    date = removeSeconds(date);
                    Snackbar snackbar= Snackbar.make(root,"Agregado Trabajador "+dni+" "+formatter.format(date), Snackbar.LENGTH_SHORT);
                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
                    snackbar.show();
                    //buscar si existe
                    TareoDetalleVO tareoDetalleVO = new TareoDetalleVO();
                    tareoDetalleVO.setTimeStart(formatter.format(date));
                    TrabajadorVO trabajadorVO = new TrabajadorVO();
                    trabajadorVO.setDni(dni);
                    tareoDetalleVO.setTrabajadorVO(trabajadorVO);

                    PageViewModel.addTrabajador(tareoDetalleVO);
                }
            }else {
                Snackbar snackbar= Snackbar.make(root,"DNI invalido", Snackbar.LENGTH_SHORT);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red_pastel));
                snackbar.show();
            }
        });
    }

    public boolean  verificarDNI(String dni){

        boolean flag = true;//valido
        List<TareoDetalleVO> tareoDetalleVOList = PageViewModel.getMutable();
        for(TareoDetalleVO t :  tareoDetalleVOList){
            if(t.getTrabajadorVO().getDni().equals(dni)){
                flag=false;
                Snackbar snackbar= Snackbar.make(root,"Trabajador ya agregado a la Lista", Snackbar.LENGTH_SHORT);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red_pastel));
                snackbar.show();
                break;
            }
        }
        if(flag){//el tareo acutal
            for(TareoDetalleVO t :  mParamTAREOVOB.getTareoDetalleVOList()){
                if(t.getTrabajadorVO().getDni().equals(dni)){
                    flag=false;
                    Snackbar snackbar= Snackbar.make(root,"Trabajador ya agregado a la Labor", Snackbar.LENGTH_SHORT);
                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red_pastel));
                    snackbar.show();
                    break;
                }
            }
        }
        if(flag){//buscar en la bd

        }

        return flag;
    }
    public static Date removeSeconds(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    boolean isCounterRun;

    void startHourCounter(){
        isCounterRun=true;
        ftp_fabSetTime.setAlpha(1f);
        ftp_fabSetTime.setClickable(true);
        ftp_fabSetTime.setFocusable(true);
        handlerHourUpdater.post(
                runHourUpdater
        );
        ftp_fabSetCancel.setAlpha(0f);
        ftp_fabSetCancel.setClickable(false);
        ftp_fabSetCancel.setFocusable(false);
    }


    void stopHourCounter(){//
        //Activar el bonn de  cancelar
        isCounterRun=false;
        ftp_fabSetCancel.setAlpha(1f);
        ftp_fabSetCancel.setClickable(true);
        ftp_fabSetCancel.setFocusable(true);
        ftp_fabSetTime.setAlpha(0f);
        ftp_fabSetTime.setClickable(false);
        ftp_fabSetTime.setFocusable(false);
        handlerHourUpdater.removeCallbacks(runHourUpdater);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        handlerHourUpdater.removeCallbacks(runHourUpdater);
    }

    private void declare() {
        Log.d(TAG,"declare");
        ftp_tieTextHour = getView().findViewById(R.id.ftp_tieTextHour);
        ftp_tieTextDNI = getView().findViewById(R.id.ftp_tieTextDNI);
        ftp_fabSetTime = getView().findViewById(R.id.ftp_fabSetTime);
        ftp_fabSetCancel = getView().findViewById(R.id.ftp_fabSetCancel);
        ftp_fabQR = getView().findViewById(R.id.ftp_fabQR);
        ftp_fabRestart = getView().findViewById(R.id.ftp_fabRestart);
        ftp_btnAdd = getView().findViewById(R.id.ftp_btnAdd);
    }

    String getHour(){
        Calendar calendar = new GregorianCalendar();

        int hour  = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String strHour = "";
        String strMinute = "";

        if(hour<10){
            strHour = "0"+hour;
        }else {
            strHour = ""+hour;
        }

        if(minute<10){
            strMinute = "0"+minute;
        }else {
            strMinute = ""+minute;
        }

        return strHour+":"+strMinute;
    }


    public void openTimePicker(final TextView tViewHora) {
        Dialog dialog;
        tViewHora.setError(null);
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.hourpicker);

        final TimePicker timePicker = dialog.findViewById(R.id.hour_datePicker1);
        timePicker.setIs24HourView(true);

        String strFecha= tViewHora.getText().toString();
        final String fecha = strFecha;
        int hour=0;
        int minute=0;

        try{
            String[] parts = fecha.split(":");
            hour = Integer.parseInt(parts[0]);
            minute = Integer.parseInt(parts[1]);

        }catch (Exception e){
            Log.d(TAG,e.toString());
        }


        if(hour != 0 && minute != 0 ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                timePicker.setHour(hour);
                timePicker.setMinute(minute);
            }
        }

        final Button btn_aceptar = dialog.findViewById(R.id.hour_date_btn_aceptar);
        btn_aceptar.setOnClickListener(view -> {

            int hourTemp = 0;
            int minuteTemp =0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                hourTemp = timePicker.getHour();
                minuteTemp = timePicker.getMinute();
            }


            String hour_ = String.valueOf(hourTemp);
            String minute_ = String.valueOf(minuteTemp);


            if(hour_.length()==1){
                hour_ = "0"+hour_;
            }

            if(minute_.length()==1){
                minute_ = "0"+minute_;
            }

            String fechaF = hour_+":"+minute_;


            tViewHora.setText(fechaF);

            dialog.dismiss();

            //BuscarServicios();
            stopHourCounter();
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction_upd_eTextDNI(String mensaje);
    }
}