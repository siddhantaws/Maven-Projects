package com.manh.java7.concurrency.chapter3.recipe3.core;

import com.manh.java7.concurrency.chapter3.recipe3.task.Participant;
import com.manh.java7.concurrency.chapter3.recipe3.task.Videoconference;

/**
 * Main class of the example. Create, initialize and execute all the objects
 * necessaries for the example
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {

		// Creates a VideoConference with 10 participants.
		Videoconference conference=new Videoconference(-1);
		// Creates a thread to run the VideoConference and start it.
		//for (int i=0; i<2; i++){
		Thread threadConference=new Thread(conference);
		threadConference.start();
		//}
		
		// Creates ten participants, a thread for each one and starts them
		for (int i=0; i<3; i++){
			Participant p=new Participant(conference, "Participant "+i);
			Thread t=new Thread(p);
			t.start();
		}

	}

}
