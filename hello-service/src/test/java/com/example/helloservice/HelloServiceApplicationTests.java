package com.example.helloservice;

import com.example.helloservice.amqp.RabbitmqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceApplicationTests {

	@Autowired
	private RabbitmqSender sender;


	@Test
	public void contextLoads() {
	}

	@Test
	public void hello() throws Exception{
		sender.send("丢你老母");
	}


}
