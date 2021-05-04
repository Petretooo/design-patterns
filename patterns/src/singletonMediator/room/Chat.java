package singletonMediator.room;

import singletonMediator.bot.Bot;

public interface Chat {
	
	void addUser(User user);
	void sendMessage(String message, User user);
	void addBot(Bot bot);
	
}
