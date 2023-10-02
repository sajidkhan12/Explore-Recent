package com.example.pagernew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

public class Recent extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] courses = { "C", "Data structures",
            "Interview prep", "Algorithms",
            "DSA with java", "OS" };
    EditText editText1;
    TextView text1,onekm,hundredkm;


    SeekBar seekBar;
    int currentprogress;
    String mintprogressbar;
    Slider slider;
    LabelFormatter formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        text1=findViewById(R.id.text1);
        onekm=findViewById(R.id.onekm);
        hundredkm=findViewById(R.id.hundredkm);

        slider=findViewById(R.id.slider);


        Toolbar toolbar=findViewById(R.id.toolbar);
        editText1=findViewById(R.id.edittext1);

        int unicode=0x1F600	;
        String emoji=getEmoji(unicode);
        String text="Hi community!I am open to new connections"+" \""+emoji+"\" ";

        editText1.setText(text);

        int l=editText1.getText().length();
        String c=String.valueOf(l);
        text1.setText(c);


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length=editText1.length();
                String convert=String.valueOf(length);
                text1.setText(convert);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText1.setBackgroundResource(R.color.white);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Refine");
        actionBar.setHomeAsUpIndicator(R.drawable.back_arrow_24);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#131837"));

        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Spinner spino = (Spinner) findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,courses);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spino.setAdapter(aa);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public String getEmoji(int uni){
        return new String(Character.toChars(uni));

    }
    }
