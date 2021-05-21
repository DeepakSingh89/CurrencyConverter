package com.example.fxrates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fxrates.Retrofit.ApiClient;
import com.example.fxrates.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn_convert, btn_refresh;
    EditText amount_edittxt;
    TextView txt_lastupd, GBP, HKD, DKK, INR, MXN, AUD, USD, NZD, JPY, RUB;
    Spinner spinnerfrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_convert = findViewById(R.id.btn_convert);
        btn_refresh = findViewById(R.id.btn_refresh);
        amount_edittxt = findViewById(R.id.amount_edittxt);
        txt_lastupd = findViewById(R.id.txt_lastupd);
        spinnerfrom = findViewById(R.id.spinnerfrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        GBP = findViewById(R.id.GBP);
        HKD = findViewById(R.id.HKD);
        DKK = findViewById(R.id.DKK);
        INR = findViewById(R.id.INR);
        MXN = findViewById(R.id.MXN);
        AUD = findViewById(R.id.AUD);
        USD = findViewById(R.id.USD);
        NZD = findViewById(R.id.NZD);
        JPY = findViewById(R.id.JPY);
        RUB = findViewById(R.id.RUB);

        String[] from = {"EUR", "INR"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        spinnerfrom.setAdapter(adapter1);

        String[] to = {"INR", "JPY", "GBP", "HKD", "DKK", "MXN", "AUD", "NZD", "USD", "HKD", "RUB"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        spinnerTo.setAdapter(adapter2);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getConvertedRate();
            }
        });
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getExchangeRate();
            }


        });
        MyDbHandler db = new MyDbHandler(MainActivity.this);

    }

    public void getConvertedRate() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PostList> call = apiInterface.getCurrency();
        call.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {

                double user_amount = Double.parseDouble(amount_edittxt.getText().toString());
                double currency_from = 0;
                double currency_to = 0;

                if (spinnerfrom.getSelectedItem().toString() == "INR") {
                    currency_from = Double.parseDouble(INR.getText().toString().substring(8, 13));

                } else if (spinnerfrom.getSelectedItem().toString() == "EUR") {
                    currency_from = 1;

                } else {
                    Toast.makeText(getApplicationContext(), "Select Currency", Toast.LENGTH_LONG).show();
                }

                if (spinnerTo.getSelectedItem().toString() == "USD") {
                    currency_to = Double.parseDouble(USD.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "INR") {
                    currency_to = Double.parseDouble(INR.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "AUD") {
                    currency_to = Double.parseDouble(AUD.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "NZD") {
                    currency_to = Double.parseDouble(NZD.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "JPY") {
                    currency_to = Double.parseDouble(JPY.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "MXN") {
                    currency_to = Double.parseDouble(MXN.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "GBP") {
                    currency_to = Double.parseDouble(GBP.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "DKK") {
                    currency_to = Double.parseDouble(DKK.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "HKD") {
                    currency_to = Double.parseDouble(HKD.getText().toString().substring(8, 13));
                }
                if (spinnerTo.getSelectedItem().toString() == "RUB") {
                    currency_to = Double.parseDouble(RUB.getText().toString().substring(8, 13));
                }


                if (currency_from != 0 && currency_to != 0) {
                    double ratio = currency_to / currency_from;
                    double cnvrtd = ratio * user_amount;
                    Toast.makeText(getApplicationContext(), (Double.toString(cnvrtd) + " " + spinnerTo.getSelectedItem().toString()), Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Select Curr", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

            }
        });
    }


    private void getExchangeRate() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PostList> call = apiInterface.getCurrency();

        call.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                txt_lastupd.setText(response.body().getTime_last_update_utc());
                GBP.setText("GBP : " + " " + response.body().getConversion_rates().getGbp());
                HKD.setText("HKD : " + " " + response.body().getConversion_rates().getHkd());
                AUD.setText("AUD : " + " " + response.body().getConversion_rates().getAud());
                USD.setText("USD : " + " " + response.body().getConversion_rates().getUsd());
                INR.setText("INR : " + " " + response.body().getConversion_rates().getInr());
                JPY.setText("JPY : " + " " + response.body().getConversion_rates().getJpy());
                MXN.setText("MXN : " + " " + response.body().getConversion_rates().getMxn());
                NZD.setText("NZD : " + " " + response.body().getConversion_rates().getNzd());
                RUB.setText("RUB : " + " " + response.body().getConversion_rates().getRub());
                DKK.setText("DKK : " + " " + response.body().getConversion_rates().getDkk());


            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Rate not found", Toast.LENGTH_LONG).show();
            }
        });
    }
}



