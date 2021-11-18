package com.example.mvvmfirestoreandroidapp.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmfirestoreandroidapp.model.SampleModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SampleViewModel extends ViewModel {

    public LiveData<SampleModel> getSampleData(){

        final MutableLiveData<SampleModel> sampleDataMutableLiveData = new MutableLiveData<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("data").document("sample");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        Log.w("SAMPLEVIEWMODEL", document.toString());
                        SampleModel sampleModel = document.toObject(SampleModel.class);
                        sampleDataMutableLiveData.postValue(sampleModel);
                    } else {
                        sampleDataMutableLiveData.postValue(null);
                    }
                } else {
                    sampleDataMutableLiveData.postValue(null);
                }
            }
        });

        return sampleDataMutableLiveData;
    }
}

