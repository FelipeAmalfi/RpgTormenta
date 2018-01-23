package com.example.felipe.rpgapp.Util;


import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Trabalho on 2/21/2017.
 */

public class CustomTypeFace
{
    private static final String FONT_MEDIEVAL = "fonts/medieval.otf";



    public static final Typeface getFontSingleTxt(Context assets, int font)
    {
        return Typeface.createFromAsset(assets.getAssets(), SelectFont(font));
    }


    public static void overrideFonts(final Context context, final View v, int font) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideFonts(context, child,font);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), SelectFont(font)));
                ((TextView) v).setTextSize(12);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String SelectFont(int id){
        switch (id){
            case 1:
                return FONT_MEDIEVAL;
            default:
                return FONT_MEDIEVAL;
        }
    }
}
