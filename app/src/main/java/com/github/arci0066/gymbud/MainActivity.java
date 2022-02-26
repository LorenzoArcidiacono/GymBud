package com.github.arci0066.gymbud;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button percentuali_btn, dischi_btn, massimali_btn;

        percentuali_btn = findViewById(R.id.percentuali_button);
        massimali_btn = findViewById(R.id.massimali_button);
        dischi_btn = findViewById(R.id.dischi_button);

        percentuali_btn.setOnClickListener(this);
        massimali_btn.setOnClickListener(this);
        dischi_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.percentuali_button: {
                intent = new Intent(this, activity_percentuali.class);
                startActivity(intent);
                break;

            }
            case R.id.massimali_button: {
                intent = new Intent(this, MassimaliActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.dischi_button: {
                intent = new Intent(this, activity_dischi.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }
}