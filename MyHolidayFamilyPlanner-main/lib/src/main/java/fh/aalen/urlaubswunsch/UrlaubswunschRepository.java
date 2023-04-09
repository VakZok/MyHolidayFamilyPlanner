package fh.aalen.urlaubswunsch;

import org.springframework.data.repository.CrudRepository;

public interface UrlaubswunschRepository extends CrudRepository<Urlaubswunsch, Integer> {} //unser Rpository erweitert das CRUD Repository, welches Create, Read, Update und Delete methoden enthält