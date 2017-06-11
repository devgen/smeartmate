package de.tum.datax.smeartheartapp.udpservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.devgen.R;
import com.example.devgen.backgroundservice.MyService;

public class MainActivity extends AppCompatActivity {

    TextView mytextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mytextView = (TextView) findViewById(R.id.message_test);
        Log.i("UDP MainActivity","start activity");
        mytextView.setText("start app");
        Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent);

    }


    public void writeMEssage(String message) {
        mytextView.setText(message);
    }
}