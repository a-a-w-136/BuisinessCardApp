package com.example.woodlee.mt_1_u3031423;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditCardActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
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
        ImageView image = (ImageView) findViewById(R.id.editImage);
        EditText name = (EditText) findViewById(R.id.editName);
        EditText jobTitle = (EditText) findViewById(R.id.editJobTitle);
        EditText company = (EditText) findViewById(R.id.editCompany);
        EditText email = (EditText) findViewById(R.id.editEmail);
        EditText phone = (EditText) findViewById(R.id.editPhone);
        EditText website = (EditText) findViewById(R.id.editWebsite);

        Bundle extras = getIntent().getExtras();

        image.setImageResource(extras.getInt("imageResource"));
        name.setText(extras.getString("name"), TextView.BufferType.EDITABLE);
        jobTitle.setText(extras.getString("jobTitle"), TextView.BufferType.EDITABLE);
        company.setText(extras.getString("company"), TextView.BufferType.EDITABLE);
        email.setText(extras.getString("email"), TextView.BufferType.EDITABLE);
        phone.setText(extras.getString("phone"), TextView.BufferType.EDITABLE);
        website.setText(extras.getString("webSite"), TextView.BufferType.EDITABLE);

    }

    public void returndetailsview(View view) {
        Intent intent = new Intent(this, CardDetailsActivity.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("imageResource",extras.getInt("imageResource"));
        intent.putExtra("id", extras.getInt("id"));
        intent.putExtra("name", extras.getString("name"));
        intent.putExtra("jobTitle", extras.getString("jobTitle"));
        intent.putExtra("company", extras.getString("company"));
        intent.putExtra("email", extras.getString("email"));
        intent.putExtra("phone", extras.getString("phone"));
        intent.putExtra("webSite", extras.getString("webSite"));
        startActivity(intent);
    }
    public void verifycontents(View view){

    }


    public void gotomainactivity(View view) {

        Bundle extras = getIntent().getExtras();
        EditText name = (EditText) findViewById(R.id.editName);
        EditText jobTitle = (EditText) findViewById(R.id.editJobTitle);
        EditText company = (EditText) findViewById(R.id.editCompany);
        EditText email = (EditText) findViewById(R.id.editEmail);
        EditText phone = (EditText) findViewById(R.id.editPhone);
        EditText webSite = (EditText) findViewById(R.id.editWebsite);

        BusinessCard updateCard = new BusinessCard(name.getText().toString(), extras.getInt("imageResource"),
                jobTitle.getText().toString(), company.getText().toString(), email.getText().toString(), phone.getText().toString(),
                webSite.getText().toString());
        BusCarDbHelper mydb = new BusCarDbHelper(this);

        mydb.updateCard(Long.toString(extras.getLong("id")), updateCard);

        Intent intent = new Intent(this, ListViewActivity.class);

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
