package com.example.rafae_000.exerciciomulta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarMultas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_multas);

        List<Multa> multas = new MultaDAO(getApplicationContext()).listarMultas();
        int i = 0;
        if (multas.size()>0){
            String dados[]=new String[multas.size()];
            while (i < multas.size()) {
                Multa a = multas.get(i);
                dados[i] = "CNH: " + a.getCnh() +"\nPlaca: "+ a.getPlaca() +
                "\nProprietario: " + a.getProprietario()+"\nInfraçao:"+a.getInfracao()+
                "\nGravidade: "+a.getGravidade()+"\nPontos: "+a.getPontos()+
                "\nValor: "+a.getValor()+"\nData da Infração: "+a.getDataInfracao();
                i++;
            }
            ArrayAdapter<String> myadapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.item_list,
                    R.id.item_list,
                    dados);
            ListView lista = (ListView)findViewById(R.id.listview);
            lista.setAdapter(myadapter);
        }
        else
            Toast.makeText(getApplicationContext(), "Banco de dados vazio", Toast.LENGTH_LONG).show();
    }
}
