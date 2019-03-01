package formation.afpa.boutique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_category;
	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public Long getId_category() {
		return id_category;
	}

	@Column(name="name", length=150, nullable=false)
	private String name;
	@Column(name="code", length=150, nullable=false)
	private String code;
	@Column(name="description", length=150, nullable=false)
	private String description;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id_category + ", name=" + name + ", code=" + code + ", description=" + description + "]";
	}
}
