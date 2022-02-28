package com.github.arci0066.gymbud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MassimaliActivity extends AppCompatActivity {
    private List<MassimaliCard> massimaliCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massimali);
        FloatingActionButton fab = findViewById(R.id.massimali_activity_fab);

        RecyclerView rv = (RecyclerView)findViewById(R.id.massimali_rv);
        rv.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(this,1);
        rv.setLayoutManager(glm);

        initializeMassimaliCard();
        RVAdapter adapter = new RVAdapter(massimaliCards);
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

    private void initializeMassimaliCard() {
        massimaliCards.add(new MassimaliCard("Squat",135,"05/01/2022"));
        massimaliCards.add(new MassimaliCard("Stacco",100,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Hyp Thrust",195,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Panca Piana",78,"05/02/2022"));
        massimaliCards.add(new MassimaliCard("Military Press",50,"05/02/2022"));
    }
}