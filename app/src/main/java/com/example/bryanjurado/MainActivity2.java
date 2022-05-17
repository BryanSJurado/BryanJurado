package com.example.bryanjurado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText etNombre;
    private EditText etBase;

    private String apellido;
    private String exponente;
    private String numero;


    private int codigoRequerido=1;

    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.etNombre=findViewById(R.id.txtNombre2);
        this.etBase=findViewById(R.id.txtBase2);

        btnCerrar=findViewById(R.id.btnSalir);

        btnCerrar.setEnabled(false);
    }

    public void onClickSiguiente(View view){
        String nombre=etNombre.getText().toString();
        String base=etBase.getText().toString();

        if(!nombre.matches("") && !base.matches("")){
            Intent intent=new Intent(this, MainActivity3.class);

            //Enviar información desde otra activity
            intent.putExtra("key_nombre", nombre);
            intent.putExtra("key_base", base);


            startActivityForResult(intent, codigoRequerido);
        }else{
            Toast.makeText(this, "Rellenar campos obligatorios.", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickCerrar(View view){
        String nombre=etNombre.getText().toString();
        String base=etBase.getText().toString();


        if(!nombre.matches("") && !base.matches("")){

            Intent intent=new Intent();
            intent.setData(Uri.parse(nombre+"," + apellido+","+base+","+exponente+","+numero));


            setResult(Activity.RESULT_OK, intent);

            finish();
        }else{
            Toast.makeText(this, "Rellenar campos obligatorios.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Obtener los datos regresados desde la ventana hija.

        String informacion;
        informacion=data.getDataString();
        String[] datos=informacion.split(",");

        apellido=datos[0];
        exponente=datos[1];
        numero=datos[2];

        btnCerrar.setEnabled(true);

        etNombre.setEnabled(false);
        etBase.setEnabled(false);

    }
}