package com.example.felipe.rpgapp.Boundary.Boundary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.felipe.rpgapp.Boundary.Fragment.BagItemFragment;
import com.example.felipe.rpgapp.Boundary.Fragment.EquippedItemFragment;
import com.example.felipe.rpgapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemBoundary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boundary_item);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (item.getItemId()){
                    case R.id.action_bag:
                        transaction.replace(R.id.content_empty,new BagItemFragment()).commit();
                        return true;

                    case R.id.action_equipped:
                        transaction.replace(R.id.content_empty,new EquippedItemFragment()).commit();
                        return true;

                    default:
                        return true;
                }
            }
        });
    }


}
