package com.example.artifact_app_collection;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class mainclass extends RecyclerView.Adapter<mainclass.MyViewHolder> {

    Context context;

    ArrayList<YourModel> list;


    public mainclass(Context context, ArrayList<YourModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        YourModel user = list.get(position);
        holder.name.setText(user.getName());
        holder.description.setText(user.getDescription());
        holder.contacts.setText(user.getContacts());
        holder.price.setText(user.getPrice());
        Glide.with(context).load(user.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, description,contacts,price;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewName);
            description = itemView.findViewById(R.id.textViewDescription);
            contacts = itemView.findViewById(R.id.textViewaddress);
            price = itemView.findViewById(R.id.textViewPrice);
            imageView=itemView.findViewById(R.id.imageView1);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

}