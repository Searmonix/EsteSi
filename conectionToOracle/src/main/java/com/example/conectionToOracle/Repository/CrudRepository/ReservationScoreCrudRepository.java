package com.example.conectionToOracle.Repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.ReservationScore;

@Repository
public interface ReservationScoreCrudRepository extends CrudRepository<ReservationScore, Integer> {

}