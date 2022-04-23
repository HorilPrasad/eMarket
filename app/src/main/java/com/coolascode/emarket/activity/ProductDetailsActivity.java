package com.coolascode.emarket.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolascode.emarket.R;
import com.coolascode.emarket.modal.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    String shopUid,key;
    TextView shopName,productName,productDesc,productPrice;
    ImageView productImg;
    DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

       shopUid = getIntent().getStringExtra("shopid");
        key = getIntent().getStringExtra("key");

        shopName = findViewById(R.id.shopName_details);
        productName = findViewById(R.id.productName_details);
        productDesc = findViewById(R.id.productDescription_details);
        productPrice = findViewById(R.id.productPrice_details);
        rootRef = FirebaseDatabase.getInstance().getReference();
        //retrive();
    }

    void retrive(){

        rootRef.child("Products").child(shopUid).child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("productName").getValue().toString();
                String price = snapshot.child("productPrice").getValue().toString();
                String desc = snapshot.child("productDesc").getValue().toString();
                String image = snapshot.child("imageUri").getValue().toString();
                productName.setText(name);
                productPrice.setText(price);
                productDesc.setText(desc);
                Picasso.get().load(image).placeholder(R.drawable.image).into(productImg);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}