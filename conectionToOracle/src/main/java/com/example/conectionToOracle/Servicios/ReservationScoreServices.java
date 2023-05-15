package com.example.conectionToOracle.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.ReservationScore;
import com.example.conectionToOracle.Repository.ReservationScoreRepository;

@Service
public class ReservationScoreServices {

    @Autowired
    private ReservationScoreRepository reservationScoreRepository;

    public List<ReservationScore> getAll() {
        return reservationScoreRepository.getAll();
    }

    public ReservationScore save(ReservationScore reservationScore) {                                                                                      
            return reservationScoreRepository.save(reservationScore);                                    
    }

}