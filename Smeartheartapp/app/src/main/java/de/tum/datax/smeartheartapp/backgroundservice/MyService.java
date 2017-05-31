package de.tum.datax.smeartheartapp.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.devgen.gateway.UDPGateway;
import com.example.devgen.gateway.WebSocketGateway;

/**
 * Created by Devgen on 21.09.2016.
 */

public class MyService extends Service {

    private UDPGateway udpGateway;
    private  WebSocketGateway webSocketGateway;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if (udpGateway!=null){
            //udpGateway.stopUDPServer();

        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        //udpGateway = new UDPGateway();
       // udpGateway.startUDPLisner();
        webSocketGateway = WebSocketGateway.getWebSocketGateway();
        webSocketGateway.start();
        Log.i("UDP", "Service started");

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
