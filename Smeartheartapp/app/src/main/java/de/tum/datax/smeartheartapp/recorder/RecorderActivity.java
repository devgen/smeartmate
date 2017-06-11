package de.tum.datax.smeartheartapp.recorder;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.tum.datax.smeartheartapp.R;
import de.tum.datax.smeartheartapp.gateway.WebSocketGateway;
import de.tum.datax.smeartheartapp.websocketmessages.WebSockIncidentMsg;
import de.tum.datax.smeartheartapp.websocketmessages.WebSockMsg;

import static java.util.Calendar.DATE;

public class RecorderActivity extends AppCompatActivity {


    private static final String LOG_TAG = "RecordActivity";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;
    private String fileName = "incident.mp3";

    private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;


    private PlayButton   mPlayButton = null;
    private MediaPlayer   mPlayer = null;


    private SendButton sendButton = null;





    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) finish();

    }



    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }




    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }




    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    class RecordButton extends android.support.v7.widget.AppCompatButton {
        boolean mStartRecording = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    setText("Stop recording");
                } else {
                    setText("Start recording");
                }
                mStartRecording = !mStartRecording;
            }
        };

        public RecordButton(Context ctx) {
            super(ctx);
            setText("Start recording");
            setOnClickListener(clicker);
        }
    }


    class PlayButton extends android.support.v7.widget.AppCompatButton {
        boolean mStartPlaying = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onPlay(mStartPlaying);
                if (mStartPlaying) {
                    setText("Stop playing");
                } else {
                    setText("Start playing");
                }
                mStartPlaying = !mStartPlaying;
            }
        };

        public PlayButton(Context ctx) {
            super(ctx);
            setText("Start playing");
            setOnClickListener(clicker);
        }
    }


    class SendButton extends android.support.v7.widget.AppCompatButton {


        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {

                FileInputStream arecord = null;
                try {
                    Log.e(LOG_TAG, "file not found path: "+getCacheDir()+ " file name: " + fileName);
                    //arecord = new FileInputStream(new File(getCacheDir(), fileName));
                    arecord = new FileInputStream(new File("/storage/emulated/0/Android//data/de.tum.datax.smeartheartapp/cache/", fileName));
                    byte[] buffer =   new byte[(int) arecord.getChannel().size()];
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd // ss ");
                    String strDate = "Current Date : " + mdformat.format(calendar.getTime());
                    DateFormat dateFormated = new SimpleDateFormat(" yyyy , MM , dd , ss", Locale.ENGLISH);
                    Date date = dateFormated.parse(strDate);
                    //byte[] bytesOfFile = IOUtils.toByteArray(arecord);
                    //WebSockIncidentMsg recordMsg = new WebSockIncidentMsg(date,bytesOfFile);

                    WebSocketGateway webSocketGateway = WebSocketGateway.getWebSocketGateway();
                    webSocketGateway.send(arecord.toString());
                    Log.e(LOG_TAG, "send");
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                e.printStackTrace();
            }

            }
        };

        public SendButton(Context ctx) {
            super(ctx);
            setText("Send record");
            setOnClickListener(clicker);
        }
    }




    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Record to the external cache directory for visibility
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/"+fileName;
        Log.e(LOG_TAG,mFileName);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        LinearLayout ll = new LinearLayout(this);
        mRecordButton = new RecordButton(this);
        ll.addView(mRecordButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        setContentView(ll);



        mPlayButton = new PlayButton(this);
        ll.addView(mPlayButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        setContentView(ll);


        sendButton = new SendButton(this);
        ll.addView(sendButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        setContentView(ll);

    }

    @Override
    public void onStop() {
        super.onStop();
        try {
            if (mRecorder != null) {
                mRecorder.stop();
                mRecorder.reset();
                mRecorder.release();
                mRecorder = null;
            }
            if (mPlayer != null) {
                mPlayer.stop();
                mPlayer.reset();
                mPlayer.release();
                mPlayer = null;
            }





        }
        catch (Exception e){
            Log.e(LOG_TAG, e.getMessage());
        }

    }

    public void sendARecord() {

    }

}
