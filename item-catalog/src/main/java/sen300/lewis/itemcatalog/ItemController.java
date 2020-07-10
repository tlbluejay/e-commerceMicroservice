package sen300.lewis.itemcatalog;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemJpaRepository itemRepository;
	
	//Code for returning Hypermedia Rest Links for Items
		//	private EntityLinks entityLinks;
			
		//	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
		//	public HttpEntity<Resources<Item>> showItems() {
		//		Resources<Item> resources = new Resources<>(this.itemRepository.findAll());
		//		resources.add(this.entityLinks.linkToCollectionResource(Item.class));
		//		return new ResponseEntity<Resources<Item>>(resources, HttpStatus.OK);
		//	}
		//	
		//	@RequestMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
		//	public HttpEntity<Resource<Item>> showItem(@PathVariable long id) {
		//		Resource<Item> resource = new Resource<Item>(this.itemRepository.findById(id), this.entityLinks.linkToSingleResource(Item.class, id));
		//	}
	
	public Item showItem(@PathVariable long id) {
		return itemRepository.getOne(id);
	}

	//Clears repository and re-initializes the catalog with a new set of 100 items.
	@RequestMapping(path="/init", method=RequestMethod.GET)
	public void initItems() {
		
		String[] prefixes = { "Rusty", "Shiny", "Broken", "Slimy", "Sturdy" };
		String[] items = { "Ring", "Sword", "Stick", "Beehive", "Dog-House" };
		String[] suffixes = { "of Truth", "of Shame", "of Suffering", "of Vitality", "of Exhaustion" };

		clearRepository();
		
		for (int i = 1; i < 101; i++) {
			Random rand = new Random();
			String[] selected = { prefixes[rand.nextInt(5)], items[rand.nextInt(5)], suffixes[rand.nextInt(5)] };
			String itemTitle = selected[0] + " " + selected[1] + " " + selected[2];

			StringBuilder description = new StringBuilder();
			switch (selected[0]) {
				case "Rusty":
					description.append("An old worn ");
					break;
				case "Shiny":
					description.append("A dazzlingly bright ");
					break;
				case "Broken":
					description.append("A deteriorated ");
					break;
				case "Slimy":
					description.append("A thick and slippery goo coats the ");
					break;
				case "Sturdy":
					description.append("A strong and unbreaking ");
					break;
			}

			switch (selected[1]) {
				case "Ring":
					description.append("ring, the wearer ");
					break;
				case "Sword":
					description.append("sword, the wielder ");
					break;
				case "Stick":
					description.append("stick, the wielder ");
					break;
				case "Beehive":
					description.append("beehive, the owner ");
					break;
				case "Dog-House":
					description.append("dog-house, the owner ");
					break;
			}

			switch (selected[2]) {
				case "of Truth":
					description.append("is forced into saying only the truth.");
					break;
				case "of Shame":
					description.append("possesses shame as great as the uselessness of the item.");
					break;
				case "of Suffering":
					description.append("takes upon immense pain as the item leeches off of their life.");
					break;
				case "of Vitality":
					description.append("gains a tremendous boost in health.");
					break;
				case "of Exhaustion":
					description.append("begins to function sluggishly and physical actions become harder to perform.");
					break;
			}

			Item item = new Item();
			item.setId(i);
			item.setTitle(itemTitle);
			item.setDescription(description.toString());
			item.setUnitPrice(Math.round((rand.nextInt(500) + rand.nextDouble()) * 100.0) / 100.0);
			itemRepository.save(item);
		}

	}

	private void clearRepository() {
		itemRepository.deleteAll();
	}
}
