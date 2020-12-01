package com.example.springPostgres.controllerREST;

import com.example.springPostgres.bean.Indirizzo;
import com.example.springPostgres.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/indirizzo")

public class IndirizzoController {
    @Autowired
    public IndirizzoRepository indRepository;

    @GetMapping   // GET Method for reading operation
    public List<Indirizzo> getAllindirizzo() {
        return indRepository.findAll();
    }

    @PostMapping    // POST Method for Create operation
    public Indirizzo createPhone(@RequestBody Indirizzo ind) {
        return indRepository.save(ind);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(
            @PathVariable(value = "id") long addId,  @RequestBody Indirizzo anaDetails)
            throws Exception {

        Indirizzo indirizzo = indRepository.findById(addId)
                .orElseThrow(() -> new Exception("Indirizzo" + addId + " not found"));

        indirizzo.setIdAna(anaDetails.getIdAna());
        indirizzo.setDescrizione(anaDetails.getDescrizione());
        indirizzo.setDate_create(anaDetails.getDate_create());
        indirizzo.setDate_agg(anaDetails.getDate_agg());

        final Indirizzo updatedPhone = indRepository.save(indirizzo);
        return ResponseEntity.ok(updatedPhone);
    }
}
