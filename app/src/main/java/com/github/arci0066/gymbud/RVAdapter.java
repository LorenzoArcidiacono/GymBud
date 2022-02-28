package com.github.arci0066.gymbud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder>{

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

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView exercise;
        TextView maxWeight;
        TextView date;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.massimale_card);
            exercise = itemView.findViewById(R.id.massimale_exercise_txt);
            maxWeight = itemView.findViewById(R.id.massimale_weight_txt);
            date = itemView.findViewById(R.id.massimale_data_txt);

        }
    }
}
