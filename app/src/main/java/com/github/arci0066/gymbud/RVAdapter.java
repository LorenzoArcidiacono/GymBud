package com.github.arci0066.gymbud;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

    List<MassimaliCard> massimaliCards;

    public RVAdapter(List<MassimaliCard> massimaliCards) {
        this.massimaliCards = massimaliCards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.massimali_card, parent, false);
        CardViewHolder cvh = new CardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.exercise.setText(massimaliCards.get(position).getExercise());
        holder.maxWeight.setText(massimaliCards.get(position).getMaxWeight());
        holder.date.setText(massimaliCards.get(position).getDate());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return massimaliCards.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView exercise;
        TextView maxWeight;
        TextView date;
        Button percentualiBtn, modifyBtn;
        List<MassimaliCard> massimaliCards;
        private Intent intent;

        public CardViewHolder(@NonNull View itemView ) {
            super(itemView);
            cv = itemView.findViewById(R.id.massimale_card);
            exercise = itemView.findViewById(R.id.massimale_exercise_txt);
            maxWeight = itemView.findViewById(R.id.massimale_weight_txt);
            date = itemView.findViewById(R.id.massimale_data_txt);
            percentualiBtn = itemView.findViewById(R.id.percentuali_card_btn);
            percentualiBtn.setOnClickListener(this);
            modifyBtn = itemView.findViewById(R.id.modifica_card_btn);
            modifyBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.modifica_card_btn:
                    Snackbar.make(view, "Modifica BTN", Snackbar.LENGTH_SHORT)
                            .show();
                    break;

                case R.id.percentuali_card_btn:
                    //Lancia percenutaliActivity passando il peso da usare
                    intent = new Intent(view.getContext(), activity_percentuali.class);
                    intent.putExtra("weight_massimali", maxWeight.getText());
                    view.getContext().startActivity(intent);
                    break;
            }
        }

        private int getCardPosition(List<MassimaliCard> massimaliCards, CharSequence text) {

            for (int i = 0; i < massimaliCards.size(); i++) {
                if(massimaliCards.get(i).getExercise().equals(text))
                    return i;
            }
            return -1;
        }
    }
}
