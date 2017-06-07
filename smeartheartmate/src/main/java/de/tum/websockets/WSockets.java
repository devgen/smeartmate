package de.tum.websockets;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

import de.tum.websockets.messages.Message;
import de.tum.websockets.messages.MessageDecoder;
import de.tum.websockets.messages.MessageEncoder;

@ServerEndpoint(value = "/websocket/{userid}", decoders = { MessageDecoder.class }, encoders = { MessageEncoder.class })
public class WSockets {
	
	
	Logger log = Logger.getLogger(this.getClass());
	
	
	@OnOpen
	public void open(Session session, @PathParam("userid") String userid) {

		

	}
	
	@OnError
	public void onError(Throwable error) {
		//log.error("error on websocket" + error.toString());
	}
	
	
	@OnMessage
	public void handleMessage(Message message, Session session) {
		
	}

}
