package com.example.inspirationalanimals.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inspirationalanimals.Quote;
import com.example.inspirationalanimals.R;

import java.util.List;

public class InspirationAdapter extends RecyclerView.Adapter<InspirationAdapter.ViewHolder> {
    Context context;
    public List<Quote> quotes;
    public ImageView img;

    public InspirationAdapter(Context context, List<Quote> quotes){
        this.context = context;
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View quoteView = LayoutInflater.from(context).inflate(R.layout.item_quote, parent, false);
        return new ViewHolder(quoteView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
