package com.example.mvvmfirestoreandroidapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmfirestoreandroidapp.R;
import com.example.mvvmfirestoreandroidapp.model.SampleModel;
import com.example.mvvmfirestoreandroidapp.viewmodel.SampleViewModel;

import timber.log.Timber;

public class MainFragment extends Fragment {

    View view;
    SampleViewModel sampleViewModel;
    TextView sampleString, sampleInt, sampleBoolean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        sampleString = view.findViewById(R.id.sampleString);
        sampleInt = view.findViewById(R.id.sampleInt);
        sampleBoolean = view.findViewById(R.id.sampleBoolean);

        sampleViewModel =  ViewModelProviders.of(this).get(SampleViewModel.class);
        sampleViewModel.getSampleData().observe(getActivity(), sampleModel -> {
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
        });
        return view;
    }
}
