package com.example.mvvmfirestoreandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmfirestoreandroidapp.model.SampleModel;
import com.example.mvvmfirestoreandroidapp.viewmodel.SampleViewModel;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private SampleViewModel sampleViewModel;
    private TextView sampleString, sampleInt, sampleBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleString = findViewById(R.id.sampleString);
        sampleInt = findViewById(R.id.sampleInt);
        sampleBoolean = findViewById(R.id.sampleBoolean);

        sampleViewModel =  ViewModelProviders.of(this).get(SampleViewModel.class);
        sampleViewModel.getSampleData().observe(this,new Observer<SampleModel>(){
            @Override
            public void onChanged(SampleModel sampleModel) {
                if(sampleModel != null){
                    //UPDATE UI HERE
                    Timber.d("Sample string is: " + sampleModel.getSampleString());
                    sampleString.setText("Sample String is: " + sampleModel.getSampleString());
                    Timber.d( "Sample int is: " + sampleModel.getSampleInt());
                    sampleInt.setText("Sample Int is: " + sampleModel.getSampleInt());
                    Timber.d( "Sample boolean is: " + sampleModel.getSampleBoolean());
                    sampleBoolean.setText("Sample boolean is: " + sampleModel.getSampleBoolean());

                } else {
                    //SHOW ERROR MESSAGE
                    Timber.d("Error sampleModel");
                }
            }
        });

    }
}