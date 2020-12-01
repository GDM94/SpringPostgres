package com.example.springPostgres.repository;

import com.example.springPostgres.bean.RecapitiTelefonici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecapitiRepository extends JpaRepository<RecapitiTelefonici, Long> {

}
