package com.example.springPostgres.controllerREST;

import com.example.springPostgres.bean.*;
import com.example.springPostgres.repository.*;
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
    public AnagraficaRepository anaRepository;

    @GetMapping   // GET Method for reading operation
    public List<Anagrafica> getAllanagrafica() {
        return anaRepository.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Anagrafica> getAnagraficaById(@PathVariable(value = "id") Long anaId)
            throws Exception {

        Anagrafica anagrafica = anaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Phone " + anaId + " not found"));
        return ResponseEntity.ok().body(anagrafica);
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
