package com.example.android_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity<target> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] values = new String[]{"Pies",
                "Kot", "Koń", "Gołąb", "Kruk", "Dzik", "Karp",
                "Osioł", "Chomik", "Mysz", "Jeż", "Kraluch"};

        this.target = new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));

        this.adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, this.target);


        ListView listview = (ListView) findViewById(
                R.id.list);
        listview.setAdapter(this.adapter);


    }

    private ArrayList<String> target;
    private ArrayAdapter adapter;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;



        }

    public void nowyWpis(MenuItem mi)
    {
        Intent intencja = new Intent(this,
                DodajWpis.class);
        startActivityForResult(intencja, 1);
    }


    protected void onActivityResult(
            int requestCode, int resultCode, Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            String nowy = (String)extras.get("wpis");
            target.add(nowy);
            adapter.notifyDataSetChanged();
        }
    }
}



//komentarz
