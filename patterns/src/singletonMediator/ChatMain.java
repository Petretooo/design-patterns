package singletonMediator;

import singletonMediator.room.Chat;
import singletonMediator.room.ChatImpl;
import singletonMediator.room.ChatUser;
import singletonMediator.room.User;

public class ChatMain {
	
	public static void main(String[] args) {
		
		Chat chat = new ChatImpl();
		
		User user1 = new ChatUser(chat, "Ivan");
		User user2 = new ChatUser(chat, "Maria");
		User user3 = new ChatUser(chat, "George");
		
		user2.send("Hi guys");
		user2.send("Let me addBot");
		user2.send("Hey, let me tell you an amazing fact about my cat. My cAT is so curious..");
		user3.send("What is the name of your cat?");
		user1.send("Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!");
		System.out.println();
		System.out.println();
		
		User user4 = new ChatUser(chat, "Ivan");
		User user5 = new ChatUser(chat, "Maria");
		User user6 = new ChatUser(chat, "George");
		user5.send("Hi guys");
		user5.send("Let me add spamBot");
		user5.send("Hey, let me tell you an amazing fact about my cat. My cAT is so curious..");
		user6.send("What is the name of your cat?");
		user4.send("Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!");
	}

	
}

/*
 * 
 1.OUTPUT WHEN - addBot (CatBot)
 
-Maria sends: Hi guys
-Ivan received: Hi guys
-George received: Hi guys
-Maria sends: Let me addBot
-Ivan received: Let me addBot
-George received: Let me addBot
-Maria sends: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
-Ivan received: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Cat bot banned: Maria
Warning, the word/words - "cat, cAT," is/are forbidden to use!
-George received: Hey, let me tell you an amazing fact about my . My  is so curious..
-George sends: What is the name of your cat?
-Ivan received: What is the name of your cat?
Cat bot banned: George
Warning, the word/words - "cat," is/are forbidden to use!
-Ivan sends: Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!
Cat bot banned: Ivan
Warning, the word/words - "cat," is/are forbidden to use!



MY ADDITION CONDITIONS

2.OUTPUT WHEN - spamBot (SpamBot)

-Maria sends: Hi guys
-Ivan received: Hi guys
-George received: Hi guys
-Maria sends: Let me add spamBot
BOT ADDED
-Ivan received: Let me add spamBot
-George received: Let me add spamBot
-Maria sends: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
-Ivan received: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Spam bot: Maria told: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Spam bot: Maria told: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Spam bot: Maria told: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Spam bot: Maria told: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
Spam bot: Maria told: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
-George received: Hey, let me tell you an amazing fact about my cat. My cAT is so curious..
-George sends: What is the name of your cat?
-Ivan received: What is the name of your cat?
-Maria received: What is the name of your cat?
-Ivan sends: Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!
-Maria received: Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!
-George received: Hahahah.. you both gonna be banned because of cat word... Oh wait, damnnn it!

 */