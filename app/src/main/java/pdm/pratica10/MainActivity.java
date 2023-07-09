package pdm.pratica10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonInsertClick(View view) {
        String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
        String grade = ((EditText) findViewById(R.id.edit_grade)).getText().toString();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(name, grade);
        editor.apply();
        Toast.makeText(this, "Salvo: " + name, Toast.LENGTH_SHORT).show();
    }

    public void buttonQueryClick(View view) {
        String name = ((EditText)findViewById(R.id.edit_name)).getText().toString();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        String grade = prefs.getString(name, "[Não encontrado]");
        ((EditText)findViewById(R.id.edit_grade)).setText(grade);
    }

    public void buttonUpdateClick(View view) {
        String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
        String grade = ((EditText) findViewById(R.id.edit_grade)).getText().toString();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Verifica se o nome existe nas preferências antes de atualizar
        if (prefs.contains(name)) {
            editor.putString(name, grade);
            editor.apply();
            Toast.makeText(this, "Atualizado: " + name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nome não encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonRemoveClick(View view) {
        String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Verifica se o nome existe nas preferências antes de remover
        if (prefs.contains(name)) {
            editor.remove(name);
            editor.apply();
            Toast.makeText(this, "Removido: " + name, Toast.LENGTH_SHORT).show();
            ((EditText)findViewById(R.id.edit_grade)).setText("");
        } else {
            Toast.makeText(this, "Nome não encontrado", Toast.LENGTH_SHORT).show();
        }
    }





}