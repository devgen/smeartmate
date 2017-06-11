package de.tum.datax.smeartheartapp.websocketmessages;

import java.util.Date;

/**
 * Created by Devgen on 11.06.2017.
 */

public class WebSockMsg {

    private Date date;

    public WebSockMsg(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
