package com.github.arci0066.gymbud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class CountRepActivity extends AppCompatActivity implements View.OnClickListener {

    Integer count = 0;
    MaterialTextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_rep);

        String countTextSaved = null;
        if(savedInstanceState != null)
            countTextSaved = savedInstanceState.getString("COUNT_REP");
        if(countTextSaved != null)
            text.setText(countTextSaved);

        text = findViewById(R.id.count_rep_text);
        text.setText(count.toString());
        MaterialButton addBtn = findViewById(R.id.count_rep_add_btn);
        addBtn.setOnClickListener(this);
        MaterialButton zeroBtn = findViewById(R.id.count_rep_zero_btn);
        zeroBtn.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO: 05/03/22 salvare counter
        outState.putString("COUNT_REP", (String) text.getText());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.count_rep_add_btn:
                count++;
                break;
            case R.id.count_rep_zero_btn:
                count = 0;
                break;
        }
        text.setText(count.toString());
    }
}