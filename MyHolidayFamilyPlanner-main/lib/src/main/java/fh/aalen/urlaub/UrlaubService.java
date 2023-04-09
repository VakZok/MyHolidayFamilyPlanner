package fh.aalen.urlaub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Im Serviece liegt die Logik, welche eigene methoden definiert und dafür die Methoden des CRUD Repository verwendet
public class UrlaubService {
	
	//Objekte
	
    @Autowired 
    private UrlaubRepository urlaubRepository;  //wir erzeugen ein Objekt der Klasse Familienrepository
    
    //Methoden
    
    public List<Urlaub> getUrlaubList() { //wir erzeugen eine Methode getUrlaubList() die eine Liste von Urlaubobjekten zurückgibt
        ArrayList<Urlaub> mylist = new ArrayList<>();  //wir implementieren die ArrayList als "myList"
        Iterator<Urlaub> it = urlaubRepository.findAll().iterator(); //wir implementieren einen Iterator als "it" 
        while (it.hasNext()) //der so lange durch die Objekte Urlaub iteriert wie es mehr Objekte gibt
            mylist.add(it.next()); //diese dann der ArrayListe myList hinzufügt
        return mylist; //und diese Liste dann ausgibt
    }

    public Urlaub getUrlaub(Integer id) { //wir geben ein Objekt Urlaub zurück (abgefragt über id)
        return urlaubRepository.findById(id).orElse(null); 	//im UrlaubRepository suchen wir nach der id und geben dieses Objekt zurück - 
    }    													//oder null, wenn kein Objekt Urlaub diese id hat

    public void addUrlaub(Urlaub urlaub) {  //wir speisen ein Objekt Urlaub ein
        urlaubRepository.save(urlaub);  //wir speichern es im Repository
    }

    public void updateUrlaub(Integer id, Urlaub urlaub) { //wir tauschen ein bestehendes Objekt Urlaub durch ein Neues aus - basierend auf der id
        urlaubRepository.save(urlaub); //wir speichern es im Repository
    }

    public void deleteUrlaub(Integer id) { //wir löschen ein bestehendes Objekt Urlaub - basierend auf der id
        urlaubRepository.deleteById(id); //wir löschen es aus dem Rpository
    }
    
}