package com.lpkia.sesilima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OrderActivity extends AppCompatActivity {

    /**
     * Deklarasi Variable
     */
    private EditText edCount;
    private EditText edNama;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnOrder;
    private CheckBox chkSusu;
    private CheckBox chkKeju;
    private CheckBox chkCoklat;
    private RadioGroup rgTipeMartabak;

    private int counter = 0;
    private float hargaAwal = 15000;
    private float hargaTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        edCount = findViewById(R.id.edCount);
        edNama = findViewById(R.id.edNama);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnOrder = findViewById(R.id.btnOrder);
        chkSusu = findViewById(R.id.chkSusu);
        chkKeju = findViewById(R.id.chkKeju);
        chkCoklat = findViewById(R.id.chkCoklat);
        rgTipeMartabak = findViewById(R.id.rgTipeMartabak);

        chkSusu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // Setup harga tambahan untuk susu
                buttonView.setTag(3000f);
                Object tag = buttonView.getTag();
                if (isChecked) {
                    hargaAwal += (float) tag;
                } else {
                    hargaAwal -= (float) tag;
                }
            }
        });

        chkKeju.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //@TODO (1) TAMBAHKAN hargaAwal + 7000 JIKA KEJU DIPILIH
            }
        });

        chkCoklat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //@TODO (2) TAMBAHKAN hargaAwal + 5000 JIKA COKLAT DIPILIH
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //@TODO (3) JIKA BUTTON DIKLIK KURANG JUMLAH PEMBELIAN
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += 1;
                edCount.setText(String.valueOf(counter));
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedRadioButtonID = rgTipeMartabak.getCheckedRadioButtonId();

                hargaTotal = hargaAwal * Float.parseFloat(edCount.getText().toString());

                // pastikan user melakukan pilihan jenis martabak
                if (selectedRadioButtonID != -1) {
                    hargaTotal = hargaAwal * Float.parseFloat(edCount.getText().toString());
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonID);

                    // Jika yang dipilih adalah martabak special
                    if (selectedRadioButton.getId() == R.id.radioSpecial) {
                        //@TODO (4) TAMBAHKAN HARGA TOTAL + 5000 MARTABAK SPECIAL DIPILIH
                    } else {
                        //@TODO (5) HARGA TOTAL TIDAK BERTAMBAH
                    }

                    Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                    intent.putExtra("namaCustomer", edNama.getText().toString());
                    intent.putExtra("hargaTotal", hargaTotal);
                    startActivity(intent);
                }
            }
        });
    }
}
