package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offer")
public class Offer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "nome must not be null, empty or blank")
    private String titolo;

    @NotNull(message = "dataInizio must not be null")
    @FutureOrPresent(message = "dataInizio cannot be set in the past")
    private LocalDate dataInizio;

    @FutureOrPresent(message = "dataFine cannot be set in the past")
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    @NotNull(message = "pizza must not be null")
    private Pizza pizza;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String toString(){
        return String.format("%s, inizia il %s", this.titolo, this.dataInizio.toString());
    }
}
