package net.na.an;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChatMessageConverter {

	private static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yy HH:mm:ss").create();

	public static String convertToJson(ChatMessage chatMessage) {
		return gson.toJson(chatMessage);
	}

	public static ChatMessage convertFromJson(String json) {
		return gson.fromJson(json, ChatMessage.class);
	}

	/*
	 * public static PersonTest convertFromJson(String json, Class n) { return
	 * gson.fromJson(json, PersonTest.class); }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * String msg =
	 * "{\"salary\":600000.0,\"name\":\"Anton\",\"kota\":\"Jakarta\",\"id\":27}";
	 * 
	 * PersonTest p = ChatMessageConverter.convertFromJson(msg, PersonTest.class);
	 * 
	 * System.out.println(p.toString());
	 * 
	 * System.out.println("==============================");
	 * 
	 * ChatMessage cm = new ChatMessage(); cm.setSender(p.getName());
	 * cm.setMessage(p.getKota()+" "+p.getAge()); cm.setChatAction(ChatAction.CHAT);
	 * cm.setDateSender(new Date());
	 * 
	 * String s=ChatMessageConverter.convertToJson(cm);
	 * 
	 * System.out.println(s);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}

class PersonTest {

	private String name;
	private String kota;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonTest [name=" + name + ", kota=" + kota + ", age=" + age + "]";
	}
	

}