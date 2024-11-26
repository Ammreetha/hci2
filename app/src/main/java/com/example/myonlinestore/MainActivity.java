package com.example.myonlinestore;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        FirebaseApp.initializeApp(this);

        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseApp.initializeApp(this);
        }
        FirebaseFirestore db = FirebaseFirestore.getInstance();

    }

    private void initRecyclerview() {
        ArrayList<PopularDomain>items=new ArrayList<PopularDomain>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip","Discover the new Macbook Pro featuring the\n"+
                "powerful M2 chip. This cutting-edge laptop\n"+
                "redefines performance and portability. With its\n"+
                "sleek designs and advance technology, the\n" +
                "MacBook Pro 13 M2 chip is your ultimate\n"+
                "companion for productivity,creativity, and\n"+
                "entertainment.\n","pic1",15,4,535));
        items.add(new PopularDomain("PS5 Digital","Discover the PS5 Digital Edition, featuring\n"+
                "lightning-fast load times and stunning graphics.\n"+
                "This next-gen console redefines gaming with its\n"+
                "powerful performance and sleek, disc-free design.\n"+
                "With the PS5 Digital Edition, experience seamless\n"+
                "downloads and instant access to the latest games.\n","pic2",10,4.5,500));
        items.add(new PopularDomain("Iphone13 Pro","Introducing the iPhone 13 Pro, powered by the\n"+
                "advanced A15 Bionic chip for lightning-fast\n"+
                "performance and efficiency. Enjoy an immersive\n"+
                "viewing experience with the Super Retina XDR\n"+
                "display, perfect for gaming, streaming, and\n"+
                "photography. The Pro camera system takes your\n"+
                "photos to the next level with stunning detail and\n"+
                "clarity, making every shot feel like a masterpiece.\n","pic3",13,4.2,432));

        recyclerViewPopular=findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterPopular=new PopularListAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }


}
