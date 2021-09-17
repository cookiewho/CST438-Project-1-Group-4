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
import com.example.inspirationalanimals.Cat;
import com.example.inspirationalanimals.Dog;
import com.example.inspirationalanimals.Quote;
import com.example.inspirationalanimals.R;

import java.util.List;

public class InspirationAdapter extends RecyclerView.Adapter<InspirationAdapter.ViewHolder> {
    Context context;
    public List<Quote> quotes;
    public List <String> dogs;
    public List <Cat> cats;

    public InspirationAdapter(Context context, List<Quote> quotes, List <String> dogs, List <Cat> cats){
        this.context = context;
        this.dogs = dogs;
        this.quotes = quotes;
        this.cats = cats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View quoteView = LayoutInflater.from(context).inflate(R.layout.item_quote, parent, false);
        return new ViewHolder(quoteView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quote quote = quotes.get(position);
        String dog = "https://images.dog.ceo/breeds/spaniel-brittany/n02101388_1252.jpg";
        Cat cat;
        if(dogs.size() > 0) {
            dog = dogs.get(position);
            holder.bind(quote, dog);
        }
        if(cats.size()>0){
            cat = cats.get(position);
            holder.bind(quote, cat);
        }

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

        public void bind(Quote quote, String dog) {
            tvInspirationalQuote.setText(quote.getQuotes());
            String imgURL;
            imgURL = dog;
            Log.d("GLIDE", imgURL);
            Glide.with(context).load(imgURL).into(ivAnimal);
        }
        public void bind(Quote quote, Cat cat) {
            tvInspirationalQuote.setText(quote.getQuotes());
            String imgURL;
            imgURL = cat.getCats();
            Log.d("GLIDE", imgURL);
            Glide.with(context).load(imgURL).into(ivAnimal);
        }
    }
}
