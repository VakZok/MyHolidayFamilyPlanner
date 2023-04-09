package fh.aalen.urlaubswunsch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Im Serviece liegt die Logik, welche eigene methoden definiert und dafür die Methoden des CRUD Repository verwendet
public class UrlaubswunschService {
	
	//Objekte
	
    @Autowired
    private UrlaubswunschRepository urlaubswunschRepository; //wir erzeugen ein Objekt der Klasse Familienrepository
    
    //Methoden
    
    public List<Urlaubswunsch> getUrlaubswunschList() { //wir erzeugen eine Methode getUrlaubswunschList() die eine Liste von Urlaubswunschobjekten zurückgibt
        ArrayList<Urlaubswunsch> mylist = new ArrayList<>(); //wir implementieren die ArrayList als "myList"
        Iterator<Urlaubswunsch> it = urlaubswunschRepository.findAll().iterator(); //wir implementieren einen Iterator als "it" 
        while (it.hasNext())  //der so lange durch die Objekte Urlaubswunsch iteriert wie es mehr Objekte gibt
            mylist.add(it.next()); //diese dann der ArrayListe myList hinzufügt
        return mylist;  //und diese Liste dann ausgibt
    }

    public Urlaubswunsch getUrlaubswunsch(Integer id) { //wir geben ein Objekt Urlaubswunsch zurück (abgefragt über id)
        return urlaubswunschRepository.findById(id).orElse(null); 	//im UrlaubswunschRepository suchen wir nach der id und geben dieses Objekt zurück
    }    															// - oder null, wenn kein Objekt Urlaubswunsch diese id hat

    public void addUrlaubswunsch(Urlaubswunsch urlaubswunsch) { //wir speisen ein Objekt Urlaubswunsch ein
        urlaubswunschRepository.save(urlaubswunsch); //wir speichern es im Repository
    }

    public void updateUrlaubswunsch(Integer id, Urlaubswunsch urlaubswunsch) { //wir tauschen ein bestehendes Objekt Urlaubswunsch durch ein Neues aus - basierend auf der id
        urlaubswunschRepository.save(urlaubswunsch); //wir speichern es im Repository
    }

    public void deleteUrlaubswunsch(Integer id) { //wir löschen ein bestehendes Objekt Urlaubswunsch - basierend auf der id
        urlaubswunschRepository.deleteById(id);  //wir löschen es aus dem Rpository
	}

}