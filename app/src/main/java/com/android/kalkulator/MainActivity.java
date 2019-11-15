package com.android.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView tv_hasil;
    Button btn_reset;
    EditText edt_bil1, edt_bil2;
    String operasi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hasil = findViewById(R.id.tv_hasil);
        btn_reset = findViewById(R.id.btn_reset);
        edt_bil1 = findViewById(R.id.edt_bil1);
        edt_bil2 = findViewById(R.id.edt_bil2);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_bil1.setText("");
                edt_bil2.setText("");
                tv_hasil.setText("");
            }
        });
    }

    private Double kalkulasi(Double bil1, Double bil2, String operasi) {
        Double hasil = null;

        switch (operasi) {
            case "+":
                hasil = bil1 + bil2;
                break;
            case "-":
                hasil = bil1 - bil2;
                break;
            case "/":
                hasil = bil1 / bil2;
                break;
            case "x":
                hasil = bil1 * bil2;
                break;
        }

        return hasil;
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operasi = "+";
                break;
            case R.id.btn_minus:
                operasi = "-";
                break;
            case R.id.btn_kali:
                operasi = "x";
                break;
            case R.id.btn_bagi:
                operasi = "/";
                break;
        }
        hitung(operasi);
    }

    public void hitung(String operasi) {
        if (TextUtils.isEmpty(edt_bil1.getText())) {
            edt_bil1.setError("Bilangan 1 Diperlukan");
        }else if (TextUtils.isEmpty(edt_bil2.getText())) {
            edt_bil2.setError("Bilangan 2 Diperlukan");
        }else {
            Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
            Double bil2Value = Double.valueOf(edt_bil2.getText().toString());
            String operasi2 = Objects.requireNonNull(operasi);
            Double hasil = kalkulasi(bil1Value, bil2Value, Objects.requireNonNull(operasi));
            DecimalFormat format = new DecimalFormat("0.#");
            String res = format.format(bil1Value) + " " + operasi2 + " " + format.format(bil2Value) + " = " + format.format(hasil);
            tv_hasil.setText(res);
        }
    }
}
