package com.example.ceramicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.ceramicapplication.DataModel;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    Button btnback,btnorders;


    android.widget.GridView gridView;
    String strLang[] = {"ceramic bearing", "flower pot", "pot", "tiles","tubes"};
    int imgData[] = {R.drawable.bearing,R.drawable.fp,R.drawable.pot,
            R.drawable.tiles,R.drawable.tubes};

    ArrayList<DataModel>dataModelArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        btnback =(Button)findViewById(R.id.btnback);
        btnorders=(Button)findViewById(R.id.btnorders);

        btnorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GridViewActivity.this,Orders.class);
                startActivity(i);
                finish();
            }
        });

        gridView = (android.widget.GridView)findViewById(R.id.grid);
        dataModelArrayList = new ArrayList<DataModel>();
        for (int i = 0; i<strLang.length; i++)
        {
            DataModel dataModel = new DataModel(strLang[i], imgData[i]);
            dataModelArrayList.add(dataModel);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,dataModelArrayList,"Grid");
        gridView.setAdapter(myBaseAdapter);

    }
}