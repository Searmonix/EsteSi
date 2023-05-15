package com.example.conectionToOracle.Repository;
import java.util.List;
import java.util.Optional;
import com.example.conectionToOracle.Modelos.Client;
import com.example.conectionToOracle.Repository.CrudRepository.ClientCrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() { 
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) { 
        return clientCrudRepository.findById(id); 
    }

    public Client save(Client client) { 
        return clientCrudRepository.save(client); 
    }

    public void delete(Client client) { 
        clientCrudRepository.delete(client); 
    }
}