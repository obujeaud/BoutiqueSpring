package formation.afpa.boutique;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOService {
	@Autowired
	ItemRepository ir;
	@Autowired
	CategoryRepository cr;
	@Autowired
	ImageRepository imr;
	@Autowired
	WarrantyRepository wr;
	
	public void itemSave(Item i) {
		ir.save(i);
	}
	
	public void categSave(Category c) {
		cr.save(c);
	}
	
	public void imgSave(Image i) {
		imr.save(i);
	}
	
	public void warSave(Warranty w) {
		wr.save(w);
	}
	
	public Item getItemById(long id) {
		return ir.findById(id).get();
	}
	
	public Category getCategById(long id) {
		return cr.findById(id).get();
	}
	
	public Image getImgById(long id) {
		return imr.findById(id).get();
	}
	
	public Warranty getWarById(long id) {
		return wr.findById(id).get();
	}
	
	public void deleteItem(Item i) {
		ir.delete(i);
	}
	
	public void deleteItemId(long id) {
		ir.deleteById(id);
	}
	
	public void deleteCateg(Category c) {
		cr.delete(c);
	}
	
	public void deleteCategId(long id) {
		cr.deleteById(id);
	}
	
	public void deleteImage(Image i) {
		imr.delete(i);
	}
	
	public void deleteImageId(long id) {
		imr.deleteById(id);
	}
	
	public void deleteWarranty(Warranty w) {
		wr.delete(w);
	}
	
	public void deleteWarrantyId(long id) {
		wr.deleteById(id);
	}
	
	public Set<Item> itemList(){
		Set<Item> sei = new HashSet<>();
		sei.addAll((Collection<? extends Item>) ir.findAll());
		return sei;
	}
	
	public Set<Image> imageList(){
		Set<Image> sei = new HashSet<>();
		sei.addAll((Collection<? extends Image>) imr.findAll());
		return sei;
	}
	
	public Set<Category> categList(){
		Set<Category> sei = new HashSet<>();
		sei.addAll((Collection<? extends Category>) cr.findAll());
		return sei;
	}
	
	public Set<Warranty> warList(){
		Set<Warranty> sei = new HashSet<>();
		sei.addAll((Collection<? extends Warranty>) wr.findAll());
		return sei;
	}

}
