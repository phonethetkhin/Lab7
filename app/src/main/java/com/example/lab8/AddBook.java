package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab8.DB.BookDB;
import com.example.lab8.model.BookDetailedModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddBook extends AppCompatActivity {
    TextInputEditText tietID,tietCoverPhoto,tietTitle,tietAuthor,tietGenre,tietOlanguage,tietDescription,tietPublishedYear,tietNumberofPages;
    FloatingActionButton fabDone;
    BookDB db=new BookDB(AddBook.this);
    BookDetailedModel bookDetailedModel;
public void InitializeViews()
{
    tietID=findViewById(R.id.tietID);
    tietCoverPhoto=findViewById(R.id.tietCoverPhoto);
    tietTitle=findViewById(R.id.tietTitle);
    tietAuthor=findViewById(R.id.tietAuthor);
    tietGenre=findViewById(R.id.tietGenre);
    tietOlanguage=findViewById(R.id.tietOlanguage);
    tietDescription=findViewById(R.id.tietDescription);
    tietPublishedYear=findViewById(R.id.tietPublishedYear);
    tietNumberofPages=findViewById(R.id.tietNumberofPages);
    fabDone=findViewById(R.id.fabDone);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        getSupportActionBar().setTitle("Add Book");
        InitializeViews();





        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookDetailedModel=db.GetBookByID(Integer.parseInt(tietID.getText().toString()));

                if(tietID.getText().toString().isEmpty() || tietCoverPhoto.getText().toString().isEmpty() || tietTitle.getText().toString().isEmpty() || tietAuthor.getText().toString().isEmpty()
                        || tietGenre.getText().toString().isEmpty() || tietOlanguage.getText().toString().isEmpty() || tietDescription.getText().toString().isEmpty() || tietPublishedYear.getText().toString().isEmpty()||
                        tietNumberofPages.getText().toString().isEmpty())
                {
                    Toast.makeText(AddBook.this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
                }

                else if(bookDetailedModel!=null)
                {
                    Toast.makeText(AddBook.this, "This Book is Already Added in the Database!! Kindly Check it's BookID", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (db.AddBook(Integer.parseInt(tietID.getText().toString()),
                            tietCoverPhoto.getText().toString(),
                            tietTitle.getText().toString(),
                            tietAuthor.getText().toString(),
                            tietGenre.getText().toString(),
                            tietOlanguage.getText().toString(),
                            tietDescription.getText().toString(),
                            Integer.parseInt(tietPublishedYear.getText().toString()),
                            Integer.parseInt(tietNumberofPages.getText().toString())
                    ))
                    {
                        Toast.makeText(AddBook.this, "1 Book Added Successfully", Toast.LENGTH_LONG).show();
                        clear();
                        finish();

                    }
                    else {
                        Toast.makeText(AddBook.this, "Error Occured!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

    }
    public void clear()
    {
        tietID.setText("");
        tietCoverPhoto.setText("");
        tietTitle.setText("");
        tietAuthor.setText("");
        tietGenre.setText("");
        tietOlanguage.setText("");
        tietDescription.setText("");
        tietPublishedYear.setText("");
        tietNumberofPages.setText("");
        tietID.requestFocus();
    }
}
