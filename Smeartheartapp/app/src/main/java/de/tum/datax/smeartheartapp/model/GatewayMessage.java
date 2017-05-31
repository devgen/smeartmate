package de.tum.datax.smeartheartapp.model;

/**
 * Created by Devgen on 21.09.2016.
 */

public class GatewayMessage {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    GatewayMessage(long id){
        this.id = id;
    }

}
