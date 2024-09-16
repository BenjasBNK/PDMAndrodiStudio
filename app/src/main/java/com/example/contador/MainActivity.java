package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.bntclick);
        text = findViewById(R.id.textView);

        button.setText("vai clica");
        text.setText("Me deu nada?");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b=(Button) view;
                b.setText("Clique Para Dar um Real");
                i++;
                text.setText("me deu " + i + " Real");



            }
        });



    }
}