package com.example.flickr.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flickr.R;
import com.example.flickr.Adapter.RecyclerAdapter;
import com.example.flickr.RestApi.ManagerAll;
import com.example.flickr.model.Photo;
import com.example.flickr.model.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Photo> list;
    RecyclerView recycler;
    RecyclerAdapter adp;
    String format;
    Boolean scrool=true;
    GridLayoutManager layoutManager;
    int pastVisibleItems;
    int visibleItemCount;
    int totalItemCounts;
    int previus_total=0;
    int view_threashold=10;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tanimla();
istek();


    }
public void tanimla()
{
    list=new ArrayList<>();
    recycler=findViewById(R.id.recycler);
     layoutManager= new GridLayoutManager(this,2);
     recycler.setHasFixedSize(true);
    recycler.setLayoutManager(layoutManager);
    progressBar=findViewById(R.id.progress);
    progressBar.setVisibility(View.VISIBLE);
}
    public void istek()
    {
        progressBar.setVisibility(View.VISIBLE);
       Call<model> x=ManagerAll.getInstance().veri();
       x.enqueue(new Callback<model>() {
           @Override
           public void onResponse(Call<model> call, Response<model> response) {

                  list=  response.body().photos.photo;
                  adp=new RecyclerAdapter(MainActivity.this,list);
                  recycler.setAdapter(adp);
                  Toast.makeText(getApplicationContext(),"veriler gelddi",Toast.LENGTH_SHORT).show();

               recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {


                   @Override
                   public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                       super.onScrolled(recyclerView, dx, dy);

                       visibleItemCount=layoutManager.getChildCount();
                       totalItemCounts=layoutManager.getItemCount();
                       pastVisibleItems=layoutManager.findFirstVisibleItemPosition();

                       if(dy>0){
                           if(scrool)
                           {
                               if(totalItemCounts>previus_total)
                               {
                                   scrool=false;
                                   previus_total=totalItemCounts;

                               }

                           }
                           if(!scrool&&(totalItemCounts-visibleItemCount)<=(pastVisibleItems+view_threashold))
                           {


                               progressBar.setVisibility(View.GONE);
                               scrool=true;

                           }
                       }

                   }
               });

            progressBar.setVisibility(View.GONE);
           }

           @Override
           public void onFailure(Call<model> call, Throwable t) {
        Log.i("aaaaaaaaa","basarisiz");
           }
       });


    }

    public void yap()
    {
        Call<model> xx=ManagerAll.getInstance().veri();
        xx.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                if(response.body().getStat().equals("ok"))
                {


                }
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });
    }

}
