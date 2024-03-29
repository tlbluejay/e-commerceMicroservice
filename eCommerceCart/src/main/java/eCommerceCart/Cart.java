package eCommerceCart;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("")
public class Cart {
	private Jedis jedis = new Jedis();
	public void AddItem(String iD) {
		//convert pass in data
		List<String> cart = jedis.lrange(iD, 0, 100);
		if(cart.size() == 0) {
			jedis.lpush(iD, "0");
		}
		else {
			jedis.rpush(iD, "" + cart.size());
		}
	}
	public void RemoveItem(String iD) {
		if(jedis.llen(iD) > 0) {
			jedis.rpop(iD);
		}
	}
	
	@RequestMapping(path = "/addItemToCart", method = RequestMethod.PUT)
	public void AddToCart(@PathVariable String itemID) {
		AddItem(itemID);
	}
	@RequestMapping(path = "/RemoveItemFromCart", method = RequestMethod.DELETE)
	public void RemoveFromCart(@PathVariable String itemID) {
		RemoveItem(itemID);
	}
	
}
