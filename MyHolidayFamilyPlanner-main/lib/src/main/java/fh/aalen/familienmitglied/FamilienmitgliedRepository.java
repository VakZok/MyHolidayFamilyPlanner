package fh.aalen.familienmitglied;

import org.springframework.data.repository.CrudRepository;

public interface FamilienmitgliedRepository extends CrudRepository<Familienmitglied, Integer> {} //unser Rpository erweitert das CRUD Repository, welches Create, Read, Update und Delete methoden enthält