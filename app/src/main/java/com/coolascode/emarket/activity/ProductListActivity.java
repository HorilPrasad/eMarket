package com.coolascode.emarket.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.coolascode.emarket.R;
import com.coolascode.emarket.adapter.ProductAdapter;
import com.coolascode.emarket.modal.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {
    TextView shopName;
    RecyclerView productRecycler;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    String currentUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        currentUserId = getIntent().getStringExtra("uid");
        String shop_name = getIntent().getStringExtra("shopname");


        productRecycler = findViewById(R.id.product_list_recycler);
        shopName = findViewById(R.id.shopName_product_list);
        shopName.setText(shop_name);
        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(ProductListActivity.this,productArrayList);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        productRecycler.setLayoutManager(layoutManager);
        productRecycler.setAdapter(productAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        retriveData();
    }

    void retriveData(){
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

        rootRef.child("Products").child(currentUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productArrayList.clear();
                for (DataSnapshot snapshot1:snapshot.getChildren())
                {
                    Product product = snapshot1.getValue(Product.class);
                    Toast.makeText(ProductListActivity.this, product.getProductName(), Toast.LENGTH_SHORT).show();
                    productArrayList.add(product);
                }

                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}