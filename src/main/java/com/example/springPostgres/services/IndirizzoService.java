package com.example.springPostgres.services;

import com.example.springPostgres.model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndirizzoService extends JpaRepository<Indirizzo, Long> {

}
