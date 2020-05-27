package com.example.flickr.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flickr.Activity.Main2Activity;
import com.example.flickr.R;
import com.example.flickr.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.tanimla> {

    Context context;
    List<Photo> list;

    public RecyclerAdapter(Context context, List<Photo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public tanimla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fotolayout,parent,false);

        return new tanimla(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final tanimla holder, int position) {
       /* int id=list.get(position).get(position).getFarm();
        String idd=String.valueOf(id);
        String server=list.get(position).get(position).getServer();
        String photoid=list.get(position).get(position).getId();
        String secret=list.get(position).get(position).getSecret();
       */
           final String format="https://farm"+String.valueOf(list.get(position).getFarm())+".staticflickr.com/"+list.get(position).getServer()+"/"+list.get(position).
                   getId()+"_"+list.get(position).getSecret()+"_m.jpg";
           Picasso.get().load(format).into(((tanimla) holder).foto);

holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent  =new Intent(holder.itemView.getContext(), Main2Activity.class);
        intent.putExtra("resim",format);
        holder.itemView.getContext().startActivity(intent);
    }
});



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class tanimla extends RecyclerView.ViewHolder{

        ImageView foto;
        LinearLayout linearLayout;

        public tanimla(@NonNull View itemView) {
            super(itemView);
            foto=itemView.findViewById(R.id.foto);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}
