package com.example.conectionToOracle.Repository;
import java.util.List;
import java.util.Optional;

import com.example.conectionToOracle.Modelos.Reservation;
import com.example.conectionToOracle.Repository.CrudRepository.ReservationCrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() { 
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) { 
        return reservationCrudRepository.findById(id); 
    }

    public Reservation save(Reservation reservation) { 
        return reservationCrudRepository.save(reservation); 
    }

    public void delete(Reservation reservation) { 
        reservationCrudRepository.delete(reservation); 
    }
}