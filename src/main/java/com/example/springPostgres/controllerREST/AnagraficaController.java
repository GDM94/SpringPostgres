package com.example.springPostgres.controllerREST;

import com.example.springPostgres.model.*;
import com.example.springPostgres.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
    @Autowired
    public AnagraficaService anaRepository;

    @GetMapping   // GET Method for reading operation
    public List<Anagrafica> getAllanagrafica() {
        return anaRepository.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Anagrafica> getAnagraficaById(@PathVariable(value = "id") Long anaId)
            throws Exception {

        Anagrafica anagrafica = anaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Amagrafica " + anaId + " not found"));
        return ResponseEntity.ok().body(anagrafica);
    }

    @GetMapping("/query/{id}")
    public  List<String> getQueryID(@PathVariable(value = "id") long anaId) throws Exception {
        return anaRepository.getName_Numero(anaId);
    }


    @PostMapping    // POST Method for Create operation
    public Anagrafica createAnagrafica(@RequestBody Anagrafica ana) {
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

        final Anagrafica updatedAnagrafica = anaRepository.save(anagrafica);
        return ResponseEntity.ok(updatedAnagrafica);
    }

    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteAnagrafica(@PathVariable(value = "id") Long anaID) throws Exception {
        Anagrafica anagrafica = anaRepository.findById(anaID)
                .orElseThrow(() -> new Exception("Phone " + anaID + " not found"));

        anaRepository.delete(anagrafica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
