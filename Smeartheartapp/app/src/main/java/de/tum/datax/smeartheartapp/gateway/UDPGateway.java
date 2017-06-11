package de.tum.datax.smeartheartapp.gateway;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import de.tum.datax.smeartheartapp.model.GatewayMessage;
import de.tum.datax.smeartheartapp.settings.MySettings;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Devgen on 21.09.2016.
 */

public class UDPGateway {

    private boolean serverActive = true;
    private AsyncTask<Void, Void, Void> asyncTaskUdpServer;
    private String receivedMessage;
    private DatagramSocket socket;
    private DatagramPacket dp;

   public UDPGateway(){

    }


    public void startUDPLisner() {
    Log.i("UDP Gateway","Start to listen");
        asyncTaskUdpServer = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                if (socket == null || socket.isClosed()) {


                    String lText;
                    byte[] lMsg = new byte[1024];

                    dp = new DatagramPacket(lMsg, lMsg.length);
                    try {
                        socket = new DatagramSocket(MySettings.LOCAL_PORT);
                        socket.setBroadcast(true);

                        while (serverActive) {
                            socket.receive(dp);
                            Log.d("UDP packet received", dp.toString());
                            byte[] data = dp.getData();
                            ByteArrayInputStream in = new ByteArrayInputStream(data);
                            ObjectInputStream is = new ObjectInputStream(in);
                        }

                    } catch (SocketException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        if (socket != null) {
                            socket.close();
                        }
                    }
                }

                return null;
            }
        };

        if (Build.VERSION.SDK_INT >= 11)
            asyncTaskUdpServer.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            asyncTaskUdpServer.execute();

    }

    public void  stopUDPServer(){

        Log.i("UDP Gateway","stop to list");
        this.serverActive=false;
    }


    public void sendMessage(GatewayMessage gatewayPacket) {
        Log.d("GatewayController", " i try to send: " + gatewayPacket.toString());
        final String  messageForSend = gatewayPacket.toString();

        AsyncTask<Void, Void, Void> asyncTaskUdpClient = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                //String udpMsg = getewayPacket.encode();
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket();
                    ds.setBroadcast(true);

                    InetAddress serverAddr = InetAddress.getByName(MySettings.SERVER_ADRESS);
                    byte[] byteMsg = new byte[messageForSend.getBytes("UTF-8").length];
                    byteMsg = messageForSend.getBytes("UTF-8");

                    Log.d("send mess size:",Integer.toString(byteMsg.length));
                    DatagramPacket dp;
                    dp = new DatagramPacket(byteMsg, byteMsg.length,
                            serverAddr, MySettings.REMOTE_PORT);
                    ds.send(dp);
                    Log.d("GatewayController","message gesendet");
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (ds != null) {
                        ds.close();
                    }
                }
                return null;
            }
        };
        if (Build.VERSION.SDK_INT >= 11)
            asyncTaskUdpClient.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            asyncTaskUdpClient.execute();
    }


}
