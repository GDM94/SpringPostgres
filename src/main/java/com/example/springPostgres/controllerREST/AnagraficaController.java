package com.example.springPostgres.controllerREST;

import com.example.springPostgres.bean.*;
import com.example.springPostgres.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
    @Autowired
    public AnagraficaRepository anaRepository;

    @GetMapping   // GET Method for reading operation
    public List<Anagrafica> getAllanagrafica() {
        return anaRepository.findAll();
    }

    @PostMapping    // POST Method for Create operation
    public Anagrafica createPhone(@RequestBody Anagrafica ana) {
        return anaRepository.save(ana);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anagrafica> updateAnagrafica(
            @PathVariable(value = "id") long anaId,  @RequestBody Anagrafica anaDetails)
            throws Exception {

        Anagrafica anagrafica = anaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Anagrafica " + anaId + " not found"));

        anagrafica.setNome(anaDetails.getNome());
        anagrafica.setCognome(anaDetails.getCognome());
        anagrafica.setDate_create(anaDetails.getDate_create());
        anagrafica.setDate_agg(anaDetails.getDate_agg());

        final Anagrafica updatedPhone = anaRepository.save(anagrafica);
        return ResponseEntity.ok(updatedPhone);
    }


}
