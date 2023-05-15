package com.example.conectionToOracle.Repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.conectionToOracle.Modelos.Reservation;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

}