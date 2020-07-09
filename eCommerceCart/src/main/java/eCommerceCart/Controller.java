package eCommerceCart;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
public class Controller {   
	public List cart = new ArrayList<>();
	@SuppressWarnings("resource")
	   public static void main(String[] args) { 
		      //Connecting to Redis server on localhost 
		      Jedis jedis = new Jedis("localhost"); 
		      System.out.println("Connection to server sucessfully"); 
		      //check whether server is running or not 
		      System.out.println("Server is running: "+jedis.ping()); 
		   } 
}
