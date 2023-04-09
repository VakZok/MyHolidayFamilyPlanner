package fh.aalen.urlaubswunsch;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fh.aalen.prio.PrioRating;
import fh.aalen.urlaub.Urlaub;

@Entity //wir erzeugen eine Entität, welche - da nicht explizit anders definiert - den Namen der Klasse als Entitätsnamen übernimmt
@Table(name = "urlaubswunsch")
public class Urlaubswunsch {
	
	//Instanzvariablen (Spalten)
	
    @Id // als Primärschlüssel legen wir ganz simpel den den integer id fest. Dieser
		// muss in der aktuellen Version manuell vergeben werden, kann durch einen
		// Sequenzer später noch automatisiert werden
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "ort", nullable = false)	//wir legen noch zwei weitere Spalten für die Beschreibung und den Ort der Person an
    private String ort;
    
    @Column(name = "beschreibung", nullable = false)
    private String beschreibung;  
   
    //Relationen
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "urlaub_id") //hier verknüpfen wir (Relation)
    private Urlaub urlaub;
    
    @OneToMany(mappedBy = "urlaubswunsch") //hier verknüpfen wir (Relation)
    private List<PrioRating> prioRatings;
    
    // Konstruktoren

    public Urlaubswunsch() { //Standardkonstruktor; nur da, damit code nicht crashed im Fall der Fälle. Verwenden wir nicht.
    }

    public Urlaubswunsch(Integer id, String ort, String beschreibung, Urlaub urlaub) { //Konstruktor, der den User-Input an unsere lokalen Attribute und Objekte (Spalten) unserer Klasse (Entität) übergibt
        this.id = id;
        this.ort = ort;
        this.beschreibung = beschreibung;
        this.urlaub = urlaub;
    }

    //Getter und Setter
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Urlaub getUrlaub() {
        return urlaub;
    }

    public void setUrlaub(Urlaub urlaub) {
        this.urlaub = urlaub;
    }
    
}
