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
public class ImageTest {
	
	@Autowired
	private TestEntityManager entityM;
	@Autowired
	ImageRepository imr;
	private Image im;

	@Before
	public void init() {
		Image i = new Image("Test", "T", new Item("Test", "Test", 10l,
				new Category("Test2", "T2", "Un autre test"), new Warranty("Test2", "T2")));
		entityM.persist(i);
		im = i;
	}

	@Test
	public void createImg() {
		Image c = new Image("Test2", "T2", new Item("Test", "Test", (long) 10,
				new Category("Test2", "T2", "Un autre test"), new Warranty("Test2", "T2")));
		imr.save(c);
		assertNotNull(imr.findById(1l));
	}

	@Test
	public void getImageId() {
		Image i = imr.findById(im.getId_image()).get();
		assertNotNull(i);
	}
	
	
	@Test
	public void updateItem() {
		Image i = im;
		i.setAltText("siufdhgufdhsgh");
		imr.save(i);
		assertEquals(i.getAltText(), imr.findById(im.getId_image()).get().getAltText());
	}

	@Test
	public void deleteImage() {
		imr.delete(entityM.find(Image.class, im.getId_image()));
		assert (entityM.find(Image.class, im.getId_image()) == null);
	}

	@Test
	public void deleteImageId() {
		imr.deleteById(entityM.find(Image.class, im.getId_image()).getId_image());
		assert (entityM.find(Image.class, im.getId_image()) == null);
	}
}
