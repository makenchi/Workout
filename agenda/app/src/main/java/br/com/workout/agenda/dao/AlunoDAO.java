package br.com.workout.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.workout.agenda.modelo.Aluno;

/**
 * Created by Makenchi on 21/03/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper{

    public AlunoDAO(Context context) { //context pode ser um objeto activity
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        //Monta a estrutura dos dados
        dados.put("nome",aluno.getNome());
        dados.put("endereco",aluno.getEndereco());
        dados.put("telefone",aluno.getTelefone());
        dados.put("site",aluno.getSite());
        dados.put("nnota",aluno.getNota());

        //insere os dados
        db.insert("Alunos", null, dados);
    }
}