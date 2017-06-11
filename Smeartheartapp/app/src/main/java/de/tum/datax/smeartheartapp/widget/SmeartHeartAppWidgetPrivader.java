package de.tum.datax.smeartheartapp.widget;

import android.Manifest;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.media.MediaRecorder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;


import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;

import java.io.IOException;

import de.tum.datax.smeartheartapp.R;
import de.tum.datax.smeartheartapp.recorder.AudioRecordTest;
import de.tum.datax.smeartheartapp.recorder.RecorderActivity;

/**
 * Implementation of App Widget functionality.
 */
public class SmeartHeartAppWidgetPrivader extends AppWidgetProvider {


    public static String SYNC_CLICKED = "record";



    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;

    //private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;



    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};



    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        CharSequence widgetText = context.getString(R.string.appwidget_txt1);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.smeart_heart_app_widget_privader);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


        RemoteViews remoteViews;
        ComponentName watchWidget;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.smeart_heart_app_widget_privader);
        watchWidget = new ComponentName(context, SmeartHeartAppWidgetPrivader.class);

        remoteViews.setOnClickPendingIntent(R.id.button2, getPendingSelfIntent(context, SYNC_CLICKED));
        appWidgetManager.updateAppWidget(watchWidget, remoteViews);

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created





    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled

    }


    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (SYNC_CLICKED.equals(intent.getAction())) {

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.smeart_heart_app_widget_privader);
            watchWidget = new ComponentName(context, SmeartHeartAppWidgetPrivader.class);

            remoteViews.setTextViewText(R.id.button2, "TESTING");

            appWidgetManager.updateAppWidget(watchWidget, remoteViews);

            boolean mStartRecording = true;

            if (mStartRecording) {
                remoteViews.setTextViewText(R.id.button2, "Stop recording");
                intent = new Intent (context, RecorderActivity.class);
                intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity (intent);
                remoteViews.setTextViewText(R.id.button2, "Start recording");
            } else {

                intent = new Intent (context, RecorderActivity.class);
                intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity (intent);
                remoteViews.setTextViewText(R.id.button2, "Start recording");
            }
            mStartRecording = !mStartRecording;
            appWidgetManager.updateAppWidget(watchWidget, remoteViews);


        }
    }






}




