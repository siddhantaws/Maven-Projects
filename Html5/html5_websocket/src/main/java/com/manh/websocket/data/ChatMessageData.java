package com.manh.websocket.data;

import java.util.Date;

public class ChatMessageData 
{
	private String message;
	private String sender;
	private Date received;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getReceived() {
		return received;
	}
	public void setReceived(Date received) {
		this.received = received;
	}
	
}	
