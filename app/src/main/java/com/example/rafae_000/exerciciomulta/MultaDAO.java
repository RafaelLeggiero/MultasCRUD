package com.example.rafae_000.exerciciomulta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae_000 on 27/10/2016.
 */
public class MultaDAO {
    private Context ctx;

    public MultaDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(Multa multa) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        //insere Pessoas no ContentValues
        ContentValues values = new ContentValues();
        values.put("cnh", multa.getCnh());
        values.put("placa", multa.getPlaca());
        values.put("proprietario",multa.getProprietario());
        values.put("infracao",multa.getInfracao());
        values.put("gravidade", multa.getGravidade());
        values.put("pontos", multa.getPontos());
        values.put("valor", multa.getValor());
        values.put("dataInfracao", multa.getDataInfracao());
        //insert retorna o ID da linha inserido ou -1 para erro
        //se der erro retorna FALSE senão TRUE
        return (db.insert(HelperDB.TABELA, null, values) > 0);
    }


}
