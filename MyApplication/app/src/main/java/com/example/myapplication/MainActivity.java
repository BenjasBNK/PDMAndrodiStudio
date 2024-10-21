package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;

    EditText editTextNome, editTextEmail, editTextDNsc;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome=findViewById(R.id.editTextNome);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextDNsc=findViewById(R.id.editTextDataNasc);
        button=findViewById(R.id.ButtonCadastrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome=editTextNome.getText().toString();
                String email=editTextEmail.getText().toString();

                ContentValues cv=new ContentValues();
                cv.put("nome",nome);
                cv.put("emial",email);
                //database.execSQL("INSERT INTO meubd(nome,email) VALUES(\""+nome+"\")");
                long status=database.insert(  "pessoas",  null,cv);

                if (status>0){
                    Toast.makeText(getApplicationContext(), "Usario inserdio com suscesso", Toast.LENGTH_LONG);
                }else {
                    Toast.makeText(getApplicationContext(), "Errona inserçaõ", Toast.LENGTH_LONG).show();
                }


            }
        });


        database= openOrCreateDatabase("meubd",MODE_PRIVATE,  null);
        database.execSQL("CREATE TABLE pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome varchar, email varchar,dtnasc varchar)");

    }
}


