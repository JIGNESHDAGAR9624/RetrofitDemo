package com.example.retrofitandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar ;
    PostsAdapter adapter;
    LinearLayoutManager LayoutManager;
    List<posts> postsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView = findViewById(R.id.recycelr);
       progressBar = findViewById(R.id.progressBar);

       LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        adapter = new PostsAdapter(postsList);
        recyclerView.setAdapter(adapter);

        fetchPosts();


    }

    private  void fetchPosts (){
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getretrofitClient().getposts().enqueue(new Callback<List<posts>>() {
            @SuppressLint("NotifyDataSetChanged")

            @Override
            public void onResponse(Call<List<posts>> call, Response<List<posts>> response) {
                if(response.isSuccessful() && response.body() != null){
                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<posts>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error:"+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}