package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<Category_Model> list = new ArrayList<>();
        list.add(new Category_Model("","Category1"));
        list.add(new Category_Model("","Category2"));
        list.add(new Category_Model("","Category3"));
        list.add(new Category_Model("","Category4"));
        list.add(new Category_Model("","Category5"));
        list.add(new Category_Model("","Category6"));
        list.add(new Category_Model("","Category7"));
        list.add(new Category_Model("","Category8"));
        list.add(new Category_Model("","Category9"));
        list.add(new Category_Model("","Category10"));
        list.add(new Category_Model("","Category11"));
        list.add(new Category_Model("","Category12"));
        list.add(new Category_Model("","Category13"));
        list.add(new Category_Model("","Category14"));
        list.add(new Category_Model("","Category15"));

        Category_Adapter adapter = new Category_Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}