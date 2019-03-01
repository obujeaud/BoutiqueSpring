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
public class WarrantyTest {
	
	@Autowired
	private TestEntityManager entityM;
	@Autowired
	WarrantyRepository wr;
	private Warranty w;

	@Before
	public void init() {
		Warranty i = new Warranty("Test", "T");
		entityM.persist(i);
		w = i;
	}

	@Test
	public void createWar() {
		Warranty c = new Warranty("Test2", "T2");
		wr.save(c);
		assertNotNull(wr.findById(w.getId_warranty()).get());
	}

	@Test
	public void getWarrantyId() {
		Warranty i = wr.findById(w.getId_warranty()).get();
		assertNotNull(i);
	}

	@Test
	public void deleteWarranty() {
		wr.delete(entityM.find(Warranty.class, w.getId_warranty()));
		assert (entityM.find(Warranty.class, w.getId_warranty()) == null);
	}
	
	@Test
	public void updateItem() {
		Warranty i = w;
		i.setFullText("siufdhgufdhsgh");
		wr.save(i);
		assertEquals(i.getFullText(), wr.findById(w.getId_warranty()).get().getFullText());
	}

	@Test
	public void deleteWarrantyId() {
		wr.deleteById(w.getId_warranty());
		assert (entityM.find(Warranty.class, w.getId_warranty()) == null);
	}
}