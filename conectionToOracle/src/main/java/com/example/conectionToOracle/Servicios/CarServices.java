package com.example.conectionToOracle.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.Car;
import com.example.conectionToOracle.Repository.CarRepository;

@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {                     // Traer todas las columnas 
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int id) { 
        return carRepository.getCar(id); 
    }

    public Car save(Car car) {                                              // Guardar siempre y cuando sea nuevo
        if (car.getId()==0) {                                               // Si el nuevo carro tiene id 0
            return carRepository.save(car);                                     
        } else {
            Optional<Car> element = carRepository.getCar(car.getId());      // Optional ayuda a evitar problemas con null
            if (element.isPresent()) {
                return car;

            } else {
            return carRepository.save(car);
           }
        }
    }

    public Car update(Car car) {
        if (car.getId() != 0) {                                                     // Si el id existe
            Optional<Car> elementToUpdate = carRepository.getCar(car.getId());    // Traer ese objeto de la base de datos
            if (elementToUpdate.isPresent()) {                                    // Si no es nulo ese objeto, hacer las siguientes operaciones, y si existe uno con ese id
                if (car.getName() != null) {                                        // Traer el nombre dentro de ella
                    elementToUpdate.get().setName(car.getName());                 // El elementro traído, obtiene nuevos datos con el setName. Ahora los nuevos valores los trae
                }

                if (car.getBrand() != null) {    
                    elementToUpdate.get().setBrand(car.getBrand());
                }

                if (car.getModel() != 0) {
                    elementToUpdate.get().setModel(car.getModel());
                }

                if (car.getDescription() != null) {
                    elementToUpdate.get().setDescription(car.getDescription());
                }

                carRepository.save(elementToUpdate.get());                                // Guarda todos los cambios hechos
                return elementToUpdate.get();

            } else {
                return car;
            }

        } else {
            return car;
        }
    }

    public boolean delete(int id) {                         // Recibe un id
        boolean dataStatus = false;                         // Como estado de borrado inicializamos una variable con un valor falso
        Optional<Car> elementToDelete = carRepository.getCar(id);
        if (elementToDelete.isPresent()) {
            carRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    } 
}

