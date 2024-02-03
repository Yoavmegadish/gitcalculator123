package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvshow;
    double num =0;
    double savenum =0;
    String messege="";
    double total = 0;
    String op="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvshow=(TextView)findViewById(R.id.tv);
    }


    public void onclick(View view)
    {

        Button btn = (Button)view;

        if (view.getId() == R.id.btnplus) {
            op = "+";
            messege += "+";
            tvshow.setText(messege);
            savenum = num;
            num = 0;
        } else if (view.getId() == R.id.btndiv) {
            op = "/";
            messege += "/";
            tvshow.setText(messege);
            savenum = num;
            num = 0;
        } else if (view.getId() == R.id.btnmin) {
            op = "-";
            messege += "-";
            tvshow.setText(messege);
            savenum = num;
            num = 0;
        } else if (view.getId() == R.id.btnmin) {
            op = "*";
            messege += "*";
            tvshow.setText(messege);
            savenum = 0;
            num = 0;
        } else if (view.getId() == R.id.btnc) {
            messege = "0";
            tvshow.setText(messege);
            savenum = num;
            num = 0;
        } else if (view.getId() == R.id.btnabslt) {
            op = "(-";
            messege = "(-";
            savenum = num;
            num = 0;
        }
        else  {

            num = num * 10 + Double.parseDouble(btn.getText().toString());
            messege += btn.getText().toString();
            tvshow.setText(messege);
        }

    }

    public void result(View v)
    {

        if(op.equals("+"))
        {
            total=savenum + num;
        }
        else if(op.equals("(-"))
        {
            total=savenum*(-1);
        }
        else if(op.equals("-"))
        {
            total=savenum - num;
        }
        else if(op.equals("/"))
        {
            if(num !=0)
                total=savenum / num;
            else
            {
                tvshow.setText("undefinded");
                return;
            }
        }
        else if(op.equals("*"))
        {
            total=savenum * num;
        }
        if(total>999999999 || total < -999999999)
        {
            tvshow.setText("to big");
        }
        else if(op.equals("="))
        {
            tvshow.setText(messege + "=" + total);
            return;
        }
        tvshow.setText(String.valueOf(total));

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        double end = Double.parseDouble(tvshow.getText().toString());
    }


}