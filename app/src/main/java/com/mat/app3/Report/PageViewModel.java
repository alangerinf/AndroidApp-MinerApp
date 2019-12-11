package com.mat.app3.Report;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


import com.mat.app3.models.Job;

import java.util.List;

public class PageViewModel extends ViewModel {

    private static MutableLiveData<List<Job>> listMutableLiveData;
    private LiveData<List<Job>> listLiveData = Transformations.map(listMutableLiveData, input -> input);

    public static void set(List<Job> index) {
        listMutableLiveData.setValue(index);
    }

    public static void setPost(List<Job> index) {
        listMutableLiveData.postValue(index);
    }

    public static void addJob(int index, Job tareoDetalleVO){
        listMutableLiveData.getValue().add(index,tareoDetalleVO);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }

    public static void addJob(Job job){
        listMutableLiveData.getValue().add(job);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }

    public static void removeJob(Job job){
        listMutableLiveData.getValue().remove(job);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
    }

    public static Job removeJob(int i){
        Job job = listMutableLiveData.getValue().remove(i);
        listMutableLiveData.setValue(listMutableLiveData.getValue());
        return job;
    }

    public LiveData<List<Job>> get() {
        return listLiveData;
    }

    public static List<Job> getMutable(){
        return  listMutableLiveData.getValue();
    }

    public static void init(){
        listMutableLiveData = new MutableLiveData<>();
    }

}