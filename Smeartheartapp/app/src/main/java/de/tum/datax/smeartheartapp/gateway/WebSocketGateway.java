package de.tum.datax.smeartheartapp.gateway;

import android.util.Log;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;

/**
 * Created by Devgen on 23.09.2016.
 */

public class WebSocketGateway {

    private static final String TAG = "websocket";
    private final WebSocketConnection mConnection ;
    private static WebSocketGateway webSocketGateway;

    private WebSocketGateway(){

        this.mConnection  = new WebSocketConnection();
    }
    public static WebSocketGateway getWebSocketGateway(){

        if(webSocketGateway==null) {
            webSocketGateway = new WebSocketGateway();
        }
        return webSocketGateway;
    }

    public void start() {

        final String wsuri = "ws://192.168.179.27:8080/smeartheartmate-0.0.1-SNAPSHOT/websocket/123";

        try {
            mConnection.connect(wsuri, new WebSocketHandler() {

                @Override
                public void onOpen() {
                    Log.d(TAG, "Status: Connected to " + wsuri);
                    mConnection.sendTextMessage("Hello, world!");
                }

                @Override
                public void onTextMessage(String payload) {
                    Log.d(TAG, "Got echo: " + payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.d(TAG, "Connection lost." + reason);
                }
            });
        } catch (WebSocketException e) {

            Log.d(TAG, e.toString());
        }
    }

    private void  stop(){
        mConnection.disconnect();
    }

    public   void send(String test){
        mConnection.sendTextMessage(test);
    }



}
