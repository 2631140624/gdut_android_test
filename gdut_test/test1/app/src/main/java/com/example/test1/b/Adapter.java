package com.example.test1.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;

import java.util.List;

/**
 * @author :yinxiaolong
 * @describe : com.example.test1.b
 * @date :2023/4/15 18:22
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Bean> lists;

    public Adapter(List<Bean> lists){
        this.lists=lists;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.b_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(lists.get(position).getImagineUrl());
        holder.textViewName.setText(lists.get(position).getName());
        holder.textViewPrice.setText("价格："+lists.get(position).getPrice()+"元");
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textViewName;
        private final TextView textViewPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textViewName=itemView.findViewById(R.id.name);
            textViewPrice=itemView.findViewById(R.id.price);
        }
    }
}
