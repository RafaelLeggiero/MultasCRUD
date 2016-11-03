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
        //insere Multas no ContentValues
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
    public Multa select(String cnh) {
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
        String[] selectionArgs = new String[]{cnh};
        Multa multa=new Multa();
        Cursor cursor = db.query(HelperDB.TABELA, null, "cnh = ?", selectionArgs, null, null, null);
        if (cursor.getCount()>0)
        {
            cursor.moveToNext();
            multa.setCnh(cnh);
            //exemplos com os indices dos campos
            multa.setPlaca(cursor.getString(1));
            multa.setProprietario(cursor.getString(2));
            multa.setInfracao(cursor.getString(3));
            multa.setGravidade(cursor.getString(4));
            multa.setPontos(cursor.getString(5));
            multa.setValor(cursor.getString(6));
            multa.setDataInfracao(cursor.getString(7));
            return multa;
        }
        return null;
    }
    public Multa selectFiltro(String informacao, String tipo) {
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
     //   String[] selectionArgs = new String[]{informacao};
        Multa multa=new Multa();
       // Cursor cursor = db.query(HelperDB.TABELA, null,"tipo = ?", selectionArgs, null, null, null);
        Cursor cursor = db.rawQuery("SELECT * FROM multa WHERE "+ tipo+"="+informacao,null);
        if (cursor.getCount()>0)
        {
            cursor.moveToNext();
            //exemplos com os indices dos campos
            multa.setCnh(cursor.getString(0));
            multa.setPlaca(cursor.getString(1));
            multa.setProprietario(cursor.getString(2));
            multa.setInfracao(cursor.getString(3));
            multa.setGravidade(cursor.getString(4));
            multa.setPontos(cursor.getString(5));
            multa.setValor(cursor.getString(6));
            multa.setDataInfracao(cursor.getString(7));
            return multa;
        }
        return null;
    }
    public boolean update(Multa multa) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        ContentValues values = new ContentValues();
        values.put("cnh", multa.getCnh());
        values.put("dataInfracao", multa.getDataInfracao());
        values.put("placa", multa.getPlaca());
        values.put("proprietario",multa.getProprietario());
        values.put("infracao",multa.getInfracao());
        values.put("gravidade", multa.getGravidade());
        values.put("pontos", multa.getPontos());
        values.put("valor", multa.getValor());
        String[] whereArgs = new String[]{multa.getCnh()};
        return (db.update(HelperDB.TABELA,values , "cnh=?" ,whereArgs) > 0);
    }

    public boolean delete(String cnh) {
        SQLiteDatabase db = new HelperDB(ctx).getWritableDatabase(); //conecta e abre o banco para gravação
        String[] whereArgs = new String[]{cnh};
        return (db.delete(HelperDB.TABELA, "cnh=?", whereArgs) > 0);
    }


    public List<Multa> listarMultas() {
        SQLiteDatabase db = new HelperDB(ctx).getReadableDatabase(); //conecta e abre o banco para leitura
        List<Multa> lista = new ArrayList<Multa>();

        Cursor cursor = db.query(HelperDB.TABELA, null, null, null, null, null,"cnh");
        while (cursor.moveToNext()) {
            Multa Multa = new Multa();
            //exemplos capturando o indice dos campos a partir do nome
            Multa.setCnh(cursor.getString(cursor.getColumnIndex("cnh")));
            Multa.setPlaca(cursor.getString(cursor.getColumnIndex("placa")));
            Multa.setProprietario(cursor.getString(cursor.getColumnIndex("proprietario")));
            Multa.setInfracao(cursor.getString(cursor.getColumnIndex("infracao")));
            Multa.setGravidade(cursor.getString(cursor.getColumnIndex("gravidade")));
            Multa.setPontos(cursor.getString(cursor.getColumnIndex("pontos")));
            Multa.setValor(cursor.getString(cursor.getColumnIndex("valor")));
            Multa.setDataInfracao(cursor.getString(cursor.getColumnIndex("dataInfracao")));
            //adiciona a Multa na lista
            lista.add(Multa);
        }
        return lista;
    }

}
