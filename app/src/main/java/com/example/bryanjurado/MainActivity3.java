package com.example.bryanjurado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private EditText etNombre;
    private android.widget.EditText etBase;

    private EditText etApellido;
    private EditText etExponente;
    private EditText etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etNombre = findViewById(R.id.txtNombre3);

        String nombre = getIntent().getStringExtra("key_nombre");
        etNombre.setText(nombre.toUpperCase(Locale.ROOT));

        etBase = findViewById(R.id.txtBase3);

        String base = getIntent().getStringExtra("key_base");
        etBase.setText(base);

        etApellido=findViewById(R.id.txtApellido3);
        etExponente=findViewById(R.id.txtExponente3);
        etNumero=findViewById(R.id.txtFactorial3);

        etNombre.setEnabled(false);
        etBase.setEnabled(false);
    }

    public void onClickCerrar(View view){
        String apellido=etApellido.getText().toString();
        String exponente=etExponente.getText().toString();
        String numero=etNumero.getText().toString();



        if(!apellido.matches("") && !exponente.matches("") && !numero.matches("")){
            // Regresar el item seleccionado.

            Intent intent=new Intent();
            intent.setData(Uri.parse(apellido+","+exponente+","+numero));


            setResult(Activity.RESULT_OK, intent);

            finish();
        }else{
            Toast.makeText(this, "Rellenar campos obligatorios.", Toast.LENGTH_LONG).show();
        }
    }
}