package singletonMediator.room;

public class ChatUser extends User {
	
	

	public ChatUser(Chat chat, String name) {
		super(chat, name);
		chat.addUser(this);
	}

	@Override
	public void send(String message) {
		System.out.println("-"+this.name + " sends: " + message);
		this.chat.sendMessage(message, this);
	}

	@Override
	public void receive(String message) {
		System.out.println("-"+this.name + " received: " + message);
		
	}

}
