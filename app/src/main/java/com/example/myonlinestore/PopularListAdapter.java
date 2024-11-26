package com.example.myonlinestore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PopularDomain> items;

    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent, false);
        context= parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to each item

        holder.titleTxt.setText(items.get(position).getTitle());
        holder.feeTxt.setText("$"+items.get(position).getPrice());
        holder.ScoreTxt.setText(""+items.get(position).getScore());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicURL(),
                "drawable",holder.itemView.getContext().getPackageName());


            Glide.with(holder.itemView.getContext())
                    .load(drawableResourceId)
                    .transform(new GranularRoundedCorners(30, 30, 0, 0))
                    .into(holder.pic);

            holder.itemView.setOnClickListener(v -> {
                Intent intent=new Intent(holder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(intent);
            });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Define views in the item layout
        TextView titleTxt,feeTxt,ScoreTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt= itemView.findViewById(R.id.titleTxt);
            feeTxt= itemView.findViewById(R.id.feeTxt);
            ScoreTxt=itemView.findViewById(R.id.scoreTxt);
            pic= itemView.findViewById(R.id.pic);
        }
    }
}
