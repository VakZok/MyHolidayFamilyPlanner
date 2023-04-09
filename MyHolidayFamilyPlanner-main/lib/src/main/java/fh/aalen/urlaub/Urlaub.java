package fh.aalen.urlaub;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fh.aalen.urlaubswunsch.Urlaubswunsch;

@Entity // wir erzeugen eine Entität, welche - da nicht explizit anders definiert - den
		// Namen der Klasse als Entitätsnamen übernimmt
@Table(name = "urlaub")
public class Urlaub {

	// Instanzvariablen(Spalten)

	@Id // als Primärschlüssel legen wir ganz simpel den den integer id fest. Dieser
		// muss in der aktuellen Version manuell vergeben werden, kann durch einen
		// Sequenzer später noch automatisiert werden
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "titel", nullable = false)
	private String titel; // wir legen noch zwei weitere Spalten für den Zeitraum und den Titel des
								// Urlaubs an

	@Column(name = "zeitraum", nullable = false)
	private String zeitraum;


	@OneToMany(mappedBy = "urlaub")
	private List<Urlaubswunsch> urlaubswuensche;

	// Konstruktoren

	public Urlaub() { 	// Standardkonstruktor; nur da, damit Code nicht crashed im Fall der Fälle. Verwenden wir nicht.
	}

	public Urlaub(Integer id, String titel, String zeitraum) { 	// Konstruktor, der den User-Input an unsere lokalen													
		this.id = id;											// Attribute (Spalten) unserer Klasse (Entität) übergibt
		this.titel = titel;
		this.zeitraum = zeitraum;
	}

	// Getter und Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getZeitraum() {
		return zeitraum;
	}

	public void setZeitraum(String zeitraum) {
		this.zeitraum = zeitraum;
	}

}
