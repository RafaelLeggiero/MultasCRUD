package com.example.rafae_000.exerciciomulta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Alterar extends AppCompatActivity  implements View.OnClickListener{
private Button btnConsultaAltera;
Multa multa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        btnConsultaAltera = (Button)findViewById(R.id.consultar);
        btnConsultaAltera.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.consultar:
                    multa = new MultaDAO(getApplicationContext()).select(((EditText) findViewById(R.id.cnh)).getText().toString());
                    if (multa != null) {
                        ((EditText) findViewById(R.id.dataInfracao)).setText(multa.getDataInfracao());
                        ((EditText) findViewById(R.id.placa)).setText(multa.getPlaca());
                        ((EditText) findViewById(R.id.proprietario)).setText(multa.getProprietario());
                        ((EditText) findViewById(R.id.infracao)).setText(multa.getInfracao());
                        ((EditText) findViewById(R.id.gravidade)).setText(multa.getGravidade());
                        ((EditText) findViewById(R.id.pontos)).setText(multa.getPontos());
                        ((EditText) findViewById(R.id.valor)).setText(multa.getValor());
                        break;
                    }else
                        Toast.makeText(this,"Multa não encontrada nesta data",Toast.LENGTH_LONG).show();
            }
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void Voltar(View view) {
        finish();
    }

    public void alterarMultas(View view) {
            multa = new Multa();
            multa.setCnh(((EditText) findViewById(R.id.cnh)).getText().toString());
            multa.setDataInfracao(((EditText) findViewById(R.id.dataInfracao)).getText().toString());
            multa.setPlaca(((EditText) findViewById(R.id.placa)).getText().toString());
            multa.setProprietario(((EditText) findViewById(R.id.proprietario)).getText().toString());
            multa.setInfracao(((EditText) findViewById(R.id.infracao)).getText().toString());
            multa.setGravidade(((EditText) findViewById(R.id.gravidade)).getText().toString());
            multa.setPontos(((EditText) findViewById(R.id.pontos)).getText().toString());
            multa.setValor(((EditText) findViewById(R.id.valor)).getText().toString());
            if (new MultaDAO(getApplicationContext()).update(multa)) {
                Toast.makeText(this, "Multa Alterada com sucesso", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Não foi possivel realizar a alteração", Toast.LENGTH_LONG).show();
            }
    }

    public void limparCampos(){
        ((EditText) findViewById(R.id.cnh)).setText("");
        ((EditText) findViewById(R.id.placa)).setText("");
        ((EditText) findViewById(R.id.proprietario)).setText("");
        ((EditText) findViewById(R.id.infracao)).setText("");
        ((EditText) findViewById(R.id.gravidade)).setText("");
        ((EditText) findViewById(R.id.pontos)).setText("");
        ((EditText) findViewById(R.id.valor)).setText("");
        ((EditText) findViewById(R.id.dataInfracao)).setText("");
    }
}
