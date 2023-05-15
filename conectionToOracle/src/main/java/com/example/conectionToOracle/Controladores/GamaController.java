package com.example.conectionToOracle.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectionToOracle.Modelos.Gama;
import com.example.conectionToOracle.Servicios.GamaServices;

import java.util.List;

@RestController
@RequestMapping("api/Gama")
public class GamaController {
    
    @Autowired
    public GamaServices gamaServices;

    @GetMapping("/all") 
    public List<Gama> getGama() {
        return gamaServices.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Gama save(@RequestBody Gama gama) {
        return gamaServices.save(gama);
    }

}