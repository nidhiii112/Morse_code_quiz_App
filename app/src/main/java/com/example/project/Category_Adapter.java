package com.example.project;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.viewholder> {

    private List<Category_Model> category_modelList;

    public Category_Adapter(List<Category_Model> category_modelList) {
        this.category_modelList = category_modelList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_items,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.setData(category_modelList.get(position).getImageUrl(),category_modelList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return category_modelList.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        private CircleImageView imageView;
        private TextView title;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
        }

        private void setData(String url, final String title) {
            Glide.with(itemView.getContext())
                    .load(url);
            this.title.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent setIntent = new Intent(itemView.getContext(),SetsActivity.class);
                    setIntent.putExtra("title", title);
                    itemView.getContext().startActivity(setIntent);
                }
            });
        }
        }
    }

