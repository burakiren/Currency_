package com.tugbacevizci.currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.widget.EditText;

public class MainActivity extends Activity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.dovizTuru_textView);
        textView = (TextView)findViewById(R.id.alis_textView);
        textView = (TextView)findViewById(R.id.satis_textView);

        editText = (EditText)findViewById(R.id.alis_dolar_editText);
        editText = (EditText)findViewById(R.id.alis_euro_editText);
        editText = (EditText)findViewById(R.id.alis_gold_editText);

        editText = (EditText)findViewById(R.id.satis_dolar_editText);
        editText = (EditText)findViewById(R.id.satis_euro_editText);
        editText = (EditText)findViewById(R.id.satis_gold_editText);
    }
}
