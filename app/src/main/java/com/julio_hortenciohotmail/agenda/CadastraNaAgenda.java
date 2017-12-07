package com.julio_hortenciohotmail.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.julio_hortenciohotmail.agenda.model.Contato;
import com.julio_hortenciohotmail.agenda.util.Conexao;

public class CadastraNaAgenda extends AppCompatActivity {


    EditText editNome, editTelefone, editCelular, editEmail;

    Button btCadastra;

    Contato editarContato, contato;

    Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_na_agenda);

        contato = new Contato();

        conexao = new Conexao(CadastraNaAgenda.this);

        Intent intent = getIntent();
        editarContato = (Contato) intent.getSerializableExtra("contato-selecionado");

        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editCelular = (EditText) findViewById(R.id.editCelular);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btCadastra = (Button) findViewById(R.id.btcadastra);

        if(editarContato !=null){
            btCadastra.setText("Alterar Contato");

            editNome.setText(editarContato.getNome());
            editTelefone.setText(editarContato.getTelefone());
            editCelular.setText(editarContato.getCelular());
            editEmail.setText(editarContato.getEmail());

            contato.setId(editarContato.getId());
        }else{
            btCadastra.setText("Salvar Contato");
        }

        btCadastra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                contato.setNome(editNome.getText().toString());
                contato.setTelefone(editTelefone.getText().toString());
                contato.setCelular(editCelular.getText().toString());
                contato.setEmail(editEmail.getText().toString());

                if (btCadastra.getText().toString().equals("Salvar Contato")){
                    conexao.insertContato(contato);
                    editNome.setText("");
                    editTelefone.setText("");
                    editCelular.setText("");
                    editEmail.setText("");

                    conexao.close();
                    telaListagem(btCadastra);
                }
                else{
                    conexao.update(contato);
                    editNome.setText("");
                    editTelefone.setText("");
                    editCelular.setText("");
                    editEmail.setText("");

                    conexao.close();
                    telaListagem(btCadastra);

                }

            }

        });

    }
    public void telaListagem(View Botao){
        Intent intencao = new Intent(this, ContatoLista.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }
    public void voltarTelaInicial(View Botao){
        Intent intencao = new Intent(this, MainActivity.class); //intenção ir para a tela sobre
        startActivity(intencao); // starta a intenção
        this.finish(); // finaliza a activity
    }
}
