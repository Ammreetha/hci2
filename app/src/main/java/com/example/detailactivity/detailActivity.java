package com.example.detailactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,reviewTxt,scoreTxt;
    private ImageView picItem,backBtn;
    private PopularDomain object;
    private int numberOrder=1;
    private ManagmentCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     managmentCart=new Management(this);

        initView();
        getBundle();

    }

    private void getBundle() {
        object=(PopularDomain) getIntent().getSerializableExtra( name:"object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(),defType:"drawable",this.getPackageName());

        Glide.with(activity: this)
                .load(drawableResourceId)
                .into(picItem):
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(object.getReview()+"");
        scoreTxt.setText(object.getScore()="");

        addToCartBtn.setOnClickListener(v -> {
            object.setNumberinCar(numberOrder);
            managmentCart.insterFood(object)
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(DetailActivity.this,MainActivity.class));
             }
        });
    }

    private void initView(){
        addToCartBtn=findViewById(R.id.addToCartBtn);
        feeTxt=findViewById(R.id.priceTxt);
        titleTxt=findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptiontxt);
        picItem =findViewById(R.id.itemPic);
        reviewTxt=findViewById(R.id.reviewTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        backBtn=findViewById(R.id.backBtn);

    }
}
