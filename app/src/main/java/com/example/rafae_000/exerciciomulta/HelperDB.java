package com.example.rafae_000.exerciciomulta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rafae_000 on 27/10/2016.
 */
public class HelperDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String TABELA = "multa";    //nome da tabela
    private static final String DATABASE_NAME = "db_multa";   //nome do BD

    private static final String TABLE_CREATE = "create table " + TABELA + " (cnh varchar(10), placa varchar(8)," +
            " proprietario varchar(100), infracao varchar(100), " +
            " gravidade varchar(100), pontos varchar(100), " +
            "valor varchar(100), dataInfracao varchar(14));";


    HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

}