package fh.aalen.prio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Im Serviece liegt die Logik, welche eigene methoden definiert und dafür die Methoden des CRUD Repository verwendet
public class PrioRatingService {

	//Objekte
	
	@Autowired
	private PrioRatingRepository prioRatingRepository; //wir erzeugen ein Objekt der Klasse PrioRatingRepository

	//Methoden
	
	public List<PrioRating> getPrioRatingList() { //wir erzeugen eine Methode getPrioRatingList() die eine Liste von PrioRatingObjekten zurückgibt
		ArrayList<PrioRating> mylist = new ArrayList<>();  //wir implementieren die ArrayList als "myList"
		Iterator<PrioRating> it = prioRatingRepository.findAll().iterator();  //wir implementieren einen Iterator als "it"
		while (it.hasNext()) //der so lange durch die Objekte PrioRating iteriert wie es mehr Objekte gibt
			mylist.add(it.next()); //diese dann der ArrayListe myList hinzufügt
		return mylist; //und diese Liste dann ausgibt
	}

	public PrioRating getPrioRating(PrioRatingId id) {  //wir geben ein Objekt PrioRating zurück (abgefragt über id)
		return prioRatingRepository.findById(id).orElse(null);	//im PrioRatingRepository suchen wir nach der id und geben dieses Objekt zurück - 
    }    														//oder null, wenn kein Objekt PrioRating diese id hat

	public void addPrioRating(PrioRating prioRating) { //wir speisen ein Objekt PrioRating ein
		prioRatingRepository.save(prioRating); //wir speichern es im Repository
	}

	public void updatePrioRating(PrioRatingId id, PrioRating prioRating) { //wir tauschen ein bestehendes Objekt PrioRating durch ein Neues aus - basierend auf der id
		prioRatingRepository.save(prioRating); //wir speichern es im Repository
	}

	public void deletePrioRating(PrioRatingId id) { //wir löschen ein bestehendes Objekt PrioRating - basierend auf der id
		prioRatingRepository.deleteById(id); //wir löschen es aus dem Rpository
	}

	public List getAvgPrioRating() { //wir lassen uns eine Liste der average PrioRatings ausgeben
		return prioRatingRepository.getAvgPrioRating();
	}

}