package com.example.conectionToOracle.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectionToOracle.Modelos.Reservation;
import com.example.conectionToOracle.Servicios.ReservationServices;

import java.util.List;


@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
    
    @Autowired
    public ReservationServices reservationServices;

    @GetMapping("/all") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Reservation> getReservation() {
        return reservationServices.getAll();
    }

    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationServices.save(reservation);
    }

}
