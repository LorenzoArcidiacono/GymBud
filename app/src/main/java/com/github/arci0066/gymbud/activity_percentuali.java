package com.github.arci0066.gymbud;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class activity_percentuali extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText totale_txt;
    TextView risultato_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentuali);
        Button btn = findViewById(R.id.percentuali_btn);
        btn.setOnClickListener(this);

        totale_txt = findViewById(R.id.percentuali_input_text);
        risultato_text = findViewById(R.id.percentuali_txt);

        //Caso in cui sia lanciato da MassimaliActivity
        String weightExtra = getIntent().getStringExtra("weight_massimali");
        if(weightExtra != null){
            weightExtra=weightExtra.replace(" Kg","");
            float peso_kg = Float.parseFloat(weightExtra);

            totale_txt.setText(weightExtra);

            String risultati = calculatePercentage(peso_kg);
            risultato_text.setText(risultati);
        }
    }

    @Override
    public void onClick(View view) {

        String peso_str;
        peso_str = String.valueOf(totale_txt.getText());

        if (peso_str.isEmpty()) {
            risultato_text.setText("Errore, digitare il peso desiderato.");
            return;
        }

        // Abbassare la tastiera alla pressione
        if (getCurrentFocus() != null && getCurrentFocus() instanceof EditText) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(totale_txt.getWindowToken(), 0);
        }

        float peso_kg = Float.parseFloat(peso_str);

        String risultati = calculatePercentage(peso_kg);

        risultato_text.setText(risultati);
    }

    @NonNull
    private String calculatePercentage(float peso_kg) {
        return "95%: " + percentage(peso_kg, 95) +
                    "\n90%: " + percentage(peso_kg, 90) +
                    "\n85%: " + percentage(peso_kg, 85) +
                    "\n80%: " + percentage(peso_kg, 80) +
                    "\n75%: " + percentage(peso_kg, 75) +
                    "\n70%: " + percentage(peso_kg, 70) +
                    "\n65%: " + percentage(peso_kg, 65);
    }

    private float percentage(float weight, int perc) {
        return (weight / 100 * perc);
    }
}