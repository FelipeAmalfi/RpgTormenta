package com.example.felipe.rpgapp.Boundary.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felipe.rpgapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquippedItemFragment extends Fragment {


    public EquippedItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipped_item2, container, false);
    }

}
