package com.julio_hortenciohotmail.agenda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.julio_hortenciohotmail.agenda.model.Contato;
import com.julio_hortenciohotmail.agenda.util.Conexao;

import java.util.ArrayList;

public class ContatoLista extends AppCompatActivity {
    ListView listaContato;

    Conexao conexao;

    ArrayList<Contato> listViewContatos;

    Contato contato;

    ArrayAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_lista);

        listaContato = (ListView) findViewById(R.id.listViewContato);
        registerForContextMenu(listaContato);

        //Realiza a selção no content ao clicar em algum item
        listaContato.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Contato contatoSelecionada = (Contato) adapter.getItemAtPosition(posicao);

                Intent intent = new Intent(ContatoLista.this, CadastraNaAgenda.class);
                intent.putExtra("contato-selecionado", contatoSelecionada);
                startActivity(intent);
            }
        });

        //Configura o click longo no adapter para função delete
        listaContato.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
                contato = (Contato) adapter.getItemAtPosition(posicao);
                return false;
            }
        });
    }

    public void trataEventoBotaoTelaNovoContato(View Botao){
        Intent intencao = new Intent(this, CadastraNaAgenda.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }

    //Menu de Contexto para o botão de click longo
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        //Cria as ações do botão de click longo
        //Texto que sera exibido nas opções do botão
        MenuItem menuDelete = menu.add("Excluir Contato");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                conexao = new Conexao(ContatoLista.this);
                conexao.deletarContato(contato);
                conexao.close();
                loadContato();
                return true;
            }
        });
    }
    //Meotodo para carregar Notas
    protected void onResume(){
        super.onResume();
        loadContato();
    }
    //Exibe o banco no listview
    public void loadContato(){
        conexao = new Conexao(ContatoLista.this);
        listViewContatos = conexao.getListaContato();
        conexao.close();

        if (listViewContatos != null){


            adapter = new ArrayAdapter<Contato>(ContatoLista.this, android.R.layout.simple_list_item_1, listViewContatos);
            listaContato.setAdapter(adapter);
        }

    }

    public void voltarTelaInicial2(View Botao){
        Intent intencao = new Intent(this, MainActivity.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }

}
