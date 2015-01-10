package net.na.an;

import java.util.Date;

public class ChatMessage {

	private String message;
	private String sender;
	private ChatAction chatAction;
	private Date dateSender;

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

	public Date getDateSender() {
		return dateSender;
	}

	public void setDateSender(Date dateSender) {
		this.dateSender = dateSender;
	}

	public ChatAction getChatAction() {
		return chatAction;
	}

	public void setChatAction(ChatAction chatAction) {
		this.chatAction = chatAction;
	}

}
