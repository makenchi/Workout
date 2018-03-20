package br.com.workout.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by Makenchi on 20/03/2018.
 */

public class FormularioHelper {

    public FormularioHelper(FormularioActivity activity){

        EditText campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        EditText campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        EditText campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        EditText campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        RatingBar campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
    }
}
