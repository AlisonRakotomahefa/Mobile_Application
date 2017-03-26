package com.example.aliso.finalproject_alisonrakotomahefa.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.aliso.finalproject_alisonrakotomahefa.R;
import com.example.aliso.finalproject_alisonrakotomahefa.Constants;
import com.example.aliso.finalproject_alisonrakotomahefa.adapters.VideoAdapter;
import com.example.aliso.finalproject_alisonrakotomahefa.models.Example;
import com.example.aliso.finalproject_alisonrakotomahefa.models.Item;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.aliso.finalproject_alisonrakotomahefa.R.attr.logo;

public class VideosActivity extends AppCompatActivity {

    public static void start(Context context, String contractName) {
        Intent intent = new Intent(context, VideosActivity.class);
        intent.putExtra("search", contractName);
        context.startActivity(intent);
    }
    String recherche="eminem"; // par défaut
    private static final String CONTRACTS_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video";
    private ImageView imageView;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        recherche = getIntent().getStringExtra("search");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






        getContracts();

    }

    private void getContracts() {
        StringRequest contractsRequest = new StringRequest(CONTRACTS_URL + "&key=" + Constants.API_KEY+"&q="+recherche, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Example example = new Gson().fromJson(response, Example.class);

                setAdapter(example.getItems());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });

        Volley.newRequestQueue(this).add(contractsRequest);
    }

    private void setAdapter(List<Item> contracts) {
        VideoAdapter adapter = new VideoAdapter(contracts);
        //adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }


}
