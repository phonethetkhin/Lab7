package com.example.lab7_recyclerviewpatterns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab7_recyclerviewpatterns.model.BookDetailedModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookDetail  extends AppCompatActivity {
private BookDetailedModel bookDetailedModel;
ImageView imgCoverPhoto;
TextView tvTitle,tvAuthor,tvPublishedYear,tvNumberofPages,tvGenre,tvOlanguage,tvDescription;


private void InitiateViews()
{
    imgCoverPhoto=findViewById(R.id.imgCoverPhoto);
    tvTitle=findViewById(R.id.tvTitle);
    tvAuthor=findViewById(R.id.tvAuthor);
    tvPublishedYear=findViewById(R.id.tvPublishedYear);
    tvNumberofPages=findViewById(R.id.tvNumberofPages);
    tvGenre=findViewById(R.id.tvGenre);
    tvOlanguage=findViewById(R.id.tvOlanguage);
    tvDescription=findViewById(R.id.tvDescription);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        InitiateViews();
        bookDetailedModel=getIntent().getParcelableExtra("Value");
        getSupportActionBar().setTitle(bookDetailedModel.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Picasso.get().load(bookDetailedModel.getCoverPhoto()).into(imgCoverPhoto);
        tvTitle.setText(bookDetailedModel.getTitle());
        String sourceString = "Written By <b>" + bookDetailedModel.getAuthor() + "</b> ";
        tvAuthor.setText(Html.fromHtml(sourceString));
        tvPublishedYear.setText("Published in "+bookDetailedModel.getPublishedYear());
        tvNumberofPages.setText(bookDetailedModel.getNumberofPages()+" Pages");
        tvGenre.setText(bookDetailedModel.getGenre());
        tvOlanguage.setText("Language: "+bookDetailedModel.getOriginalLanguage());
        tvDescription.setText(bookDetailedModel.getDescription());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId())
    {
        case android.R.id.home:
            Intent i = new Intent(BookDetail.this, MainActivity.class);

            startActivity(i);
            finish();
            return true;
    }
        return super.onOptionsItemSelected(item);
    }
}
