package com.example.conectionToOracle.Modelos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="Message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int message_id;
    private String messageText;
    // private int car_id;

    @ManyToOne
    @JoinColumn(name="car_id")                       // Nombre del atributo en nuestra base de datos
    @JsonIgnoreProperties({"messages", "reservation"})                // Plural, porque es el conjunto de elementos de la clase Message, que referencia al objeto car_id
    private Car car;                                 

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages", "reservation"})  // client_id y car_id tienen una relación con reservation, por lo que se ponen acá
    private Client client;


    public int getMessageId() {
        return message_id;
    }
    public void setMessageId(int message_id) {
        this.message_id = message_id;
    }

    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    // public int setCarId() {                              // Esto ya está declarado implícitamente
    //    return car_id;
    //}
    //public void getCarId(int car_id) {
    //    this.car_id = car_id;
    //}



}
