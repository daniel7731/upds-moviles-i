package com.daniel.storage.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.daniel.storage.datos.AdminSQLiteOpenHelper;

public class CreateApapter implements View.OnClickListener {

    private Context context;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    public CreateApapter(Context context, EditText et1, EditText et2, EditText et3){
        this.context = context;
        this.et1=et1;
        this.et2=et2;
    }
    @Override
    public void onClick(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        bd.insert("articulos", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(context, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }
}
