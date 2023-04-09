package fh.aalen.familienmitglied;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Im Serviece liegt die Logik, welche eigene methoden definiert und dafür die Methoden des CRUD Repository verwendet
public class FamilienmitgliedService {
	
	//Objekte
	
    @Autowired
    private FamilienmitgliedRepository familienmitgliedRepository; //wir erzeugen ein Objekt der Klasse Familienrepository

    //Methoden
    
    public List<Familienmitglied> getFamilienmitgliedList() { 	//wir erzeugen eine Methode getFamilienmitgliedList() die eine Liste von Familienmitgliedobjekten zurückgibt
        ArrayList<Familienmitglied> mylist = new ArrayList<>(); //wir implementieren die ArrayList als "myList"
        Iterator<Familienmitglied> it = familienmitgliedRepository.findAll().iterator(); //wir implementieren einen Iterator als "it" 
        while (it.hasNext()) //der so lange durch die Objekte Familienmitglied iteriert wie es mehr Objekte gibt
            mylist.add(it.next()); //diese dann der ArrayListe myList hinzufügt
        return mylist; //und diese Liste dann ausgibt
    }

    public Familienmitglied getFamilienmitglied(Integer id) { //wir geben ein Objekt Familienmitglied zurück (abgefragt über id)
        return familienmitgliedRepository.findById(id).orElse(null);	//im FamilienmitgliedRepository suchen wir nach der id und geben dieses Objekt zurück
    }																	// - oder null, wenn kein Objekt Familienmitglied diese id hat

    public void addFamilienmitglied(Familienmitglied familienmitglied) { //wir speisen ein Objekt Familienmitglied ein
        familienmitgliedRepository.save(familienmitglied); //wir speichern es im Repository
    }

    public void updateFamilienmitglied(Integer id, Familienmitglied familienmitglied) { //wir tauschen ein bestehendes Objekt Familienmitglied durch ein Neues aus - basierend auf der id
        familienmitgliedRepository.save(familienmitglied);//wir speichern es im Repository
    }

    public void deleteFamilienmitglied(Integer id) { //wir löschen ein bestehendes Objekt Familienmitglied - basierend auf der id
        familienmitgliedRepository.deleteById(id); //wir löschen es aus dem Rpository
    } 
}