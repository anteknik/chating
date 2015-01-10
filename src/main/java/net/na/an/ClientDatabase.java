package net.na.an;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.Channel;

public class ClientDatabase {
	
	private static List<Channel> channels = new ArrayList<>();
	
	public static void login(Channel channel) {
		channels.add(channel);
	}
	
	public static void logout(Channel channel) {
		channels.remove(channel);
	}

	public static void chat(Channel sender, String json) {
		channels.stream()
				.filter(channel -> channel != sender)
				.forEach(channel -> channel.writeAndFlush(json));
	}
	
	public static void chatJava7(Channel sender, String json) {
		List<Channel> hasilFilter = new ArrayList<>();
		for(Channel chanel : channels) {
			if(chanel != sender) {
				hasilFilter.add(chanel);
			}
		}
		
		for(Channel channel:hasilFilter) {
			channel.writeAndFlush(json);
		}
	}
		
	
	
}
