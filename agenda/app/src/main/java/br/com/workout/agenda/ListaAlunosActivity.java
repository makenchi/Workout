package br.com.workout.agenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //recupera o comportamento do oncreate que tem no app compat activity
        setContentView(R.layout.activity_lista_alunos); //R é um atalho para a pasta res, do projeto

        //Criando os dados da lista de alunos
        String[] alunos = {"Daniel","Ronald","Cafu","Vinicius Jr"};

        //Procuro o objeto do xml pelo id
        ListView listaAlunos = (ListView) findViewById(R.id.Lista_Alunos);

        //Adcionando os alunos na listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);

        //Escolhendo o adptador para a view
        listaAlunos.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
