package fh.aalen.prio;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import fh.aalen.familienmitglied.Familienmitglied;
import fh.aalen.urlaubswunsch.Urlaubswunsch;

@Entity //wir erzeugen eine Entität, welche - da nicht explizit anders definiert - den
		//Namen der Klasse als Entitätsnamen übernimmt
@Table(name = "prio_rating")
public class PrioRating {
	
	//Objekte und Spalten
	
	@EmbeddedId //Die EmbeddedId setzt sich aus dem Primärschlüssel von Familienmitglied und dem dazugehörigen Urlaubswunsch zusammen
	private PrioRatingId id;	//wir erzeugen ein entsprechendes Objekt der Klasse PrioRatingId, welche die zwei Klassen zusammenbringt

	@MapsId("familienmitgliedId") //beschreibt, auf welchen der embeddeten Key zugegriffen wird
	@ManyToOne(fetch = FetchType.EAGER, optional = false) //der FetchTyp EAGER bedeutet, dass die entsprechenden Objekte (Familienmitglied) automatisch beim laden von PrioRating mitgeladen werden
	@JoinColumn(name = "familienmitglied_id", nullable = false) //wir setzten die Bezeichnung der Spalte und verbieten leere Felder
	private Familienmitglied familienmitglied; //das entsprechende Familienmitglied wird als ganzes Objekt übergeben

	@MapsId("urlaubswunschId")
	@ManyToOne(fetch = FetchType.EAGER, optional = false) //optinal false bedeutet, dass die Objekte der Klassen geladen werden MÜSSEN
	@JoinColumn(name = "urlaubswunsch_id", nullable = false)
	private Urlaubswunsch urlaubswunsch; //ebenso der entsprechende Urlaubswunsch

	@Column(name = "prio", nullable = false) //als letztes brauchen wir noch eine Spalte, in der die Ratings von 1 bis 10 enthalten sind
	private Integer prio;
	
	//Getter und Setter

	public PrioRatingId getId() {
		return id;
	}

	public void setId(PrioRatingId id) {
		this.id = id;
	}

	public Familienmitglied getFamilienmitglied() {
		return familienmitglied;
	}

	public void setFamilienmitglied(Familienmitglied familienmitglied) {
		this.familienmitglied = familienmitglied;
	}

	public Urlaubswunsch getUrlaubswunsch() {
		return urlaubswunsch;
	}

	public void setUrlaubswunsch(Urlaubswunsch urlaubswunsch) {
		this.urlaubswunsch = urlaubswunsch;
	}

	public Integer getPrio() {
		return prio;
	}

	public void setPrio(Integer prio) {
		this.prio = prio;
	}

}