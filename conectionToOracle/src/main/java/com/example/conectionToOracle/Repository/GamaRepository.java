package com.example.conectionToOracle.Repository;
import java.util.List;
import java.util.Optional;
import com.example.conectionToOracle.Modelos.Gama;
import com.example.conectionToOracle.Repository.CrudRepository.GamaCrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class GamaRepository {

    @Autowired
    private GamaCrudRepository gamaCrudRepository;

    public List<Gama> getAll() { 
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    public Optional<Gama> getGama(int id) { 
        return gamaCrudRepository.findById(id); 
    }

    public Gama save(Gama gama) { 
        return gamaCrudRepository.save(gama); 
    }

    public void delete(Gama gama) { 
        gamaCrudRepository.delete(gama); 
    }
}
