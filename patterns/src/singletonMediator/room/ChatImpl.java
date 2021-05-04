package singletonMediator.room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import singletonMediator.bot.Bot;
import singletonMediator.bot.CatBot;
import singletonMediator.bot.SpamBot;

public class ChatImpl implements Chat {
	/*
	 * I'm using CopyOnWriteArrayList because it's thread-safe and doesn't need any explicit synchronization
	 * I got ConcurrentModificationException when I remove user in Bot, because ArrayList is not thread-safe.
	 * Some thread is traversed over the collection using iterator.next()
	 * There are a lot of solutions for this problem in multithreaded programming.
	 * Some of the solution I know is using ConcurrentHashMap or Array
	 * or simply change the business logic between Bot and Chat
	 */
	private CopyOnWriteArrayList<User> users;
	private Set<Bot> bots;

	public ChatImpl() {
		this.users = new CopyOnWriteArrayList<>();
		this.bots = new HashSet<>();
	}

	private Bot checkMessage(String message) {
		if (message.contains("addBot")) {
			return CatBot.getInstance();
		}else if(message.contains("spamBot")) {
			return SpamBot.getInstance();
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void sendMessage(String message, User user) {
		Bot bot = checkMessage(message);
		boolean checkBots = false;
		if (bot != null) {
			addBot(bot);
		}
		if (!bots.isEmpty()) {
			checkBots = true;
		}
		for (User u : this.users) {
			if (u != user) {
				u.receive(message);
			}else {
				if (checkBots) {
					for (Bot b : bots) {
						message = b.checkMessage(message, this.users, user);
					}
				}
			}
		}

	}

	@Override
	public void addBot(Bot bot) {
		this.bots.add(bot);
		System.out.println("BOT ADDED");
	}

}
