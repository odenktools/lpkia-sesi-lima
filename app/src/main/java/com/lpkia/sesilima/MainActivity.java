package com.lpkia.sesilima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txNamaCustomer;
    private TextView txOrderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();

        txNamaCustomer = findViewById(R.id.txNamaCustomer);
        txOrderTotal = findViewById(R.id.txOrderTotal);

        String edNama = extras.getString("namaCustomer");
        float hargaTotal = extras.getFloat("hargaTotal");

        txNamaCustomer.setText(edNama);
        txOrderTotal.setText(String.valueOf(hargaTotal));
    }
}
