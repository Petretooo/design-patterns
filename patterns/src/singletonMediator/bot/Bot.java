package singletonMediator.bot;

import java.util.List;

import singletonMediator.room.User;

public interface Bot {
	
	public String checkMessage(String message, List<User> users, User u);
	public void send(String message, String matches);
	
}
