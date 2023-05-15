package com.example.conectionToOracle.Repository;
import java.util.List;
import java.util.Optional;
import com.example.conectionToOracle.Modelos.Car;
import com.example.conectionToOracle.Repository.CrudRepository.CarCrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car> getAll() { 
        return (List<Car>) carCrudRepository.findAll();
    }

    public Optional<Car> getCar(int id) { 
        return carCrudRepository.findById(id); 
    }

    public Car save(Car car) { 
        return carCrudRepository.save(car); 
    }

    public void delete(Car car) { 
        carCrudRepository.delete(car); 
    }
}