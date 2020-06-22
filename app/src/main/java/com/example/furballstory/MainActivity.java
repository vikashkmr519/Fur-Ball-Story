package com.example.furballstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.furballstory.Adapter.CatAdapter;
import com.example.furballstory.Adapter.DogAdapter;
import com.example.furballstory.Util.Dog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Dog> list = new ArrayList<>();
    List<Dog> catList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView catRecyclwerView;
    DogAdapter dogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.dogRecyclerView);
        catRecyclwerView = findViewById(R.id.catRecyclerView);

        getdogList();
        getCatList();
    }

    private void getCatList() {
        addCat("Lucky","Bengal Cat","2 year Old");
        addCat("catty","Manx Cat","8 months old");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);


        catRecyclwerView.setLayoutManager(layoutManager);
        CatAdapter adapter = new CatAdapter(catList,getBaseContext());
        catRecyclwerView.setAdapter(adapter);
    }

    private void getdogList() {
        addDog("Milo","American PitBull","10 Months Old");
        addDog("Shampoo","Beagles","6 months old");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);


        recyclerView.setLayoutManager(layoutManager);
        dogAdapter = new DogAdapter(list,getBaseContext());
        recyclerView.setAdapter(dogAdapter);

    }

    private void addDog(String name, String breed, String age){
        list.add(new Dog(name, breed, age));
    }
    private void addCat(String name, String breed, String age){
        catList.add(new Dog(name, breed, age));
    }

}