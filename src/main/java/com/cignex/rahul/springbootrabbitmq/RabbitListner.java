package com.cignex.rahul.springbootrabbitmq;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class RabbitListner {

	public void receiveMessage(HashMap<String, String> message){
		System.out.println("Message from: "+message.get("name"));
	}
	
}
