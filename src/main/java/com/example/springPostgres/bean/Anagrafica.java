package com.example.springPostgres.bean;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Anagrafica")
@EntityListeners(AuditingEntityListener.class)
public class Anagrafica {
    @Id
    @GeneratedValue private int id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="cognome", nullable = false)
    private String cognome;

    @Column(name = "data_create", nullable = false)
    private java.util.Date data_create;

    @Column(name = "data_agg", nullable = false)
    private java.util.Date data_agg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_create() {
        return data_create;
    }

    public void setData_create(Date data_create) {
        this.data_create = data_create;
    }

    public Date getData_agg() {
        return data_agg;
    }

    public void setData_agg(Date data_agg) {
        this.data_agg = data_agg;
    }

}
