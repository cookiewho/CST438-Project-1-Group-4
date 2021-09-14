package com.example.inspirationalanimals.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inspirationalanimals.Dog;
import com.example.inspirationalanimals.Quote;
import com.example.inspirationalanimals.R;

import java.util.List;

public class InspirationAdapter extends RecyclerView.Adapter<InspirationAdapter.ViewHolder> {
    Context context;
    public List<Quote> quotes;
    public List <Dog> dogImgPaths;

    public InspirationAdapter(Context context, List<Quote> quotes, List <Dog> dogs){
        this.context = context;
        this.dogImgPaths = dogs;
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
        Log.d("Inspiration Adapter", "onBindViewer" + position);
        Quote quote = quotes.get(position);
        Dog dog = dogImgPaths.get(position);
        holder.bind(quote, dog);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        TextView tvInspirationalQuote;
        ImageView ivAnimal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInspirationalQuote =  itemView.findViewById(R.id.tvInspirationalQuote);
            ivAnimal = itemView.findViewById(R.id.ivAnimal);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Quote quote, Dog dog) {
            tvInspirationalQuote.setText(quote.getQuotes());
            String imgURL;
            imgURL = dog.getPicture_path();
            Glide.with(context).load(imgURL).into(ivAnimal);
        }
    }
}
