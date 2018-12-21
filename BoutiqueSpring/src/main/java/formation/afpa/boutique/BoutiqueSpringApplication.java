package formation.afpa.boutique;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BoutiqueSpringApplication implements CommandLineRunner {
	@Autowired
	DAOService dao;

	Log l = LogFactory.getLog(BoutiqueSpringApplication.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(BoutiqueSpringApplication.class)
				.headless(false).run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.categSave(new Category("Kitchen", "C1", "Can cook"));
		dao.categSave(new Category("Vehicle", "V1", "Can drive"));
		dao.categSave(new Category("Student", "S1", "Can study"));
		dao.categSave(new Category("Writing", "W1", "Can write"));
		dao.categSave(new Category("Food", "F1", "Can be eaten"));
		
		dao.warSave(new Warranty("6 mois pièces", "Texte test"));
		dao.warSave(new Warranty("10 ans rubis sur ongle", "Texte test"));
		dao.warSave(new Warranty("5 jours pas cher", "Texte test"));
		dao.warSave(new Warranty("1 décennie main d\'oeuvre", "Texte test"));
		dao.warSave(new Warranty("Garantie à vie", "Texte test"));
		
		dao.itemSave(new Item("Pen Bic", "PB1", (long) 10, dao.getCategById((long) 4), dao.getWarById((long) 1)));
		dao.itemSave(new Item("Pencil Case Bic", "PCB1", (long) 100, dao.getCategById((long) 4), dao.getWarById((long) 2)));
		dao.itemSave(new Item("Renault Kangoo", "RK1", (long) 100000, dao.getCategById((long) 2), dao.getWarById((long) 3)));
		dao.itemSave(new Item("Madrange", "M1", (long) 1, dao.getCategById((long) 5), dao.getWarById((long) 4)));
		dao.itemSave(new Item("Crystal Fork", "CF1", (long) 1000, dao.getCategById((long) 1), dao.getWarById((long) 5)));
		
		dao.imgSave(new Image("Pen", "/img/pen.jpg", dao.getItemById((long) 1)));
		dao.imgSave(new Image("Pencil case", "/img/pencase.jpg", dao.getItemById((long) 2)));
		dao.imgSave(new Image("Car", "/img/car.jpg", dao.getItemById((long) 3)));
		dao.imgSave(new Image("Ham", "/img/ham.jpg", dao.getItemById((long) 4)));
		dao.imgSave(new Image("Fork", "/img/fork.jpg", dao.getItemById((long) 5)));
		
		for (Item i : dao.itemList()) {
			l.info(i.toString());
		}
		
		dao.categSave(new Category("Road", "R1", "Can drive too"));
		dao.categSave(new Category("Drawing", "D1", "Can draw"));
		
		Item i = dao.getItemById((long) 1);
		i.setName("Bric");
		i.addCategory(dao.getCategById((long) 7));
		Item ii = dao.getItemById((long) 3);
		ii.addCategory(dao.getCategById((long) 6));
		
		Warranty www = dao.getWarById((long) 2);
		www.setFullText("Miammian");
		dao.warSave(www);
		
		dao.itemSave(i);
		dao.itemSave(ii);
		dao.warSave(new Warranty("Toblerone", "azer"));
		dao.itemSave(new Item("Toblerone", "T1", (long) 15, dao.getCategById((long) 5), dao.getWarById((long) 6)));
		dao.imgSave(new Image("Toblerone", "/img/toblerone.jpg", dao.getItemById((long) 6)));
		
		for (Item ie : dao.itemList()) {
			l.info(ie.toString());
		}
		
		dao.deleteItem(dao.getItemById((long) 5));
		
		for (Item ie : dao.itemList()) {
			l.info(ie.toString());
		}
	}

}
