package fh.aalen.urlaub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Der RestController erzeugt wartende Webanwendungen, die es erlauben, die Anfragen eines Nutzers zu verarbeiten
public class UrlaubController {
	
	//Objekte
	
    @Autowired
    UrlaubService urlaubService;	//wir erzeugen ein Objekt der Klasse UrlaubService 
    								//--> Zugriff auf Methoden der Klasse
    //Nutzeranfragen/Input
    
    @RequestMapping("/urlaub") 				//RequestMapping führt die entsprechende Methode aus - mittels eines Stringvergleihes
    public List<Urlaub> getUrlaubList() { 	// der Eingabe des Users und dem angegebenen String des Pfades, auf den der User die Anfrage stellt	
        return urlaubService.getUrlaubList();	//im Falle des Befehles GET auf den Pfad /urlaub wird die Liste 
    }											//mit allen Objekten der Klasse/Entität von "Urlaub" ausgegeben

    @RequestMapping("/urlaub/{id}") 					//gleiches wir oben, nur das hier ein bestimmtes Objekt von
    public Urlaub getUrlaub(@PathVariable Integer id) {	//Urlaub ausgegeben wird - basierend auf der id (Primärschlussel)
        return urlaubService.getUrlaub(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/urlaub") //im Falle der RequestMethode POST auf den  Pfad/Wert /urlaub
    public void addUrlaub(@RequestBody Urlaub urlaub) {				//wird der ArraysListe ein neues Objekt Urlaub übergeben
        urlaubService.addUrlaub(urlaub);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/urlaub/{id}") 				//im Falle der RequestMethode PUT auf den  Pfad/Wert /urlaub/{id} wird das Objekt der ArrayListe mit entsprechender id 
    public void updateUrlaub(@PathVariable Integer id, @RequestBody Urlaub urlaub) { 	//geupdatet/ausgetauscht mit dem neuen Objekt der Klasse Urlaub, welches von Nutzer eingegebe wird
        urlaubService.updateUrlaub(id, urlaub);			//auch die id des Objektes kann geupdated/ausgetauscht werden
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/urlaub/{id}") 	//Zu guter Letzt und im Falle der RequestMethode DELETE auf den  Pfad/Wert /urlaub/{id}
    public void deleteUrlaub(@PathVariable Integer id) {					//wird das Objekt der ArrayListe mit entsprechender id gelöscht
        urlaubService.deleteUrlaub(id);
    }
    
}
