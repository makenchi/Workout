package br.com.workout.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() { //Criando o método que escuta o clique do botão
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Botao flutuante clicado", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                finish(); //Destroi a activity que foi criada
            }
        });

        Button botaoSalvar = (Button) findViewById(R.id.formulario_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() { //Criando o método que escuta o clique do botão
            @Override
            public void onClick(View view) { //Classe anônima que representa oq o botão vai fazer após ser clicado
                Toast.makeText(FormularioActivity.this, "Botao clicado", Toast.LENGTH_SHORT).show(); //ele espera a view alvo para aparecer o toast, valor do texto que vai aparecer, e tempo de duração do toast. por fim o .show é para ele aparecer
                finish(); //Destroi a activity que foi criada
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
