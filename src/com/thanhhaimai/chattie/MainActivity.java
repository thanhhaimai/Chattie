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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class MainActivity extends Activity {

    ListView messsagesList;
    Button sendButton;
    EditText chatInput;
    ArrayAdapter<String> messagesAdapter;

    Firebase roomRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomRef = new Firebase("https://chattie.firebaseio.com/room/0/");
        roomRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot data) {
                String msg = data.getName();
                messagesAdapter.add(msg);
            }

            @Override
            public void onCancelled() {
            }
        });

        messsagesList = (ListView) findViewById(R.id.messageList);
        messagesAdapter = new ArrayAdapter<String>(this, R.layout.message_row,
                R.id.message);
        messsagesList.setAdapter(messagesAdapter);

        chatInput = (EditText) findViewById(R.id.chatInputEditText);

        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = chatInput.getText().toString();
                chatInput.setText("");

                // messagesAdapter.add(msg);
                Firebase newMessage = roomRef.push();
                newMessage.setValue(v);

                newMessage.setValue(msg);
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
