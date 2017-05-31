package de.tum.datax.smeartheartapp.backgroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Devgen on 21.09.2016.
 */

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent myIntent = new Intent(context, MyService.class);
            context.startService(myIntent);
        }

    }
}



