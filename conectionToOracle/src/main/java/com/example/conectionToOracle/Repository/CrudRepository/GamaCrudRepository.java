package com.example.conectionToOracle.Repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.Gama;

@Repository
public interface GamaCrudRepository extends CrudRepository<Gama, Integer> {

}