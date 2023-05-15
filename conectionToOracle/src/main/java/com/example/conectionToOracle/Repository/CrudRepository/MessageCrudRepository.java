package com.example.conectionToOracle.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.Message;

@Repository
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
