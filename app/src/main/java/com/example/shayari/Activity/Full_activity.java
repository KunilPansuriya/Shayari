package com.example.shayari.Activity;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.shayari.Adapter.GradientAdapter;
import com.example.shayari.Adapter.config;
import com.example.shayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;



public class Full_activity extends AppCompatActivity implements  OnClickListener {


    GradientAdapter adapter;
    ImageView next,back,btn1,btn2,Edit;
    GridView gridView;
    TextView textView;
    int position;
    String temp1[];
    TextView t1;




    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        textView = findViewById(R.id.txt1);
        next = findViewById(R.id.b_right);
        back = findViewById(R.id.b_lift);
        t1 = findViewById(R.id.t1);
        btn1=findViewById(R.id.b1);
        btn2=findViewById(R.id.b2);
        Edit=findViewById(R.id.edit);
        gridView=findViewById(R.id.gridView_gradient);
        View share2 = findViewById(R.id.share2);
        
        
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        Edit.setOnClickListener(this);


        position = getIntent().getIntExtra("pos", 0);
        temp1 = getIntent().getStringArrayExtra("temp1");
        textView.setText(temp1[position]);
        t1.setText((position + 1) + "/" + temp1.length);

        final String appPackageName = getPackageName();

        share2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Cheak this App \n"+"https://play.google.com/store/apps/details?id=com.loveshayarisn" + appPackageName);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent , "Share This App"));
            }
        });

    }
    @Override
    public void onClick(View v)
    {
        if (v.getId() == next.getId()) {
            if (position < temp1.length - 1) {
                position++;
                t1.setText((position + 1) + "/" + temp1.length);
                textView.setText(temp1[position]);
            }
        }
        if (v.getId() == back.getId()) {
            if (position > 0) {
                position--;
                t1.setText((position + 1) + "/" + temp1.length);
                textView.setText(temp1[position]);
            }
        }
        if (v.getId() == btn1.getId())
        {
            Log.d("TTT", "onClick: ");
            BottomSheetDialog dialog = new BottomSheetDialog(Full_activity.this);
            dialog.setContentView(R.layout.gradient_layout);
            GridView gridView = dialog.findViewById(R.id.gridView_gradient);
            adapter = new GradientAdapter(Full_activity.this, config.gradArr);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setBackgroundResource(config.gradArr[i]);
                    dialog.dismiss();
                }
            });
            dialog.show();


        }
        if(v.getId()==btn2.getId())
        {
            int min=0,max=config.gradArr.length;
            int r=new Random().nextInt(max-min)+min;
            textView.setBackgroundResource(config.gradArr[r]);
        }
        if(v.getId()==Edit.getId())
        {
            Intent intent=new Intent(Full_activity.this, Edit_activity.class);
            intent.putExtra("pos",position);
            intent.putExtra("temp1", temp1);
            startActivity(intent);
        }



    }
}