package singletonMediator.room;

public abstract class User {
	
	protected Chat chat;
	protected String name;
	
	public User(Chat chat, String name) {
		this.chat = chat;
		this.name = name;
	}
	
	public abstract void send(String message);
	public abstract void receive(String message);
	
	public String getName() {
		return this.name;
	};

}
