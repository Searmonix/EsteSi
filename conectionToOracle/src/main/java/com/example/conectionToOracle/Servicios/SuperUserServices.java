package com.example.conectionToOracle.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.SuperUser;
import com.example.conectionToOracle.Repository.SuperUserRepository;

@Service
public class SuperUserServices {

    @Autowired
    private SuperUserRepository superUserRepository;

    public List<SuperUser> getAll() {
        return superUserRepository.getAll();
    }

    public SuperUser save(SuperUser superUser) {                                                                                      
            return superUserRepository.save(superUser);                                    
    }

}