package com.jsonstore.actionbarsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<String>();
        list.add("India");
        list.add("Pakistan");
        list.add("Australia");
        list.add("South Africa");
        list.add("Nepal");
        list.add("Bangladesh");
        list.add("Sri Lanka");
        list.add("Italy");
        list.add("London");
        list.add("America");
        list.add("California");
        list.add("Virginia");
        list.add("Salt Lake");
        list.add("Washington DC");
        list.add("Los Angeles");
        list.add("Johanasberg");
        list.add("Paris");
        list.add("Altanta");
        list.add("Wakanda");
        list.add("Japan");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(position)+" is Selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        /*getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_icon);*/
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_icon:
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setQueryHint("Search Here!");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        arrayAdapter.getFilter().filter(newText);
                        return true;
                    }
                });
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
