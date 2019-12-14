package com.android.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView tv_hasil;
    Button btn_reset, btn_hitung_rumus, btn_bandingkan_bilangan, btn_looping_for,
            btn_looping_while, btn_looping_do_while;
    EditText edt_bil1, edt_bil2;
    String operasi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hasil = findViewById(R.id.tv_hasil);
        btn_reset = findViewById(R.id.btn_reset);
        btn_hitung_rumus = findViewById(R.id.btn_hitung_rumus);
        btn_bandingkan_bilangan = findViewById(R.id.btn_bandingkan_bilangan);
        btn_looping_for = findViewById(R.id.btn_looping_for);
        btn_looping_while = findViewById(R.id.btn_looping_while);
        btn_looping_do_while = findViewById(R.id.btn_looping_do_while);

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

        btn_hitung_rumus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");
                }else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");
                }else {
                    Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                    Double bil2Value = Double.valueOf(edt_bil2.getText().toString());
                    double hasil = (bil1Value * bil2Value) / 2;
                    DecimalFormat format = new DecimalFormat("0.#");
                    String res = "(" + format.format(bil1Value) + " * " + format.format(bil2Value) + ")/2" + " = " + format.format(hasil);
                    tv_hasil.setText(res);
                }
            }
        });

        btn_bandingkan_bilangan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");
                }else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");
                }else {
                    Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                    Double bil2Value = Double.valueOf(edt_bil2.getText().toString());

                    String res;
                    DecimalFormat format = new DecimalFormat("0.#");

                    if (bil1Value > bil2Value) {
                        res = format.format(bil1Value) + " > " + format.format(bil2Value);
                    } else if (bil1Value < bil2Value) {
                        res = format.format(bil1Value) + " < " + format.format(bil2Value);
                    } else {
                        res = format.format(bil1Value) + " = " + format.format(bil2Value);
                    }

                    tv_hasil.setText(res);
                }
            }
        });

        btn_looping_for.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){

                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");

                }else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");

                }else {

                    Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                    Double bil2Value = Double.valueOf(edt_bil2.getText().toString());

                    if (bil1Value > bil2Value) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 1 harus lebih kecil dari bilangan 2", Toast.LENGTH_LONG).show();
                    } else if (bil2Value > 10) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 2 melebihi batas maksimum looping", Toast.LENGTH_LONG).show();
                    } else {

                        tv_hasil.setText("");
                        for (int i = bil1Value.intValue(); i <= bil2Value.intValue(); i++) {
                            System.out.println(i+", ");
                            tv_hasil.append(i+", ");
                        }

                    }
                }
            }
        });

        btn_looping_while.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){

                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");

                }else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");

                }else {

                    Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                    Double bil2Value = Double.valueOf(edt_bil2.getText().toString());

                    if (bil1Value > bil2Value) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 1 harus lebih kecil dari bilangan 2", Toast.LENGTH_LONG).show();
                    } else if (bil2Value > 10) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 2 melebihi batas maksimum looping", Toast.LENGTH_LONG).show();
                    } else {

                        tv_hasil.setText("");
                        int i = bil1Value.intValue();
                        int x = bil2Value.intValue();
                        while (i <= x) {
                            System.out.print(i+", ");
                            tv_hasil.append(i+", ");
                            i++;
                        }

                    }
                }
            }
        });

        btn_looping_do_while.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){

                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");

                }else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");

                }else {

                    Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                    Double bil2Value = Double.valueOf(edt_bil2.getText().toString());

                    if (bil1Value > bil2Value) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 1 harus lebih kecil dari bilangan 2", Toast.LENGTH_LONG).show();
                    } else if (bil2Value > 10) {
                        Toast.makeText(MainActivity.this, "Invalid Bilangan 2 melebihi batas maksimum looping", Toast.LENGTH_LONG).show();
                    } else {

                        tv_hasil.setText("");
                        int i = bil1Value.intValue();
                        int x = bil2Value.intValue();
                        do {
                            System.out.print(i+", ");
                            tv_hasil.append(i+", ");
                            i++;
                        }while (i<=x);

                    }
                }
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
