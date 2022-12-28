package com.ys.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView order_textview;
    private RadioButton radioSameDay;
    private RadioButton radioNextDay;
    private RadioButton radioPickUp;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        radioSameDay = findViewById(R.id.sameday);
        radioNextDay = findViewById(R.id.nextday);
        radioPickUp = findViewById(R.id.pickup);

        radioPickUp.setChecked(true);

        radioSameDay.setOnClickListener( view -> {
            Toast.makeText(this, R.string.same_day_messenger_service, Toast.LENGTH_SHORT).show();
        });

        radioNextDay.setOnClickListener( view -> {
            Toast.makeText(this, R.string.next_day_ground_delivery, Toast.LENGTH_SHORT).show();
        });

        radioPickUp.setOnClickListener( view -> {
            Toast.makeText(this, R.string.pick_up, Toast.LENGTH_SHORT).show();
        });

        spinner = findViewById(R.id.label_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        if (spinner!=null){
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }


        Intent intent = getIntent();
        String message = " Order : " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        order_textview = findViewById(R.id.order_textview);
        order_textview.setText(message);


    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}