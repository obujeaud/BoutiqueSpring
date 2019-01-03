package formation.afpa.boutique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = BoutiqueSpringApplicationTests.class)
public class ItemTest {
	
	@Autowired
	private TestEntityManager entityM;
	@Autowired
	ItemRepository itr;
	private Item ii;

	@Before
	public void init() {
		Item i = new Item("Test", "T", 1l, new Category("a", "b", "c"), new Warranty("a", "b"));
		entityM.persist(i);
		ii = i;
	}

	@Test
	public void createItem() {
		Item c = new Item("Test2", "T2", (long) 10, entityM.find(Category.class, 1L), entityM.find(Warranty.class, 1L));
		itr.save(c);
		assertNotNull(itr.findById(1l));
	}

	@Test
	public void getItemId() {
		Item i = itr.findById(ii.getId_item()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateItem() {
		Item i = ii;
		i.setDecription("siufdhgufdhsgh");
		itr.save(i);
		assertEquals(i.getDecription(), itr.findById(ii.getId_item()).get().getDecription());
	}

	@Test
	public void deleteItem() {
		itr.delete(entityM.find(Item.class, ii.getId_item()));
		assert (entityM.find(Item.class, ii.getId_item()) == null);
	}

	@Test
	public void deleteItemId() {
		itr.deleteById(entityM.find(Item.class, ii.getId_item()).getId_item());
		assert (entityM.find(Item.class, ii.getId_item()) == null);
	}
}
