package fh.aalen.familienmitglied;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fh.aalen.prio.PrioRating;

@Entity // wir erzeugen eine Entität, welche - da nicht explizit anders definiert - den
		// Namen der Klasse als Entitätsnamen übernimmt
@Table(name = "familienmitglied")
public class Familienmitglied {

	// Instanzvariablen (Spalten)

	@Id // als Primärschlüssel legen wir ganz simpel den den integer id fest. Dieser
		// muss in der aktuellen Version manuell vergeben werden, kann durch einen
		// Sequenzer später noch automatisiert werden
	@Column(name = "id", nullable = false)
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name; // wir legen noch zwei weitere Spalten für den Namen und den Geburtstag der
						// Person an

	@Column(name = "geburtstag", nullable = false)
	private String geburtstag;

	// Relationen

	@OneToMany(mappedBy = "familienmitglied") // hier verknüpfen wir (Relation)
	private List<PrioRating> prioRatings;

	// Konstruktoren

	public Familienmitglied() { // Standardkonstruktor; nur da, damit code nicht crashed im Fall der Fälle.
								// Verwenden wir nicht.
	}

	public Familienmitglied(int id, String name, String geburtstag) { 	// Konstruktor, der den User-Input an unsere
		this.id = id;													// lokalen Attribute (Spalten) unserer Klasse
		this.name = name;												// (Entität) übergibt																	
		this.geburtstag = geburtstag;
	}

	// Getter und Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}

}
