package fh.aalen.urlaubswunsch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Der RestController erzeugt wartende Webanwendungen, die es erlauben, die Anfragen eines Nutzers zu verarbeiten
public class UrlaubswunschController {
	
	//Objekte
	
    @Autowired
    UrlaubswunschService urlaubswunschService; 	//wir erzeugen ein Objekt der Klasse UrlaubswunschService 
    											//--> Zugriff auf Methoden der Klasse
    //Nutzeranfragen/Input
    
    @RequestMapping("/urlaubswunsch") 					//RequestMapping führt die entsprechende Methode aus - mittels eines Stringvergleihes
    public List<Urlaubswunsch> getUrlaubswunschList() { //der Eingabe des Users und dem angegebenen String des Pfades, auf den der User die Anfrage stellt
        return urlaubswunschService.getUrlaubswunschList();	//im Falle des Befehles GET auf den Pfad /urlaubswunsch wird die Liste
    }														//mit allen Objekten der Klasse/Entität von "Urlaubswusnch" ausgegeben

    @RequestMapping("/urlaubswunsch/{id}") 								//gleiches wir oben, nur das hier ein bestimmtes Objekt von
    public Urlaubswunsch getUrlaubswunsch(@PathVariable Integer id) {	//Urlaubswunsch ausgegeben wird - basierend auf der id (Primärschlussel)
        return urlaubswunschService.getUrlaubswunsch(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/urlaubswunsch") 		//im Falle der RequestMethode POST auf den  Pfad/Wert /urlaubswunsch
    public void addUrlaubswunsch(@RequestBody Urlaubswunsch urlaubswunsch) {	// wird der ArraysListe ein neues Objekt Urlaubswunsch übergeben
        urlaubswunschService.addUrlaubswunsch(urlaubswunsch);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/urlaubswunsch/{id}") 								//im Falle der RequestMethode PUT auf den  Pfad/Wert /urlaubswunsch/{id} wird das Objekt der ArrayListe mit entsprechender id
    public void updateUrlaubswunsch(@PathVariable Integer id, @RequestBody Urlaubswunsch urlaubswunsch) {	//geupdatet/ausgetauscht mit dem neuen Objekt der Klasse Urlaubswunsch, welches von Nutzer eingegebe wird
        urlaubswunschService.updateUrlaubswunsch(id, urlaubswunsch);			//auch die id des Objektes kann geupdated/ausgetauscht werden
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/urlaubswunsch/{id}")	 //Zu guter Letzt und im Falle der RequestMethode DELETE auf den  Pfad/Wert /urlaubswunsch/{id}
    public void deleteUrlaubswunsch(@PathVariable Integer id) { 					//wird das Objekt der ArrayListe mit entsprechender id gelöscht
        urlaubswunschService.deleteUrlaubswunsch(id);
    }
    
}