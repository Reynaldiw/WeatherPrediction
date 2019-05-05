package com.reynaldiwijaya.nbsweatherprediction.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reynaldiwijaya.nbsweatherprediction.R;
import com.reynaldiwijaya.nbsweatherprediction.model.Item;
import com.reynaldiwijaya.nbsweatherprediction.ui.detail.DetailWeatherActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private Context mContext;
    private List<Item> items;

    public WeatherAdapter(Context mContext, List<Item> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_city, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final  Item item = items.get(i);

        viewHolder.tvCity.setText(item.getCity());
        Glide.with(mContext)
                .load(item.getImage())
                .into(viewHolder.imgCity);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailWeatherActivity.class)
                .putExtra(DetailWeatherActivity.OBJ, item));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgCity)
        ImageView imgCity;
        @BindView(R.id.tvCity)
        TextView tvCity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
