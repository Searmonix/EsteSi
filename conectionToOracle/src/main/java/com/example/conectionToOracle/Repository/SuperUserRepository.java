package com.example.conectionToOracle.Repository;
import java.util.List;

import com.example.conectionToOracle.Modelos.SuperUser;

import com.example.conectionToOracle.Repository.CrudRepository.SuperUserCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SuperUserRepository {

    @Autowired
    private SuperUserCrudRepository superUserCrudRepository;

    public List<SuperUser> getAll() { 
        return (List<SuperUser>) superUserCrudRepository.findAll();
    }

    public SuperUser save(SuperUser superUser) { 
        return superUserCrudRepository.save(superUser); 
    }
    
}