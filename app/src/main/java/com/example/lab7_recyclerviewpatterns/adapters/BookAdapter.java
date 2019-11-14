package com.example.lab7_recyclerviewpatterns.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab7_recyclerviewpatterns.BookDetail;
import com.example.lab7_recyclerviewpatterns.R;
import com.example.lab7_recyclerviewpatterns.model.BookDetailedModel;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<BookDetailedModel> bookModelList;

    public BookAdapter(List<BookDetailedModel> bookModelList) {
        this.bookModelList = bookModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.booklistitem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNumber.setText(bookModelList.get(position).getBookID()+"");
holder.tvTitle.setText(bookModelList.get(position).getTitle());
holder.tvAuthor.setText(bookModelList.get(position).getAuthor());
holder.tvPublishedYear.setText(bookModelList.get(position).getPublishedYear()+"");
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber,tvTitle,tvAuthor,tvPublishedYear;
        public ViewHolder(@NonNull View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(v.getContext(), BookDetail.class);
                    Bundle b=new Bundle();
                    b.putParcelable("Value",bookModelList.get(getPosition()));
                    i.putExtras(b);

                    v.getContext().startActivity(i);
                }
            });
            tvNumber=v.findViewById(R.id.tvNumber);
            tvTitle=v.findViewById(R.id.tvTitle);
            tvAuthor=v.findViewById(R.id.tvAuthor);
            tvPublishedYear=v.findViewById(R.id.tvPublishedYear);
        }
    }
}
