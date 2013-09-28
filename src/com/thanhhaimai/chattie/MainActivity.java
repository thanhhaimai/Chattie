package com.thanhhaimai.chattie;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView messsagesList;
    ArrayAdapter<String> messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messsagesList = (ListView) findViewById(R.id.messageList);
        messagesAdapter = new ArrayAdapter<String>(this, R.layout.message_row,
                R.id.message);
        messagesAdapter.addAll("a", "b", "c");
        messsagesList.setAdapter(messagesAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
