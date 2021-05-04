package singletonMediator.bot;

import java.util.List;

import singletonMediator.room.User;
import singletonMediator.util.RegexHelper;

public class SpamBot implements Bot {
	
	private static final String BOT_NAME = "Spam bot";
	private static SpamBot spamBotInstance;
	private RegexHelper rh;
	
	public SpamBot() {
		rh = new RegexHelper();
	}
	
	public static SpamBot getInstance() {
		if(spamBotInstance == null) {
			spamBotInstance = new SpamBot();
		}
		return spamBotInstance;
	}

	@Override
	public String checkMessage(String message, List<User> users, User u) {

		boolean isMatch = rh.findMatch(message, "My");

		if(isMatch) {
			send(u.getName(), message);
		}
		
		
		return message;
	}

	@Override
	public void send(String message, String matches) {
		for (int i = 0; i < message.length(); i++) {
			System.out.println(BOT_NAME + ": " + message + " told: " + matches);
		}	
	}
}
