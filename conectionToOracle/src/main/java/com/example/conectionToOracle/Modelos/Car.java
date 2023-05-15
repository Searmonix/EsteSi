package com.example.conectionToOracle.Modelos;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Car")
public class Car implements Serializable {              // Serializador, ORM que convierte información de objeto a JSON para la base de datos

    @Id                                                 // Indica que id sera el identificador 
    @GeneratedValue(strategy=GenerationType.IDENTITY)       // Sera de valor auto incrementable
    public int id;                                      // Declaración de atributos    

    public String name;
    public String brand;
    public int model;
    // public int gama;                                    // ¿Es necesario? Mensajes no es columna tampoco
    public String description;

    // La conexión entre llave foránea a llave primaria, ya que un carro puede tener muchos mensajes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy= "car")     // ON DELETE - ON UPDATE CASCADE, hará que se actualice o borre de la tabla hija
    @JsonIgnoreProperties({"car", "client"})                                   
    private List<Message> messages;                                  // Un Carro es referenciado por un conjunto de Mensajes

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "messages"})
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "gama_id")
    @JsonIgnoreProperties("cars")
    private Gama gama;


    // Constructores para que el objeto tenga la misma plantilla que mi base de datos tiene
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }
    public void setModel(int model) {
        this.model = model;
    }

    //public int getGama() {
    //    return gama;
    //}
    //public void setGama(int gama) {
    //    this.gama = gama;
    //}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

 
    
    
}