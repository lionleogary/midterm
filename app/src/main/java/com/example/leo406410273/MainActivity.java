package com.example.leo406410273;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] strArray = new String[100];
    int temp=0;
    int index=0;
    int size=30;
    Button big;
    Button set;
    Button clear;
    Button small;
    TextView txv;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void bigger(View v){

        txv=findViewById(R.id.textView);
        txv.setTextSize(++size);
    }
    public void smaller(View v){

        txv=findViewById(R.id.textView);
        txv.setTextSize(--size);
    }
    public void set(View v){
        txv=findViewById(R.id.textView);
        set=findViewById(R.id.set);
        ed=findViewById(R.id.editText);
        strArray[index]=ed.getText().toString();
        SpannableStringBuilder style = new SpannableStringBuilder(strArray[index]+txv.getText().toString());
        if(index==0){
            style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        else if(index==1){
            style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.RED), strArray[index].length(), strArray[index-1].length()+strArray[index].length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        }
        else if(index==2){
            style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.RED), strArray[index].length(), strArray[index-1].length()+strArray[index].length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.GREEN), strArray[index-1].length()+strArray[index].length(), strArray[index-2].length()+strArray[index-1].length()+strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        else {
            style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.RED), strArray[index].length(), strArray[index-1].length()+strArray[index].length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.GREEN), strArray[index-1].length()+strArray[index].length(), strArray[index-2].length()+strArray[index-1].length()+strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            style.setSpan(new ForegroundColorSpan(Color.YELLOW), strArray[index-2].length()+strArray[index-1].length()+strArray[index].length(), strArray[index-3].length()+strArray[index-2].length()+strArray[index-1].length()+strArray[index].length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }



        txv.setMovementMethod(new ScrollingMovementMethod());
        txv.setText( style);
        index++;

    }
    public void clear(View v){
        clear=findViewById(R.id.clear);
        ed=findViewById(R.id.editText);
        ed.setText("");
    }
    public void reverse(View v){
        txv=findViewById(R.id.textView);
        String st="";
        if(temp%2==0){
            for(int i=index-1;i>=0;i--){

                st=strArray[i]+st;
            }

        }
        else{
            for(int i=0;i<=index-1;i++){

                st=strArray[i]+st;
            }
        }
        txv.setText(st);
        temp++;

    }

}
