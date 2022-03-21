package com.github.arci0066.gymbud;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RVMainAdapter extends RecyclerView.Adapter<RVMainAdapter.MenuCardViewHolder>{

    private List<MainCard> mainCards;

    public RVMainAdapter(List<MainCard> mainCards) {
        this.mainCards = mainCards;
    }

    @NonNull
    @Override
    public MenuCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_card, parent, false);
        RVMainAdapter.MenuCardViewHolder cvh = new RVMainAdapter.MenuCardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVMainAdapter.MenuCardViewHolder holder, int position) {
        holder.title.setText(mainCards.get(position).getTitle());
        holder.desc.setText(mainCards.get(position).getDesc());
        holder.btn.setOnClickListener(view -> {
            Intent intent;
            intent = null;
            switch (mainCards.get(holder.getAdapterPosition()).getActivity()) {
                case "MassimaliActivity":
                    intent = new Intent(view.getContext(), MassimaliActivity.class);
                    break;
                case "activity_percentuali":
                    intent = new Intent(view.getContext(), activity_percentuali.class);
                    break;
                case "activity_dischi":
                    intent = new Intent(view.getContext(), activity_dischi.class);
                    break;
                case "CountRepActivity":
                    intent = new Intent(view.getContext(), CountRepActivity.class);
                    break;

            }
            if (intent != null) {
                view.getContext().startActivity(intent);
            } else
                Snackbar.make(view, "Errore scelta activity", BaseTransientBottomBar.LENGTH_SHORT)
                        .show();
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public int getItemCount() {
       return mainCards.size();
    }

    class MenuCardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView desc;
        MaterialButton btn;

        public MenuCardViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.menu_card);
            title = itemView.findViewById(R.id.menu_card_title);
            desc = itemView.findViewById(R.id.menu_card_desc);
            btn = itemView.findViewById(R.id.menu_card_btn);
        }
    }
}
