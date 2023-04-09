package fh.aalen.prio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Der RestController erzeugt wartende Webanwendungen, die es erlauben, die Anfragen eines Nutzers zu verarbeiten
public class PrioRatingController {
	
	//Objekte

	@Autowired
	PrioRatingService prioRatingService; //wir erzeugen ein Objekt der Klasse PrioRatingService 
										 //--> Zugriff auf Methoden der Klasse
	//Nutzeranfragen/Input
	
	@RequestMapping("/priorating")					//RequestMapping führt die entsprechende Methode aus - mittels eines Stringvergleihes
	public List<PrioRating> getPrioRatingList() {	//der Eingabe des Users und dem angegebenen String des Pfades, auf den der User die Anfrage stellt
		return prioRatingService.getPrioRatingList();	//im Falle des Befehles GET auf den Pfad /priorating wird die Liste 
    }    												//mit allen Objekten der Klasse/Entität von "PrioRating" ausgegeben

	@RequestMapping("/priorating/{id}")									//gleiches wir oben, nur das hier ein bestimmtes Objekt von
	public PrioRating getPrioRating(@PathVariable PrioRatingId id) {	//PrioRating ausgegeben wird - basierend auf der id (Primärschlussel)
		return prioRatingService.getPrioRating(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/priorating")	//im Falle der RequestMethode POST auf den  Pfad/Wert /priorating
	public void addPrioRating(@RequestBody PrioRating prioRating) { 	//wird der ArraysListe ein neues Objekt PrioRating übergeben
		prioRatingService.addPrioRating(prioRating);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/priorating/{id}") //im Falle der RequestMethode PUT auf den  Pfad/Wert /priorating/{id} wird das Objekt der ArrayListe mit entsprechender id
	public void updatePrioRating(@PathVariable PrioRatingId id, @RequestBody PrioRating prioRating) {//geupdatet/ausgetauscht mit dem neuen Objekt der Klasse PrioRating, welches von Nutzer eingegebe wird
		prioRatingService.updatePrioRating(id, prioRating);					//auch die id des Objektes kann geupdated/ausgetauscht werden
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/priorating/{id}") 	//Im Falle der RequestMethode DELETE auf den  Pfad/Wert /priorating/{id} 
	public void deletePrioRating(@PathVariable PrioRatingId id) {				//wird das Objekt der ArrayListe mit entsprechender id gelöscht
		prioRatingService.deletePrioRating(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/avgpriorating")	//Zu guter Letzt und im Falle der RequestMethode GET auf den  Pfad/Wert /avgpriorating
	public List getAvgPrioRating() {										//wird eine Liste aller Objekt der ArrayListe zurückgegeben
		return prioRatingService.getAvgPrioRating();
	}

}