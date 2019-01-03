package formation.afpa.boutique;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_image;

	public Long getId_image() {
		return id_image;
	}

	@Column(name = "altText", length = 150, nullable = false)
	private String altText;
	@Column(name = "path", length = 150, nullable = false)
	private String path;
	@ManyToOne(cascade = { CascadeType.REFRESH }, targetEntity = Item.class)
	private Item i;

	public Item getI() {
		return i;
	}

	public void setI(Item i) {
		this.i = i;
	}

	public Image(String altText, String path, Item i) {
		super();
		this.altText = altText;
		this.path = path;
		this.i = i;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Image [id=" + id_image + ", altText=" + altText + ", path=" + path + "]";
	}

}
