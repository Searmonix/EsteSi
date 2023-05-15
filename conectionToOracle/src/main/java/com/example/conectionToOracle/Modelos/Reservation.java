package com.example.conectionToOracle.Modelos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date pickUpDate;                        // Date existe 0_0
    private Date returnDate;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations","messages"})  // Un cliente puede tener muchos mensajes y muchas reservaciones
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnoreProperties("reservations")
    private Car car;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy="reservation")
    @JsonIgnoreProperties("reservations")
    private ReservationScore reservationScore;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }
    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
