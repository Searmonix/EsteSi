package com.example.conectionToOracle.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.conectionToOracle.Servicios.CarServices;

import java.util.List;
import java.util.Optional;

import com.example.conectionToOracle.Modelos.Car;

@RestController
@RequestMapping("api/Car")
public class CarController {
    
    @Autowired                              // Instanciar la clase CarServices, utilizar métodos y atributos
    private CarServices carServices;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Car> getCars() {            // Que me traiga todos los elementos
        return carServices.getAll(); 
    }

    //@GetMapping("/{id}")
    //public Optional<Car> getCar(@PathVariable("id") int car_id) {
    //   return carServices.getCar(car_id);
    //}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Car save(@RequestBody Car car) {                         // Devuelve el Car, devuelve un car, car viene del cuerpo de la petición
        return carServices.save(car);                               // Guarda el elemento entregado de la petición
    }

    //@PutMapping("/update")

    //@DeleteMapping("/{id}")
    //public void 
    
}


