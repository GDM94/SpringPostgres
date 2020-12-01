package com.example.springPostgres.services;

import com.example.springPostgres.model.Anagrafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnagraficaService extends JpaRepository<Anagrafica, Long> {

    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d LEFT JOIN d.employees e")
    List<Anagrafica> fetchEmpDeptDataLeftJoin();


}

