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
public class CategoryTest {

	@Autowired
	private TestEntityManager entityM;
	@Autowired
	private CategoryRepository cr;
	private Category ii;

	@Before
	public void setUp() {
		Category i = new Category("Test", "T", "izuehyuhf");
		entityM.persist(i);
		ii = i;
	}

	@Test
	public void createCateg() {
		Category c = new Category("Test2", "T2", "Un autre test");
		cr.save(c);
		assertNotNull(cr.findById(ii.getId_category()));
	}

	@Test
	public void getCategoryId() {
		Category i = cr.findById(ii.getId_category()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateItem() {
		Category i = ii;
		i.setDescription("siufdhgufdhsgh");
		cr.save(i);
		assertEquals(i.getDescription(), cr.findById(ii.getId_category()).get().getDescription());
	}

	@Test
	public void deleteCateg() {
		cr.delete(entityM.find(Category.class, ii.getId_category()));
		assert (entityM.find(Category.class, ii.getId_category()) == null);
	}

	@Test
	public void deleteCategId() {
		cr.deleteById(ii.getId_category());
		assert (entityM.find(Category.class, ii.getId_category()) == null);
	}

}
