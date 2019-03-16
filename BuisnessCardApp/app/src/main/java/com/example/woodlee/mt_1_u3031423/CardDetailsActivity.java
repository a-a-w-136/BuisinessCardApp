package com.example.woodlee.mt_1_u3031423;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
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

        ImageView image = (ImageView) findViewById(R.id.detailsImage);
        TextView name = (TextView) findViewById(R.id.detailsName);
        TextView jobTitle = (TextView) findViewById(R.id.detailsJobTitle);
        TextView company = (TextView) findViewById(R.id.detailsCompany);
        TextView email = (TextView) findViewById(R.id.detailsEmail);
        TextView phone = (TextView) findViewById(R.id.detailsPhone);
        TextView website = (TextView) findViewById(R.id.detailsWebsite);

        Bundle extras = getIntent().getExtras();
        image.setImageResource(extras.getInt("imageResource"));
        name.setText("Name : " + extras.getString("name"));
        jobTitle.setText("Job Title : " + extras.getString("jobTitle"));
        company.setText("Company : " + extras.getString("company"));
        email.setText("Email : " + extras.getString("email"));
        phone.setText( "Phone : " + extras.getString("phone"));
        website.setText("Website : " + extras.getString("webSite"));
    }


    public void gotoeditview(View view) {
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent(this, EditCardActivity.class);
        intent.putExtra("imageResource",extras.getInt("imageResource"));
        intent.putExtra("id", extras.getLong("id"));
        intent.putExtra("name", extras.getString("name"));
        intent.putExtra("jobTitle", extras.getString("jobTitle"));
        intent.putExtra("company", extras.getString("company"));
        intent.putExtra("email", extras.getString("email"));
        intent.putExtra("phone", extras.getString("phone"));
        intent.putExtra("webSite", extras.getString("webSite"));
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
