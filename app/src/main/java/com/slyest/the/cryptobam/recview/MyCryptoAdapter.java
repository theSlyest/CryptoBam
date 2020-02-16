package com.slyest.the.cryptobam.recview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slyest.the.cryptobam.R;

import java.util.ArrayList;
import java.util.List;

public class MyCryptoAdapter extends RecyclerView.Adapter<MyCryptoAdapter.CoinViewHolder> {

    private List<CoinModel> mItems = new ArrayList<>();
    private final String STR_TEMPLATE_NAME = "%s\t\t\t\t\t\t%s";
    private final String STR_TEMPLATE_PRICE = "%s$\t\t24H Volume: %s$";


    @Override
    public void onBindViewHolder(MyCryptoAdapter.CoinViewHolder holder, int position) {
        final CoinModel model = mItems.get(position);
        holder.tvNameAndSymbol.setText(String.format(STR_TEMPLATE_NAME, model.name, model.symbol));
        holder.tvPriceAndVolume.setText(String.format(STR_TEMPLATE_PRICE, model.priceUsd, model.volume24H));
        Glide.with(holder.itemView).load(model.imageUrl).into(holder.ivIcon);
    }

    @NonNull
    @Override
    public MyCryptoAdapter.CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyCryptoAdapter.CoinViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<CoinModel> items) {
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }


    class CoinViewHolder extends RecyclerView.ViewHolder {

        TextView tvNameAndSymbol;
        TextView tvPriceAndVolume;
        ImageView ivIcon;

        CoinViewHolder(View itemView) {
            super(itemView);
            tvNameAndSymbol = itemView.findViewById(R.id.tvNameAndSymbol);
            tvPriceAndVolume = itemView.findViewById(R.id.tvPriceAndVolume);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
