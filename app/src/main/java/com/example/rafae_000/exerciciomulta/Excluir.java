package com.example.rafae_000.exerciciomulta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Excluir extends AppCompatActivity implements View.OnClickListener {
    private Button btnConsultaAltera;
    Multa multa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);
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
    public void excluirMultas(View view) {
        if (new MultaDAO(getApplicationContext()).delete(((EditText) findViewById(R.id.cnh)).getText().toString()))
            Toast.makeText(this,"Multa Excluida com sucesso",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Erro ao tentar excluir",Toast.LENGTH_LONG).show();
        limparCampos();
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
