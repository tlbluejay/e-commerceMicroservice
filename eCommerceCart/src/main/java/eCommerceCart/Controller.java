package eCommerceCart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;
@SpringBootApplication
public class Controller {   
	public static void main(String[] args) {

		
		SpringApplication.run(Controller.class, args);
	}
}
