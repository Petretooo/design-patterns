package singletonMediator.bot;

import java.util.List;

import singletonMediator.room.User;
import singletonMediator.util.RegexHelper;

public class CatBot implements Bot {
	
	private static final String BOT_NAME = "Cat bot";
	private static CatBot catBotInstance;
	private RegexHelper rh;
	
	public CatBot() {
		rh = new RegexHelper();
	}
	
	public static CatBot getInstance() {
		if(catBotInstance == null) {
			catBotInstance = new CatBot();
		}
		return catBotInstance;
	}
	

	@Override
	public String checkMessage(String message, List<User> users, User u) {
		
		boolean isMatch = rh.findMatch(message, "cat");
				
		if(isMatch) {
			users.remove(u);
			send(u.getName(), rh.getAllMatches());
		}
		
		return rh.getFixedText();
	}


	@Override
	public void send(String name, String matches) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s banned: %s", BOT_NAME, name));
		sb.append(System.lineSeparator());
		sb.append(String.format("Warning, the word/words - \"%s\" is/are forbidden to use!", matches.trim()));
		System.out.println(sb.toString().trim());
		
	}

}
