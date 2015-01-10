package net.na.an;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerListener extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String json = msg.toString();
		ChatMessage chatMessage= ChatMessageConverter.convertFromJson(json);
		if(chatMessage.getChatAction().equals(ChatAction.LOGIN)) {
			ClientDatabase.login(ctx.channel());
			ClientDatabase.chatJava7(ctx.channel(), json);
		}else if(chatMessage.getChatAction().equals(ChatAction.LOGOUT)) {
			ClientDatabase.logout(ctx.channel());
			ClientDatabase.chatJava7(ctx.channel(), json);
			ctx.channel().close();
		}else if(chatMessage.getChatAction().equals(ChatAction.CHAT)){
			ClientDatabase.chat(ctx.channel(), json);
		}
	}

}
