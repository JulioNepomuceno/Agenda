package com.julio_hortenciohotmail.agenda.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.julio_hortenciohotmail.agenda.model.Contato;

import java.util.ArrayList;

/**
 * Created by julio on 06/12/17.
 */

public class Conexao extends SQLiteOpenHelper
{
    private static final String DATABASE = "bdagenda";
    private static final int VERSION = 1;
    Context contexto;

    public Conexao(Context context) {
        super(context, DATABASE,null,VERSION);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {

        String contato = "CREATE TABLE contatos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL, telefone TEXT NOT NULL,celular TEXT NOT NULL, email TEXT NOT NULL)";
        banco.execSQL(contato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int oldVersion, int newVersion) {
        String contato = "DROP TABLE IF EXIST contatos";
        banco.execSQL(contato);
    }

    //Inserir contato
    public void insertContato(Contato contato){
        ContentValues vcontatos = new ContentValues();
        //pega os valores da da tela digitado pelo usuario
        vcontatos.put("nome",contato.getNome());
        vcontatos.put("telefone",contato.getTelefone());
        vcontatos.put("celular", contato.getCelular());
        vcontatos.put("email",contato.getEmail());

        //escreve no banco
        getWritableDatabase().insert("contatos", null, vcontatos);
        Toast.makeText(contexto, "Contato Cadastrado", Toast.LENGTH_SHORT).show();

    }
    //atualizar contato da lista
    public void update(Contato contato){
        ContentValues vcontatos = new ContentValues();

        vcontatos.put("nome",contato.getNome());
        vcontatos.put("telefone",contato.getTelefone());
        vcontatos.put("celular",contato.getCelular());
        vcontatos.put("email",contato.getEmail());

        String [] args = {contato.getId().toString()};
        getWritableDatabase().update("contatos", vcontatos,"id=?",args);
        Toast.makeText(contexto, "Contato Atualizado", Toast.LENGTH_SHORT).show();

    }
    //Retorna todos os contatos da lista
    public ArrayList<Contato> getListaContato(){
        String [] coluna = {"id","nome","telefone","celular", "email"};
        Cursor cursor = getWritableDatabase().query("contatos",coluna, null,null,null,null,null);

        ArrayList<Contato> contatoslist = new  ArrayList<Contato>();

        while(cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getLong(0));
            contato.setNome(cursor.getString(1));
            contato.setTelefone(cursor.getString(2));
            contato.setCelular(cursor.getString(3));
            contato.setEmail(cursor.getString(4));

            contatoslist.add(contato);
        }
        return  contatoslist;
    }

    //Deletar nota
    public void deletarContato(Contato contato){
        String [] args = {contato.getId().toString()};
        getWritableDatabase().delete("contatos","id=?",args);
    }

}
