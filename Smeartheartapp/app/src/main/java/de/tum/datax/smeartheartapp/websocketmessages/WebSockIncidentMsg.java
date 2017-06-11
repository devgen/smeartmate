package de.tum.datax.smeartheartapp.websocketmessages;

import java.util.Date;

/**
 * Created by Devgen on 11.06.2017.
 */

public class WebSockIncidentMsg extends WebSockMsg {

    private byte[] audioRecord;




    public WebSockIncidentMsg(Date date, byte[] audioRecord) {
        super(date);
        this.audioRecord = audioRecord;
    }

    public byte[] getAudioRecord() {
        return audioRecord;
    }

    public void setAudioRecord(byte[] audioRecord) {
        this.audioRecord = audioRecord;
    }
}
