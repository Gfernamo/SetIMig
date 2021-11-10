package com.example.setimig;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class joc extends AppCompatActivity implements View.OnClickListener {

    Button atura, more;
    TextView punts,cartes;
    double puntsTotals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);
        more=findViewById(R.id.more);
        atura=findViewById(R.id.stop);
        punts=findViewById(R.id.punts);
        cartes=findViewById(R.id.cartes);
        atura.setOnClickListener(this);
        more.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (atura.getId() == view.getId()){
            aturaeljoc();
        }
        else if (view.getId() == more.getId())
        {
            treuCarta();
        }
    }

    private void treuCarta() {

        Random r = new Random();
        int numero;
        puntsTotals=Double.parseDouble(punts.getText().toString());
        if (puntsTotals>7.5)
        {
            aturaeljoc();
        }
        else {
            String text, cartanova;
            text = cartes.getText().toString();
            numero=r.nextInt(12)+1;
            while (numero==8||numero==9){
                numero=r.nextInt(12)+1;
            }
            cartanova = Integer.toString(numero);
            cartes.setText(text+"+"+cartanova);
            if (numero<8){
                puntsTotals=puntsTotals+numero;
            }
            else{
                puntsTotals=puntsTotals+0.5;
            }
            punts.setText(Double.toString(puntsTotals));
        }
    }

    private void aturaeljoc() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        if (puntsTotals<7.6){
            builder.setTitle("No has perdut!");
            builder.setMessage("Has acabat el joc! No has perdut");
        }
        else{
            builder.setTitle("Has perdut!");
            builder.setMessage("Has acabat el joc! Has perdut!");
        }

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(1);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}