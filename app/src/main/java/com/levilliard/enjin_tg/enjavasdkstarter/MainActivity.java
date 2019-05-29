package com.levilliard.enjin_tg.enjavasdkstarter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.enjin.enjincoin.sdk.Client;
import com.enjin.enjincoin.sdk.Clients;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String secret = "K55JQLjWD36kBBv3rIF05Ts8kTIGn66NVHt4aWlr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        try {
            Client client = createAndAuthClient(secret);
            Log.d("Client Code: ", client.getAppId() + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public Client createSdkClient() {
        return Clients.createClient("https://kovan.cloud.enjin.io/", 307, true);
    }

    public Client createAndAuthClient(String secret) throws IOException {
        Client client = createSdkClient();
        client.auth(secret);
        return client;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
