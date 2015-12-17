package com.tugbacevizci.currency;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.widget.EditText;

public class MainActivity extends Activity {

    private TextView dovizTuru_tv, alis_tv, satis_tv;
    private EditText alis_dolar_et, alis_euro_et, alis_gold_et, satis_dolar_et, satis_euro_et, satis_gold_et;
    private Button refresh_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dovizTuru_tv = (TextView) findViewById(R.id.dovizTuru_textView);
        alis_tv = (TextView) findViewById(R.id.alis_textView);
        satis_tv = (TextView) findViewById(R.id.satis_textView);

        alis_dolar_et = (EditText) findViewById(R.id.alis_dolar_editText);
        alis_euro_et = (EditText) findViewById(R.id.alis_euro_editText);
        alis_gold_et = (EditText) findViewById(R.id.alis_gold_editText);

        satis_dolar_et = (EditText) findViewById(R.id.satis_dolar_editText);
        satis_euro_et = (EditText) findViewById(R.id.satis_euro_editText);
        satis_gold_et = (EditText) findViewById(R.id.satis_gold_editText);

        refresh_btn = (Button) findViewById(R.id.refresh_btn);
    }
}