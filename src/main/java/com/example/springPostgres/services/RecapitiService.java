package com.example.springPostgres.services;

import com.example.springPostgres.model.RecapitiTelefonici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecapitiService extends JpaRepository<RecapitiTelefonici, Long> {

}
