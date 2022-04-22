package com.coolascode.emarket.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coolascode.emarket.R;

public class ShopLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_login);

        TextView shoplogin=findViewById(R.id.RegisterNow);

        shoplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShopLoginActivity.this, ShopRegisterActivity.class);
                startActivity(i);
            }
        });
    }
}