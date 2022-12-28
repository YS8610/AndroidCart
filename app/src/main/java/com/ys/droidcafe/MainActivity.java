package com.ys.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ImageView imageDonut;
    private ImageView imageIceCream;
    private ImageView imageFroyo;
    private FloatingActionButton fab;
    private String mOrderMessage;
    public static final String EXTRA_MESSAGE="com.example.android.droidcafe.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDonut = findViewById(R.id.donut);
        imageIceCream = findViewById(R.id.ice_cream);
        imageFroyo = findViewById(R.id.froyo);
        fab = findViewById(R.id.floatingActionButton);

        imageDonut.setOnClickListener(view -> {
            mOrderMessage = getString(R.string.donut_order_message);
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        imageIceCream.setOnClickListener(v ->{
            mOrderMessage = getString(R.string.ice_cream_order_message);
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        imageFroyo.setOnClickListener( v-> {
            mOrderMessage = getString(R.string.froyo_order_message);
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show();
        });

        fab.setOnClickListener( v-> {
            Intent intent = new Intent(MainActivity.this,OrderActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
            startActivity(intent);
        });
    }
}