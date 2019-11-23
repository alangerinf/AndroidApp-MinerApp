package com.mat.app3.transference;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


import com.mat.app3.models.ReportTestModel;

public class PageViewModel extends ViewModel {

    private static MutableLiveData<ReportTestModel> listMutableLiveData;
    private LiveData<ReportTestModel> listLiveData = Transformations.map(listMutableLiveData, input -> input);

    public static void set(ReportTestModel index) {
        listMutableLiveData.setValue(index);
    }

    public static void addJob(int index, ReportTestModel.Job tareoDetalleVO){
        listMutableLiveData.getValue().getJobs().add(index,tareoDetalleVO);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }

    public static void addJob(ReportTestModel.Job job){
        listMutableLiveData.getValue().getJobs().add(job);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }
    public static void removeTrabajador(ReportTestModel.Job job){
        listMutableLiveData.getValue().getJobs().remove(job);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }

    public LiveData<ReportTestModel> get() {
        return listLiveData;
    }

    public static ReportTestModel getMutable(){
        return  listMutableLiveData.getValue();
    }

    public static void init(){
        listMutableLiveData = new MutableLiveData<>();
    }

}