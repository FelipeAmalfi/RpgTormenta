package com.example.felipe.rpgapp.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.felipe.rpgapp.Control.AbstractEntity;
import com.example.felipe.rpgapp.Entity.PlayerChar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Locale;


/**
 * Created by Felipe on 09/11/2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String NOME = "RpgSQL";
    private static final int Versao = 1;
    private SQLiteDatabase db = this.getWritableDatabase();
    private ContentValues values;


    public Database(Context context) {
        super(context, NOME, null, Versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CHARACTER(id integer primary key autoincrement, name text  unique not null, player text not null, age integer not null,appearance integer not null," +
                "raca text not null,classe text not null, story text, tibares int not null,level integer not null, exp text not null,banco int not null, descricao_aparencia text );");
        db.execSQL("CREATE TABLE ATTRIBUTE(id_reference integer primary key not null, F text not null, Bouns_F text, H text not null, Bouns_H text, R text not null,Bouns_R text" +
                ", A text not null,Bouns_A text, PdF text not null,Bouns_PdF text,Pv_mod int not null,Pm_mod int not null);");
        db.execSQL("CREATE TABLE FOCUS(id_reference integer primary key not null, Luz text not null, Bouns_Luz text, Ar text not null, Bouns_Ar text, Agua text not null, Bouns_Agua text" +
                ", Fogo text not null, Bouns_Fogo text, Terra text not null, Bouns_Terra text, Trevas text not null, Bouns_Trevas text);");
        db.execSQL("CREATE TABLE ADVANTAGE(id_vantagem primary key autoincrement,id_reference not null, vantagem text not null, type text not null);");
        db.execSQL("CREATE TABLE DISADVANTAGE(id_desvantagem primary key autoincrement,id_reference not null, desvantagem text not null, type text not null);");
        db.execSQL("CREATE TABLE EXPERTISE_REFERENCE(id_expertise primary key autoincrement,id_reference not null, expertise_name text not null, points integer not null);");
        db.execSQL("CREATE TABLE EXPERTISE(id_expertise primary key autoincrement,id_reference not null, expertise text not null, description text not null);");
        db.execSQL("CREATE TABLE SKILL(id_skill primary key autoincrement,id_reference not null, name text not null, requisition text not null,custo text not null, alcance text not null," +
                "duracao text not null, descricao text not null );");
        db.execSQL("CREATE TABLE BAG(id_item primary key autoincrement,id_reference not null, name text not null, qtd integer not null,obs_item text);");
        db.execSQL("CREATE TABLE EQUIPED_ITEM(id_item primary key autoincrement,id_reference not null, name text not null, qtd integer not null,obs_item text);");
        db.execSQL("CREATE TABLE FRIENDS(id_friend primary key autoincrement,id_reference not null, name text not null, place text not null,description text);");
        db.execSQL("CREATE TABLE EXTRA_NOTES(id_note primary key autoincrement,id_reference not null, title text not null, description text not null);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table CHARACTER;");
        db.execSQL("drop table ATTRIBUTE;");
        db.execSQL("drop table FOCUS;");
        db.execSQL("drop table ADVANTAGE;");
        db.execSQL("drop table DISADVANTAGE;");
        db.execSQL("drop table EXPERTISE_REFERENCE;");
        db.execSQL("drop table EXPERTISE;");
        db.execSQL("drop table SKILL;");
        db.execSQL("drop table BAG;");
        db.execSQL("drop table EQUIPED_ITEM;");
        db.execSQL("drop table FRIENDS;");
        db.execSQL("drop table EXTRA_NOTES;");
        onCreate(db);

    }

    //INSERT


    public boolean insertCharGeneric(AbstractEntity entity, String table) throws JSONException {
        values = new ContentValues();
        String jsonString = entity.toJSONString();
        JSONObject jsonObject = new JSONObject(jsonString);
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext())
        {
            String key = keys.next();
            Object value = jsonObject.get(key);

            if (value instanceof String)
                values.put(key,(String) value);

            if (value instanceof Integer)
                values.put(key,(Integer) value);

            if (value instanceof Float)
                values.put(key,(Float) value);
        }

        long result = db.insert(table, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }


    //SELECT

    public String createQuery(String table,String attribute){
        return String.format(Locale.US,"select * from %s where id_reference like '%s'",table, attribute);
    }


    public Cursor SelectChars() {
        return db.rawQuery("select * from CHARACTER", null);

    }
        public Cursor genericSelectReference(String query) {
          return db.rawQuery(query, null);

        }


    //DELETE

    public boolean deleteChar(String usuario) {

        long result = db.delete("CHARACTER ", "id = ? ", new String[]{usuario});
        if (result == -1)
            return false;
        else
            return true;

    }    public boolean deleteGeneric(String table,String id_reference) {

        long result = db.delete(table, "id_reference = ? ", new String[]{id_reference});
        if (result == -1)
            return false;
        else
            return true;
    }

    //UPDATE




}
