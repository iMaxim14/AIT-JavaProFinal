package de.ait.javalessons.repositories;

import de.ait.javalessons.model.CarWithDataBase;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarWithDataBase, String> {
}
