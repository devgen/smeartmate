package de.tum.datax.smeartheartapp.formular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import de.tum.datax.smeartheartapp.R;
import de.tum.datax.smeartheartapp.backgroundservice.MyService;

public class MainActivity extends AppCompatActivity {


 //   final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.visitPlaned);
  //  boolean bRequiresResponse = responseCheckbox.isChecked();


    TextView mytextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mytextView = (TextView) findViewById(R.id.message_test);
        Log.i("UDP MainActivity","start activity");
        mytextView.setText("Patient Report");
        Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent);

    }






    public void writeMEssage(String message) {
        mytextView.setText(message);
    }
}
