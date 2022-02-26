package com.github.arci0066.gymbud;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class activity_dischi extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dischi);

        Button calcutlate_btn = findViewById(R.id.calculate_dischi_button);
        calcutlate_btn.setOnClickListener(this);
    }

    private String calculateDisk(float weight, int bar) {
        int d25, d20, d15, d10, d5, d2_5, d1_25, d0_25;
        float remains = (weight - bar) / 2;

        d25 = d20 = d15 = d10 = d5 = d2_5 = d1_25 = d0_25 = 0;

        while (remains > 0.25) { //todo controllare questa guardia
            if (25 <= remains) {
                d25++;
                remains -= 25;
            } else if (20 <= remains) {
                d20++;
                remains -= 20;
            } else if (15 <= remains) {
                d15++;
                remains -= 15;
            } else if (10 <= remains) {
                d10++;
                remains -= 10;
            } else if (5 <= remains) {
                d5++;
                remains -= 5;
            } else if (2.5 <= remains) {
                d2_5++;
                remains -= 2.5;
            } else if (1.25 <= remains) {
                d1_25++;
                remains -= 1.25;
            } else if (0.25 <= remains) {
                d0_25++;
                remains -= 0.25;
            } else
                return "Errore";
        }

        float total = weight - remains;

        return "Per lato:" +
                "\n 25: " + d25 +
                "\n 20: " + d20 +
                "\n 15: " + d15 +
                "\n 10: " + d10 +
                "\n 5: " + d5 +
                "\n 2.5: " + d2_5 +
                "\n 1.25: " + d1_25 +
                "\n 0.25: " + d0_25 +
                "\n Totale: " + total;

    }

    @Override
    public void onClick(View view) {

        TextInputEditText sbarra;
        TextInputEditText totale;
        TextView risultato_text = findViewById(R.id.risultato_dischi_txt);
        String totale_str, sbarra_str;
        int sbarra_kg = 20;
        float totale_kg = 0;

        sbarra = findViewById(R.id.peso_sbarra_txt);
        sbarra_str = String.valueOf(sbarra.getText());
        totale = findViewById(R.id.peso_totale_txt);
        totale_str = String.valueOf(totale.getText());

        if (totale_str.isEmpty()) {
            risultato_text.setText("Errore, digitare il peso desiderato.");
            return;
        }

        // Abbassare la tastiera alla pressione
        if (getCurrentFocus() != null && getCurrentFocus() instanceof EditText) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(sbarra.getWindowToken(), 0);
        }

        totale_kg = Float.parseFloat(totale_str);
        if (!sbarra_str.isEmpty())
            sbarra_kg = Integer.parseInt(sbarra_str);

        risultato_text.setText(calculateDisk(totale_kg, sbarra_kg));
    }
}