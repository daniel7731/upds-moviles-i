package com.daniel.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daniel.helloworld.negocio.Matematicas;

public class OperacionesActivity extends AppCompatActivity {

    private TextView resultado;
    private EditText edt1;
    private EditText edt2;
    private Button btn;
    private CheckBox ch1;

    private CheckBox ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operaciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn2);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        resultado = findViewById(R.id.tv1);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String  s1 =  edt1.getText().toString();
                    String  s2 =  edt2.getText().toString();
                    int a = Integer.parseInt(s1);
                    int b = Integer.parseInt(s2);

                    Matematicas.multiplicar(a,b);
                    Matematicas.dividir(a,b);
                }catch (Exception e){

                }

            }
        });
    }
}