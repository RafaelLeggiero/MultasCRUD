package com.example.rafae_000.exerciciomulta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCad, btnLista,btnAltera,btnExcluir,btnPesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCad = (Button)findViewById(R.id.btnCadastrar);
        btnLista = (Button)findViewById(R.id.btnListar);
        btnAltera = (Button)findViewById(R.id.btnAltera);
        btnExcluir = (Button)findViewById(R.id.btnExcluir);
        btnPesquisa = (Button)findViewById(R.id.btnConsultar);
        btnCad.setOnClickListener(this);
        btnLista.setOnClickListener(this);
        btnAltera.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);
        btnPesquisa.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.btnCadastrar) {
                Intent myIntent = new Intent(getApplicationContext(), Cadastrar.class);
                startActivity(myIntent);
            } else if (v.getId() == R.id.btnListar) {
                Intent myIntent = new Intent(getApplicationContext(), ListarMultas.class);
                startActivity(myIntent);
            } else if (v.getId() == R.id.btnAltera) {
                Intent myIntent = new Intent(getApplicationContext(), Alterar.class);
                startActivity(myIntent);
            } else if (v.getId() == R.id.btnExcluir) {
                Intent myIntent = new Intent(getApplicationContext(), Excluir.class);
                startActivity(myIntent);
            } else if (v.getId() == R.id.btnConsultar) {
                Intent myIntent = new Intent(getApplicationContext(), ConsultaFiltro.class);
                startActivity(myIntent);
            }
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
