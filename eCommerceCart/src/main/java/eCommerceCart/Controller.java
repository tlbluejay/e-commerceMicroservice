package eCommerceCart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;
public class Controller {   

	/*
	 * @SuppressWarnings("resource") public static void main(String[] args) {
	 * 
	 * //Connecting to Redis server on localhost Jedis jedis = new
	 * Jedis("localhost"); System.out.println("Connection to server sucessfully");
	 * //check whether server is running or not
	 * System.out.println("Server is running: "+jedis.ping()); }
	 */
	public static void main(String[] args) {

		
		SpringApplication.run(Controller.class, args);
	}
}
