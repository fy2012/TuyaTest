package com.example.tuyatest;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.tuya.smart.config.TuyaConfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    TextInputEditText ssidInput;
    TextInputEditText passwordInput;
    TextInputEditText tokenInput;
    Button button;
    Boolean isStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isStarted = false;

        ssidInput = (TextInputEditText) findViewById(R.id.ssidInput);
        passwordInput = (TextInputEditText) findViewById(R.id.pwdInput);
        tokenInput = (TextInputEditText) findViewById(R.id.tokenInput);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStarted) {
                    String ssid = ssidInput.getText().toString();
                    String password = passwordInput.getText().toString();
                    String token = tokenInput.getText().toString();
                    button.setText("STOP");
                    TuyaConfig.getEZInstance().startConfig(ssid, password, token);
                    isStarted = true;
                }
                else{
                    button.setText("SEND");
                    TuyaConfig.getEZInstance().stopConfig();
                    isStarted = false;
                }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
