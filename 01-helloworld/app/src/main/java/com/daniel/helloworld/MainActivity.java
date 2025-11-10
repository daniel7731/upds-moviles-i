package com.daniel.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daniel.helloworld.negocio.Matematicas;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText text1;
    private EditText text2;
    private TextView txt;

    private RadioButton rb1;

    private RadioButton rb2;

    private  static String formatear(int r){
        return String.format("Resultado es : %d.",r);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Toast noti=null;
        if (item.getItemId() == R.id.opcion1){
            noti =  Toast.makeText(this,"",Toast.LENGTH_LONG);
            noti.show();
            return true;
        }
        if( item.getItemId() == R.id.opcion2){

            Intent  intent = new Intent(this, OperacionesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.button);
        text1  = findViewById(R.id.num1);
        text2  = findViewById(R.id.num2);
        txt    = findViewById(R.id.resultado);
        rb1    = findViewById(R.id.rb1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String  s1 =  text1.getText().toString();
                    String  s2 =  text2.getText().toString();
                    int a = Integer.parseInt(s1);
                    int b = Integer.parseInt(s2);
                    int r=0;
                    if ( rb1.isChecked()){

                       r=  Matematicas.sumar(a,b);
                    }else{
                        r=  Matematicas.restar(a,b);
                    }
                    String s= formatear(r);
                    txt.setText(s);
                }catch (Exception e){
                        e.printStackTrace();
                }

            }
        });
    }
}