package com.example.conectionToOracle.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.SuperUser;

@Repository
public interface SuperUserCrudRepository extends CrudRepository<SuperUser, Integer>{
    
}
