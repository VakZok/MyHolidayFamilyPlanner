package fh.aalen.familienmitglied;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Der RestController erzeugt wartende Webanwendungen, die es erlauben, die Anfragen eines Nutzers zu verarbeiten
public class FamilienmitgliedController {
	
	//Objekte
	
    @Autowired
    FamilienmitgliedService familienmitgliedService; //wir erzeugen ein Objekt der Klasse Familienmitgliedservice 
    												 //--> Zugriff auf Methoden der Klasse FamilienmitgliedService

    //Nutzeranfragen/input
    
    @RequestMapping("/familienmitglied") 						//RequestMapping führt die entsprechende Methode aus - mittels eines Stringvergleihes
    public List<Familienmitglied> getFamilienmitgliedList() {	//der Eingabe des Users und dem angegebenen String des Pfades, auf den der User die Anfrage stellt
        return familienmitgliedService.getFamilienmitgliedList();	//im Falle des Befehles GET auf den Pfad /familienmitglied wird die Liste 
    }    															//mit allen Objekten der Klasse/Entität von "Familienmitglied" ausgegeben
    
    @RequestMapping("/familienmitglied/{id}") 								//gleiches wir oben, nur das hier ein bestimmtes Objekt von
    public Familienmitglied getFamilienmitlgied(@PathVariable Integer id) {	//Familienmitglied ausgegeben wird - basierend auf der id (Primärschlussel)
        return familienmitgliedService.getFamilienmitglied(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/familienmitglied") 			//im Falle der RequestMethode POST auf den  Pfad/Wert /familienmitglied
    public void addFamilienmitglied(@RequestBody Familienmitglied familienmitglied) {	//wird der ArraysListe ein neues Objekt Familienmitglied übergeben
        familienmitgliedService.addFamilienmitglied(familienmitglied);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/familienmitglied/{id}") 	//im Falle der RequestMethode PUT auf den  Pfad/Wert /familienmitglied/{id} wird das Objekt der ArrayListe mit entsprechender id
    public void updateFamilienmitglied(@PathVariable Integer id, @RequestBody Familienmitglied familienmitglied) { //geupdatet/ausgetauscht mit dem neuen Objekt der Klasse Familienmitglied, welches von Nutzer eingegebe wird
        familienmitgliedService.updateFamilienmitglied(id, familienmitglied);		//auch die id des Objektes kann geupdated/ausgetauscht werden
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/familienmitglied/{id}")//Zu guter Letzt und im Falle der RequestMethode DELETE auf den  Pfad/Wert /familienmitglied/{id} 
    public void deleteFamilienmitglied(@PathVariable Integer id) {					//wird das Objekt der ArrayListe mit entsprechender id gelöscht
		familienmitgliedService.deleteFamilienmitglied(id);
	}
    
}