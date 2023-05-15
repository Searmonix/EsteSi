package com.example.conectionToOracle.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.Reservation;
import com.example.conectionToOracle.Repository.ReservationRepository;

@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id) { 
        return reservationRepository.getReservation(id); 
    }

    public Reservation save(Reservation reservation) {                                             
        if (reservation.getId()==0) {                                            
            return reservationRepository.save(reservation);                                     
        } else {
            Optional<Reservation> element = reservationRepository.getReservation(reservation.getId());     
            if (element.isPresent()) {
                return reservation;

            } else {
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getId() != 0) {                                                    
            Optional<Reservation> elementToUpdate = reservationRepository.getReservation(reservation.getId());
            if (elementToUpdate.isPresent()) {                                   
                if (reservation.getPickUpDate() != null) {                                      
                    elementToUpdate.get().setPickUpDate(reservation.getPickUpDate());                
                }

                if (reservation.getReturnDate() != null) {    
                    elementToUpdate.get().setReturnDate(reservation.getReturnDate());
                }

                reservationRepository.save(elementToUpdate.get());                        
                return elementToUpdate.get();

            } else {
                return reservation;
            }

        } else {
            return reservation;
        }
    }

    public boolean delete(int id) {                         
        boolean dataStatus = false;                        
        Optional<Reservation> elementToDelete = reservationRepository.getReservation(id);
        if (elementToDelete.isPresent()) {
            reservationRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    } 
}
