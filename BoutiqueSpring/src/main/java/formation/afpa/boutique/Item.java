package formation.afpa.boutique;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Item")
@Transactional
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_item;
	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	public Long getId_item() {
		return id_item;
	}

	@Column(name = "name", length = 150, nullable = false)
	private String name;
	@Column(name = "description", length = 150, nullable = false)
	private String decription;
	@Column(name = "price", nullable = false)
	private Long price;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinTable(name = "item_category", joinColumns = @JoinColumn(name = "id_item"), inverseJoinColumns = @JoinColumn(name = "id_category"))
	private Set<Category> cat = new HashSet<>();
	@OneToOne(cascade = { CascadeType.REMOVE }, orphanRemoval = true)
	private Warranty w;
	public Warranty getW() {
		return w;
	}

	public void setW(Warranty w) {
		this.w = w;
	}

	@OneToMany(mappedBy = "i", cascade = { CascadeType.REFRESH })
	private Set<Image> img = new HashSet<>();

	public Item(String name, String decription, Long price, Category c, Warranty ww) {
		super();
		this.name = name;
		this.decription = decription;
		this.price = price;
		cat.add(c);
		this.w = ww;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id_item + ", name=" + name + ", decription=" + decription + ", price=" + price + "]";
	}

	public void addCategory(Category c) {
		cat.add(c);
	}
}