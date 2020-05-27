package com.example.flickr.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.flickr.R;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    ImageView mainresim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();
        resimGoster();
    }

    public void tanimla()
    {
        mainresim=findViewById(R.id.mainresim);

    }
    public void resimGoster()
    {
        Bundle bundle=getIntent().getExtras();
        String URL=bundle.getString("resim");
        Picasso.get().load(URL).into((mainresim));

    }
}
