package com.example.rafae_000.exerciciomulta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {
    Multa multa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
    }

    public void CadastrarMulta(View view) {
        multa = new Multa();
        multa.setCnh(((EditText) findViewById(R.id.cnh)).getText().toString());
        multa.setPlaca(((EditText) findViewById(R.id.placa)).getText().toString());
        multa.setProprietario(((EditText) findViewById(R.id.proprietario)).getText().toString());
        multa.setInfracao(((EditText) findViewById(R.id.infracao)).getText().toString());
        multa.setGravidade(((EditText) findViewById(R.id.gravidade)).getText().toString());
        multa.setPontos(((EditText) findViewById(R.id.pontos)).getText().toString());
        multa.setValor(((EditText) findViewById(R.id.valor)).getText().toString());
        multa.setDataInfracao(((EditText) findViewById(R.id.dataInfracao)).getText().toString());
        if (new MultaDAO(getApplicationContext()).insert(multa)) { multa.setCnh(((EditText) findViewById(R.id.cnh)).getText().toString());
            multa.setPlaca(((EditText) findViewById(R.id.placa)).getText().toString());
            multa.setProprietario(((EditText) findViewById(R.id.proprietario)).getText().toString());
            multa.setInfracao(((EditText) findViewById(R.id.infracao)).getText().toString());
            multa.setGravidade(((EditText) findViewById(R.id.gravidade)).getText().toString());
            multa.setPontos(((EditText) findViewById(R.id.pontos)).getText().toString());
            multa.setValor(((EditText) findViewById(R.id.valor)).getText().toString());
            multa.setDataInfracao(((EditText) findViewById(R.id.dataInfracao)).getText().toString());
            limparCampos();
            Toast.makeText(getApplicationContext(), "Multa Cadastrada !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, verifique os dados.", Toast.LENGTH_SHORT).show();
        }
    }


    public void Voltar(View view) {
        finish();
    }

    public void listarMultas(View view) {
        Intent myIntent2 = new Intent(getApplicationContext(), ListarMultas.class);
        startActivity(myIntent2);
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
