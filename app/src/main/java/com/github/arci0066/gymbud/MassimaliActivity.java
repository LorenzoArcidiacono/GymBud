package com.github.arci0066.gymbud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MassimaliActivity extends AppCompatActivity implements View.OnClickListener {
    private List<MassimaliCard> massimaliCards = new ArrayList<>();
    RecyclerView rv;
    RVAdapter adapter;
    private SharedPreferences mPrefs;
    private static String CARDS = "massimaliCards";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massimali);
        FloatingActionButton fab = findViewById(R.id.massimali_activity_fab);

        mPrefs = getSharedPreferences(getLocalClassName(), MODE_PRIVATE);

        fab.setOnClickListener(this);

        rv = findViewById(R.id.massimali_rv);
        rv.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(this,1);
        rv.setLayoutManager(glm);

        initializeMassimaliCard();
         adapter= new RVAdapter(massimaliCards);
        rv.setAdapter(adapter);

        // todo sistemare togliendo la new
        // Fab hide/show on motion detected
        rv.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0)
                    fab.hide();
                else if (dy < 0)
                    fab.show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO: 05/03/22 salvare tutto in json
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*SharedPreferences.Editor editor = mPrefs.edit();
        try {
            editor.putString(CARDS, ObjectSerializer.serialize(massimaliCards));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.commit();*/
        // TODO: 05/03/22 put massimali cards
    }

    private void initializeMassimaliCard() {
        massimaliCards.add(new MassimaliCard("Squat",135,"05/01/2022"));
        massimaliCards.add(new MassimaliCard("Stacco",100,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Hyp Thrust",195,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Panca Piana",78,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Military Press",50,"05/02/2022"));
    }

    @Override
    public void onClick(View view) {
        massimaliCards.add(new MassimaliCard("Prova",135,"05/01/2022"));
        adapter.notifyDataSetChanged();
    }
}