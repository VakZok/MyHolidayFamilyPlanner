package fh.aalen.urlaub;

import org.springframework.data.repository.CrudRepository;

public interface UrlaubRepository extends CrudRepository<Urlaub, Integer> {}  //unser Rpository erweitert das CRUD Repository, welches Create, Read, Update und Delete methoden enthält