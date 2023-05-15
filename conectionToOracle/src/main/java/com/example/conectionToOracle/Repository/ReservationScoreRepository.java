package com.example.conectionToOracle.Repository;
import java.util.List;

import com.example.conectionToOracle.Modelos.ReservationScore;

import com.example.conectionToOracle.Repository.CrudRepository.ReservationScoreCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ReservationScoreRepository {

    @Autowired
    private ReservationScoreCrudRepository reservationScoreCrudRepository;

    public List<ReservationScore> getAll() { 
        return (List<ReservationScore>) reservationScoreCrudRepository.findAll();
    }

    public ReservationScore save(ReservationScore reservationScore) { 
        return reservationScoreCrudRepository.save(reservationScore); 
    }
    
}