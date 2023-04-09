package fh.aalen.prio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrioRatingRepository extends CrudRepository<PrioRating, PrioRatingId> { //unser Rpository erweitert das CRUD Repository, welches Create, Read, Update und Delete methoden enthält

	@Query("select distinct urlaubswunsch.urlaub.titel, urlaubswunsch.urlaub.zeitraum, urlaubswunsch.ort, urlaubswunsch.beschreibung, avg(prio) from PrioRating group by urlaubswunsch.urlaub.titel, urlaubswunsch.urlaub.zeitraum, urlaubswunsch.ort, urlaubswunsch.beschreibung order by avg(prio) desc")
	List getAvgPrioRating(); //wir erzeugen eine Abfrage als neue Methode, mit der wir eine Liste aller average PrioRatings jedes Urlaubswunsches ausgegeben bekommen und so den Urlaubswunsch finden können, der im Schnitt am höchsten gewertet wurde
}