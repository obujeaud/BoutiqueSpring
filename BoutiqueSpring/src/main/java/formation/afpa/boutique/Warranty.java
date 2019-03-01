package formation.afpa.boutique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Warranty")
public class Warranty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_warranty;
	public void setId_warranty(Long id_warranty) {
		this.id_warranty = id_warranty;
	}

	public Long getId_warranty() {
		return id_warranty;
	}

	@Column(name="summary", length=150, nullable=false)
	private String summary;
	@Column(name="fullText", length=300, nullable=false)
	private String fullText;
	
	public Warranty(String summary, String fullText) {
		super();
		this.summary = summary;
		this.fullText = fullText;
	}

	public Warranty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	@Override
	public String toString() {
		return "Warranty [id=" + id_warranty + ", summary=" + summary + ", fullText=" + fullText + "]";
	}

}
