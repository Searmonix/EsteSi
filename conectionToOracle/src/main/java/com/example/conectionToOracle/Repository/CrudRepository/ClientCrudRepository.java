package com.example.conectionToOracle.Repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.Client;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {

}