package com.julio_hortenciohotmail.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by julio on 02/12/17.
 */

public class TelaSobre extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }
    //---------------------------BOTÃO SAIR PARA TELA PRINCIPAL------------\\
    public void trataEventoBotaoSairSobre(View Botao)
    {

        Intent intencao = new Intent(this, MainActivity.class);//Intenção ir para a tela principal
        startActivity(intencao);// starta a intenção
        this.finish();// fecha esta tela

    }


}
