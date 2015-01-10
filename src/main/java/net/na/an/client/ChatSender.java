package net.na.an.client;

import java.util.Date;
import java.util.Scanner;

import io.netty.channel.Channel;
import net.na.an.ChatAction;
import net.na.an.ChatMessage;
import net.na.an.ChatMessageConverter;

public class ChatSender {
	/**
	 * Scanner digunakan untuk menerima input dari user
	 */
	private Scanner input = new Scanner(System.in);

	private String username;

	/**
	 * Menjalankan chat sender
	 * 
	 * @param server server channel
	 */
	public void run(Channel server) {
		while (true) {
			// membaca pesan yang diketikkan user
			String message = input.nextLine();
			if (message.startsWith("login") && username == null) {
				// login user
				username = message.substring("login".length()).trim();
				sendLoginMessage(server);
			} else if (message.equals("logout")) {
				// logout user
				sendLogoutMessage(server);
				// selesai
				break;
			} else {
				// chat user
				sendChatMessage(server, message);
			}
		}
	}

	private void sendChatMessage(Channel server, String message) {
		// buat objek chat message
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setChatAction(ChatAction.CHAT);
		chatMessage.setDateSender(new Date());
		chatMessage.setSender(username);
		chatMessage.setMessage(message); // jangan lupa pesannya

		// konver ke json dan kirim ke server
		String json = ChatMessageConverter.convertToJson(chatMessage);
		server.writeAndFlush(json);

	}

	private void sendLogoutMessage(Channel server) {
		// buat objek chat message
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setChatAction(ChatAction.LOGOUT);
		chatMessage.setDateSender(new Date());
		chatMessage.setSender(username);

		// konver ke json dan kirim ke server
		String json = ChatMessageConverter.convertToJson(chatMessage);
		server.writeAndFlush(json);

	}

	private void sendLoginMessage(Channel server) {
		// buat objek chat message
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setChatAction(ChatAction.LOGIN);
		chatMessage.setDateSender(new Date());
		chatMessage.setSender(username);

		// konver ke json dan kirim ke server
		String json = ChatMessageConverter.convertToJson(chatMessage);
		server.writeAndFlush(json);

	}

}
