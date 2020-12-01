package com.example.springPostgres.bean;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "anagrafica")
@EntityListeners(AuditingEntityListener.class)
public class Anagrafica {
    @Id
    private long idana;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="cognome", nullable = false)
    private String cognome;

    @Column(name = "date_create", nullable = false)
    private java.util.Date date_create;

    @Column(name = "date_agg", nullable = false)
    private java.util.Date date_agg;

    public long getIdana() {
        return idana;
    }

    public void setIdana(long idana) {
        this.idana = idana;
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

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public Date getDate_agg() {
        return date_agg;
    }

    public void setDate_agg(Date date_agg) {
        this.date_agg = date_agg;
    }

}
