package com.github.arci0066.gymbud;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<MainCard> mainCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.main_recview);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(llm);

        initializeCards();
        Log.d("MAIN", "onCreate: "+mainCards.toString());

        RVMainAdapter adapter = new RVMainAdapter(mainCards);
        rv.setAdapter(adapter);

        /*Button percentuali_btn, dischi_btn, massimali_btn;

        percentuali_btn = findViewById(R.id.percentuali_button);
        massimali_btn = findViewById(R.id.massimali_button);
        dischi_btn = findViewById(R.id.dischi_button);

        percentuali_btn.setOnClickListener(this);
        massimali_btn.setOnClickListener(this);
        dischi_btn.setOnClickListener(this);*/
    }

    private void initializeCards() {
//        todo questo modo di passare le actvity fa schido
        mainCards.add(new MainCard("Massimali","Elenco degli ultimi risultati.", "MassimaliActivity"));
        mainCards.add(new MainCard("Percentuali","Calcolatore delle percentuali.", "activity_percentuali"));
        mainCards.add(new MainCard("Dischi","Calcolatore dischi su bilanciere.", "activity_dischi"));
        mainCards.add(new MainCard("Serie","Contatore serie eseguite.", "CountRepActivity"));
    }
}