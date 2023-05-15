package com.example.conectionToOracle.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectionToOracle.Modelos.Client;
import com.example.conectionToOracle.Servicios.ClientServices;

import java.util.List;

@RestController
@RequestMapping("api/Client")
public class ClientController {
    
    @Autowired
    public ClientServices clientServices;

    @GetMapping("/all") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Client> getClients() {
        return clientServices.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Client save(@RequestBody Client client) {
        return clientServices.save(client);
    }

}
