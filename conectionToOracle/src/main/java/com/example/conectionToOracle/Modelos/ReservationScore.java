package com.example.conectionToOracle.Modelos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Score")
public class ReservationScore implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreId;
    
    private String scoreMessage;
    private int score;
    
    @OneToOne
    @JoinColumn(name = "reservation_id")
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    
    public String getScoreMessage() {
        return scoreMessage;
    }
    public void setScoreMessage(String scoreMessage) {
        this.scoreMessage = scoreMessage;
    }


    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
