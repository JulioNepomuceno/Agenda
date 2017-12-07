package com.julio_hortenciohotmail.agenda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //------------------BOTÃO SOBRE-------------\\
    public void trataEventoBotaoTelaSobre(View Botao)
    {
        Intent intencao = new Intent(this, TelaSobre.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }

    public void trataEventoBotaoTelaCadastra(View Botao){
        Intent intencao = new Intent(this, CadastraNaAgenda.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }

    public void trataEventoBotaoTelaLista(View Botao){
        Intent intencao = new Intent(this, ContatoLista.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }



    //------------------BOTÃO SAIR-------------\\
    public void trataEventoBotaoSair(View Botao)
    {

        this.finish(); // fecha a aplicação


    }


}
