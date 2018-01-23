package com.example.felipe.rpgapp.Util;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.felipe.rpgapp.Boundary.Boundary.FriendsBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.NotesBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.ItemBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.SkillBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.ExpertiseBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.PrincipalCharBoundary;
import com.example.felipe.rpgapp.Boundary.Boundary.VDBoundary;
import com.example.felipe.rpgapp.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.felipe.rpgapp.Util.CustomTypeFace.getFontSingleTxt;

/**
 * Created by Felipe on 04/01/2018.
 */

public abstract class AbstractAppCompatActivity extends AppCompatActivity {
    public abstract void CreateToolbar();


    public void CreateNavigationDrawer(android.support.v7.widget.Toolbar toolbar, int identifier) {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorDark)
                .withProfileImagesVisible(true)
                .addProfiles(new ProfileDrawerItem().withEmail("Nyx@tormenta.com").withName("Nyx"))
                .withEmailTypeface(getFontSingleTxt(this,1))
                .withNameTypeface(getFontSingleTxt(this,1))
                .build();


        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSliderBackgroundColor(Color.WHITE)
                .withSelectedItem(identifier)
                .withCloseOnClick(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        CreatePrimaryItem(1, "Principal", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.principal),
                        CreatePrimaryItem(2, "Batalha", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.battle),
                        new SectionDrawerItem().withName("Informações extras"),
                        CreateSecondaryItem(3, "Vantagens e Desvantagens", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.usericon),
                        CreateSecondaryItem(4, "Perícias", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.expertise),
                        CreateSecondaryItem(5, "Magias", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.magic),
                        CreateSecondaryItem(6, "Itens", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.usericon),
                        CreateSecondaryItem(7, "Personagens conhecidos", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.usericon),
                        CreateSecondaryItem(8, "Anotações", Color.BLACK, Color.BLACK, getResources().getColor(R.color.colorOrange), R.drawable.usericon)

                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                switch ((int) drawerItem.getIdentifier()) {
                    case 1:
                        createIntentAbs(PrincipalCharBoundary.class);
                        break;
                    case 2:
                        break;
                    case 3:
                        createIntentAbs(VDBoundary.class);
                        break;
                    case 4:
                        createIntentAbs(ExpertiseBoundary.class);
                        break;
                    case 5:
                        createIntentAbs(SkillBoundary.class);
                        break;
                    case 6:
                        createIntentAbs(ItemBoundary.class);
                        break;
                    case 7:
                        createIntentAbs(FriendsBoundary.class);
                        break;
                    case 8:
                        createIntentAbs(NotesBoundary.class);
                        break;
                }


                return true;
            }
        }).build();
    }


    public SecondaryDrawerItem CreateSecondaryItem(int identifier, String name, int textColor, int selectedTextColor, int selectedColor, int icon) {
        return new SecondaryDrawerItem()
                .withIdentifier(identifier)
                .withName(name)
                .withTextColor(textColor)
                .withSelectedTextColor(selectedTextColor)
                .withSelectedColor(selectedColor)
                .withIcon(icon)
                .withTypeface(getFontSingleTxt(this,1));

    }

    public PrimaryDrawerItem CreatePrimaryItem(int identifier, String name, int textColor, int selectedTextColor, int selectedColor, int icon) {
        return new PrimaryDrawerItem()
                .withIdentifier(identifier)
                .withName(name)
                .withTextColor(textColor)
                .withSelectedTextColor(selectedTextColor)
                .withSelectedColor(selectedColor)
                .withIcon(icon)
                .withTypeface(getFontSingleTxt(this,1));

    }

    public void createIntentAbs(Class classe) {
        Intent intent = new Intent();
        intent.setClass(this, classe);
        startActivity(intent);
    }

}
