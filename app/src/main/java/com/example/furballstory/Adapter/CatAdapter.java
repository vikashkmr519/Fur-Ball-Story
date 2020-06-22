package com.example.furballstory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furballstory.R;
import com.example.furballstory.Util.Dog;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    List<Dog> list;



    Context mContext;
    public CatAdapter(List<Dog> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);
        CatAdapter.ViewHolder viewHolder = new CatAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ageTv.setText(list.get(position).getAge());
        holder.nameTv.setText(list.get(position).getName());
        holder.breedTv.setText(list.get(position).getBreed());
        Picasso.with(mContext).load(R.drawable.cat_image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView breedTv,nameTv,ageTv;
        CircleImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            breedTv = itemView.findViewById(R.id.breedTv);
            nameTv = itemView.findViewById(R.id.nameTv);
            ageTv = itemView.findViewById(R.id.ageTv);
            image = itemView.findViewById(R.id.dogImage);
        }
    }
}
