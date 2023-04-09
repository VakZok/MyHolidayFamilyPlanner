package fh.aalen.prio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.Hibernate;

@Embeddable //verwendet, um einen Tyo in eine andere Entität zu einzubinden
public class PrioRatingId implements Serializable { //das Interface Serilizable ist ein Marker Interface, welches keine Methoden und Attribute hat
													//es funktioniert als Mechanismus den Status eines Objektes in einen Bytestream zu ver- und zurückzuwandeln

	private static final long serialVersionUID = -5344864880274158930L; //wir implementieren die entsprechende Verison um sicherzustellen,
																		//das wir immer auf der gleichen arbeiten
	//Instanzvariablen und Spalten
	
	@Column(name = "familienmitglied_id", nullable = false)	 //wir setzten die Bezeichnung der Spalte und verbieten leere Felder
	private Integer familienmitgliedId;						//und erzeugen die entsprechenden Variablen

	@Column(name = "urlaubswunsch_id", nullable = false)
	private Integer urlaubswunschId;

	//Getter und Setter
	
	public Integer getFamilienmitgliedId() {
		return familienmitgliedId;
	}

	public void setFamilienmitgliedId(Integer familienmitgliedId) {
		this.familienmitgliedId = familienmitgliedId;
	}

	public Integer getUrlaubswunschId() {
		return urlaubswunschId;
	}

	public void setUrlaubswunschId(Integer urlaubswunschId) {
		this.urlaubswunschId = urlaubswunschId;
	}

	//Equals und HashCode
	
	@Override
	public boolean equals(Object o) {	//die Methode equals erlaubt einen Vergleich von Objekten auf Inhalt
		if (this == o)					//falls das übergebene Objekt mit dem lokalen übereinstimmt, gibt die Methode equals true zurück
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))	//falls das übergebene Objekt null ist oder die Klasse des lokalen Objekts
			return false;													//nicht mit der Klasse des übergebenen Objekts übereinstimmt --> Rückgabe false
		PrioRatingId entity = (PrioRatingId) o;										//sollte es sich bei beiden Objekten um Objekte der gleichen Klasse handeln,
		return Objects.equals(this.familienmitgliedId, entity.familienmitgliedId)	//geben wir Objects.equals der beiden Instanzvariablen
				&& Objects.equals(this.urlaubswunschId, entity.urlaubswunschId);	//mit zugehöriget Entität zurück
	}

	@Override
	public int hashCode() { //der hashCode kann verwendet werden, um Objekte zu vergleichen. Bei gleichem hashCode KÖNNEN diese gleich sein, müssen es aber nicht!
		return Objects.hash(familienmitgliedId, urlaubswunschId); //wir geben Objects.hash der beiden Instanzvaraiblen zurück
	}

}