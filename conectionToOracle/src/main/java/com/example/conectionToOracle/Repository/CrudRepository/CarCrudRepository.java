package com.example.conectionToOracle.Repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.Car;

@Repository
public interface CarCrudRepository extends CrudRepository<Car, Integer> {

}