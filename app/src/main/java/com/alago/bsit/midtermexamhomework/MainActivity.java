package com.alago.bsit.midtermexamhomework;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alago.bsit.midtermexamhomework.Fragments.ListviewFragment;

public class MainActivity extends AppCompatActivity  {


    private Button button;
    private EditText text;
    private Context context = this;


    private ListviewFragment mListviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListviewFragment = ListviewFragment.newInstance();

        text = (EditText) findViewById(R.id.edtSearch);
        button = (Button) findViewById(R.id.btnSearch);




        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mListviewFragment)
                .commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        if (id == R.id.action_refresh) {
            return true;
        }
        if(id == R.id.action_search){
//            final Dialog dialog = new Dialog(MainActivity.this);
//            dialog.setContentView(R.layout.activity_searchdialogbox);
//            dialog.setTitle("Search Something");
//            dialog.show();
            final AlertDialog.Builder inputAlert = new AlertDialog.Builder(context);
            inputAlert.setTitle("SEARCH");
            inputAlert.setMessage("Search by");
            final EditText userInput = new EditText(context);
            inputAlert.setView(userInput);
            inputAlert.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String input = userInput.getText().toString();
                    Intent i = new Intent(MainActivity.this, BookInfo.class);
                    i.putExtra("TITLE", input);
                    startActivity(i);

                }
            });
            inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = inputAlert.create();
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }




}
