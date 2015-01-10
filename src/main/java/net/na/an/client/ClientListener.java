package net.na.an.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.na.an.ChatAction;
import net.na.an.ChatMessage;
import net.na.an.ChatMessageConverter;
import net.na.an.ClientDatabase;

public class ClientListener extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String json = msg.toString();
		ChatMessage chatMessage = ChatMessageConverter.convertFromJson(json);
		if (chatMessage.getChatAction().equals(ChatAction.LOGIN)) {
			String pesan =chatMessage.getSender()+ " masuk chat room";
			System.out.println(pesan);
		} else if (chatMessage.getChatAction().equals(ChatAction.LOGOUT)) {
			String pesan =chatMessage.getSender()+ " keluar chat room";
			System.out.println(pesan);
		} else if (chatMessage.getChatAction().equals(ChatAction.CHAT)) {
			String pesan =chatMessage.getSender()+ " : " + chatMessage.getMessage();
			System.out.println(pesan);
		}
	}

}
