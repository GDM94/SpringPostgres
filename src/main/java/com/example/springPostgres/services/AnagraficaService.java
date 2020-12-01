package com.example.springPostgres.services;

import com.example.springPostgres.model.Anagrafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnagraficaService extends JpaRepository<Anagrafica, Long> {

    @Query(value = "SELECT ana.nome, reca.numero_recapito from anagrafica ana INNER JOIN recapiti_telefonici reca ON ana.idana = reca.idana WHERE ana.idana = :id",
            nativeQuery = true)
    List<String> getName_Numero(@Param("id") long id);


}

