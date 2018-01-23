package com.example.felipe.rpgapp.Boundary.Boundary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.felipe.rpgapp.R;

import static com.example.felipe.rpgapp.Util.CustomTypeFace.overrideFonts;

public class PrincipalCharBoundary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boundary_principal);
        overrideFonts(this,getWindow().getDecorView().getRootView(),1);
    }
}
