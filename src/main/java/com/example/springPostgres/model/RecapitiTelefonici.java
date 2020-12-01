package com.example.springPostgres.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name= "recapiti_telefonici")
@EntityListeners(AuditingEntityListener.class)
public class RecapitiTelefonici {
    @Id
    private long idreca;

    @Column(name="idana", nullable = false)
    private long idana;

    @Column(name="tipo_recapito", nullable = false)
    private String tipo_recapito;

    @Column(name="numero_recapito", nullable = false)
    private String numero_recapito;

    public long getIdreca() {
        return idreca;
    }

    public void setIdreca(long idreca) {
        this.idreca = idreca;
    }

    public long getIdana() {
        return idana;
    }

    public void setIdana(long idana) {
        this.idana = idana;
    }

    public String getTipo_recapito() {
        return tipo_recapito;
    }

    public void setTipo_recapito(String tipo_recapito) {
        this.tipo_recapito = tipo_recapito;
    }

    public String getNumero_recapito() {
        return numero_recapito;
    }

    public void setNumero_recapito(String numero_recapito) {
        this.numero_recapito = numero_recapito;
    }
}
