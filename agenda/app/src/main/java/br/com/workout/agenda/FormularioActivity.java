package br.com.workout.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.workout.agenda.dao.AlunoDAO;
import br.com.workout.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");

        if (aluno != null){
            helper.preencheForm(aluno);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuFormularioOk:
                Aluno aluno = helper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);

                //Verifico se é um novo aluno ou se é um aluno para ser editado
                if (aluno.getId() != null){
                    dao.edita(aluno);
                }
                else {
                    dao.insere(aluno);
                }

                dao.close();

                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome().toString() + " salvo!", Toast.LENGTH_SHORT).show(); //ele espera a view alvo para aparecer o toast, valor do texto que vai aparecer, e tempo de duração do toast. por fim o .show é para ele aparecer

                finish(); //Destroi a activity que foi criada
                break; //quebra a estrutura de case
        }

        return super.onOptionsItemSelected(item);
    }
}
