package com.example.springPostgres.controllerREST;

import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/indirizzo")

public class IndirizzoController {
    @Autowired
    public IndirizzoRepository indRepository;

    @GetMapping   // GET Method for reading operation
    public List<Indirizzo> getAllindirizzo() {
        return indRepository.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Indirizzo> getIndirizzoById(@PathVariable(value = "id") Long indId)
            throws Exception {

        Indirizzo indirizzo = indRepository.findById(indId)
                .orElseThrow(() -> new Exception("Phone " + indId + " not found"));
        return ResponseEntity.ok().body(indirizzo);
    }


    @PostMapping    // POST Method for Create operation
    public Indirizzo createPhone(@RequestBody Indirizzo ind) {
        return indRepository.save(ind);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(
            @PathVariable(value = "id") long indId,  @RequestBody Indirizzo anaDetails)
            throws Exception {

        Indirizzo indirizzo = indRepository.findById(indId)
                .orElseThrow(() -> new Exception("Indirizzo" + indId + " not found"));

        indirizzo.setIdAna(anaDetails.getIdAna());
        indirizzo.setDescrizione(anaDetails.getDescrizione());
        indirizzo.setDate_create(anaDetails.getDate_create());
        indirizzo.setDate_agg(anaDetails.getDate_agg());

        final Indirizzo updatedPhone = indRepository.save(indirizzo);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteIndirizzo(@PathVariable(value = "id") Long indId) throws Exception {
        Indirizzo indirizzo = indRepository.findById(indId)
                .orElseThrow(() -> new Exception("Phone " + indId + " not found"));

        indRepository.delete(indirizzo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
