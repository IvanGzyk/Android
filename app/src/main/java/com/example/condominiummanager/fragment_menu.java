package com.example.condominiummanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_menu extends Fragment {
    Button sair;
    Intent intent;

    public fragment_menu(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View frag = inflater.inflate(R.layout.fragment_menu, container, false);

        intent = new Intent(getActivity(), MainActivity.class);
        sair = (Button) frag.findViewById(R.id.sair);

        sair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                frag.getContext().startActivity(intent);
            }
        });
        return frag;
    }
}
