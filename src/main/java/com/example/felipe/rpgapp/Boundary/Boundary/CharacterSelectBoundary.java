package com.example.felipe.rpgapp.Boundary.Boundary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.felipe.rpgapp.R;
import com.example.felipe.rpgapp.Util.AbstractAppCompatActivity;

public class CharacterSelectBoundary extends AbstractAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boundary_character_select);
        CreateToolbar();
    }

    @Override
    public void CreateToolbar() {
        Toolbar mToolbar = findViewById(R.id.tb_main);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        CreateNavigationDrawer(mToolbar,1);

    }
}
