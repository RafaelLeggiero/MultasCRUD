package com.example.rafae_000.exerciciomulta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultaFiltro extends AppCompatActivity implements View.OnClickListener {
    private Button btnConsultaAltera;
    public String tipo="";
    Multa multa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_filtro);
        btnConsultaAltera = (Button) findViewById(R.id.consultar);
        btnConsultaAltera.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        try {
            int operador = ((RadioGroup) findViewById(R.id.filtro)).getCheckedRadioButtonId();
            if (operador == R.id.radCNH) {
                tipo = "cnh";
            } else if (operador == R.id.radPlaca) {
                tipo = "placa";
            } else if (operador == R.id.radDataInfracao) {
                tipo = "dataInfracao";
            }
            switch (v.getId()){
                case R.id.consultar:
                   multa = new MultaDAO(getApplicationContext()).selectFiltro(((EditText) findViewById(R.id.informacao)).getText().toString(),tipo);
                    if (multa != null) {
                        ((TextView) findViewById(R.id.resp)).setText("CNH: "+multa.getCnh() +"\nPlaca:"+ multa.getPlaca()+
                                "\nProprietario: " + multa.getProprietario() + "\nInfracao: " + multa.getInfracao()+
                                "\nGravidade: " + multa.getGravidade() + "\nPontos: " + multa.getPontos()+
                                "\nValor: " + multa.getValor() + "\nData da Infração: " + multa.getValor());
                        break;
                    }else
                        Toast.makeText(this,"Multa não encontrada",Toast.LENGTH_LONG).show();
                    limparCampos();
            }
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void limparCampos(){
        ((TextView) findViewById(R.id.resp)).setText("");
    }
}
