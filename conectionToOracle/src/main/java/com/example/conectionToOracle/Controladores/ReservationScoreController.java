package com.example.conectionToOracle.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectionToOracle.Modelos.ReservationScore;
import com.example.conectionToOracle.Servicios.ReservationScoreServices;

import java.util.List;

@RestController
@RequestMapping("api/ReservationScore")
public class ReservationScoreController {
    
    @Autowired
    public ReservationScoreServices reservationScoreServices;

    @GetMapping("/all") 
    public List<ReservationScore> getGama() {
        return reservationScoreServices.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ReservationScore save(@RequestBody ReservationScore reservationScore) {
        return reservationScoreServices.save(reservationScore);
    }

}
