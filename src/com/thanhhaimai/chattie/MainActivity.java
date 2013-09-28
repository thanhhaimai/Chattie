package com.thanhhaimai.chattie;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView messsagesList;
    Button sendButton;
    EditText chatInput;
    ArrayAdapter<String> messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messsagesList = (ListView) findViewById(R.id.messageList);
        messagesAdapter = new ArrayAdapter<String>(this, R.layout.message_row,
                R.id.message);
        messsagesList.setAdapter(messagesAdapter);

        chatInput = (EditText) findViewById(R.id.chatInputEditText);

        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                messagesAdapter.add(chatInput.getText().toString());
                chatInput.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
