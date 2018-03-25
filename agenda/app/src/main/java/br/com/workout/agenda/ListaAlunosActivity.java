package br.com.workout.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.workout.agenda.dao.AlunoDAO;
import br.com.workout.agenda.modelo.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //recupera o comportamento do oncreate que tem no app compat activity
        setContentView(R.layout.activity_lista_alunos); //R é um atalho para a pasta res, do projeto

        //Procuro o objeto do xml pelo id
        listaAlunos = (ListView) findViewById(R.id.Lista_Alunos);

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(position);
                Intent intentVaiProForm = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                intentVaiProForm.putExtra("aluno", aluno);
                startActivity(intentVaiProForm);
            }
        });

        registerForContextMenu(listaAlunos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.lista_novoAluno);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProForm = new Intent(ListaAlunosActivity.this, FormularioActivity.class); //Cria a intenção de mudar de activity
                startActivity(intentVaiProForm); //Pede para o android executar a intenção criada anteriormente
            }
        });
    }

    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos =  dao.buscaAlunos();
        dao.close();

        //Adcionando os alunos na listview
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);

        //Escolhendo o adptador para a view
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        //Faz a lista ser carregada no on resume para que ela seja sempre carregada de acordo com o fluxograma de cilclo de vida de activitys
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);

                AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
                dao.deleta(aluno);
                dao.close();

                Toast.makeText(ListaAlunosActivity.this, "Aluno "+aluno.getNome()+" foi deletado", Toast.LENGTH_SHORT).show();
                carregaLista();
                return false;
            }
        });
    }
}
