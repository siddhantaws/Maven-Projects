package com.manh.spring.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manh.models.Person;

public class SimpleMessageListener implements MessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageListener.class);

	public void onMessage(Message message) {

		try {
			ObjectMessage objMsg = (ObjectMessage) message;
			if (objMsg.getObject() instanceof Person) {
				Person person = (Person) objMsg.getObject();
				LOG.info("Received message: {}", person.getName());
			}
			else{
				LOG.info("Received message is not Person type");
			}
		} catch (JMSException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
