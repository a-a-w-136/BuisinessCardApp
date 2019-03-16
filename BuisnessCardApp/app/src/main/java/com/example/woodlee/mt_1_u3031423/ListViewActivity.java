package com.example.woodlee.mt_1_u3031423;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<BusinessCard> cards = new ArrayList<BusinessCard>();

    BusCarDbHelper mydb = new BusCarDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        cards = mydb.getAllCards();
        if (cards.isEmpty()) {
            mydb.insertCard(new BusinessCard("John Smith", R.drawable.bs_john_smith, "CEO", "ECommerce", "jonnysmith@mail.com", "555 555", "www.Ecommerce.com"));
            mydb.insertCard(new BusinessCard("Tanner Smith", R.drawable.bs_john_smith, "Maneger", "ECommerce", "tannersmith@mail.com", "555 554", "www.Ecommerce.com"));
            mydb.insertCard(new BusinessCard("Genie Smith", R.drawable.bs_john_smith, "Accounts", "ECommerce", "geniesmith@mail.com", "555 553", "www.Ecommerce.com"));
            cards = mydb.getAllCards();
        }
        BusCarAdapter adapter = new BusCarAdapter(
                this, R.layout.my_listview_item , cards);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        BusinessCard card = cards.get(position);
                        Intent intent = new Intent(view.getContext(), CardDetailsActivity.class);
                        intent.putExtra("id", card.getId());
                        intent.putExtra("name", card.getName());
                        intent.putExtra("imageResource", card.getImageResource());
                        intent.putExtra("jobTitle", card.getJobTitle());
                        intent.putExtra("company", card.getCompany());
                        intent.putExtra("email", card.getEmail());
                        intent.putExtra("phone", card.getPhone());
                        intent.putExtra("webSite", card.getWebsite());
                        startActivity(intent);
                    }
                });

    }
    public void gotoAdd(View view) {
        Intent intent = new Intent(this, AddImageActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.report) {
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        }
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
