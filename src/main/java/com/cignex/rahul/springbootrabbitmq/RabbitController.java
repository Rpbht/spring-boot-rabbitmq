package com.cignex.rahul.springbootrabbitmq;

import java.util.HashMap;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

	private RabbitTemplate rabbitTemplate;

	public RabbitController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public void helloFromRabbitMq(@PathVariable String name) {
		HashMap<String, String> message = new HashMap<>();
		message.put("name", name);
		System.out.println(message);
		rabbitTemplate.convertAndSend(SpringBootRabbitmqApplication.MESSAGE_QUEUE, message);
	}

}
