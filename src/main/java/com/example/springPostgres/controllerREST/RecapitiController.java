package com.example.springPostgres.controllerREST;


import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.services.RecapitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recapiti")
public class RecapitiController {

    @Autowired
    public RecapitiService recapitiService;

    @GetMapping   // GET Method for reading operation
    public List<RecapitiTelefonici> getAllrecapiti() {
        return recapitiService.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<RecapitiTelefonici> getRecapitiById(@PathVariable(value = "id") Long recaId)
            throws Exception {

        RecapitiTelefonici recapiti = recapitiService.findById(recaId)
                .orElseThrow(() -> new Exception("Phone " + recaId + " not found"));
        return ResponseEntity.ok().body(recapiti);
    }

    @PostMapping    // POST Method for Create operation
    public RecapitiTelefonici createRecapiti(@RequestBody RecapitiTelefonici recapiti) {
        return recapitiService.save(recapiti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecapitiTelefonici> updateRecapiti(
            @PathVariable(value = "id") long recaId,  @RequestBody RecapitiTelefonici recaDetails)
            throws Exception {

        RecapitiTelefonici recapiti = recapitiService.findById(recaId)
                .orElseThrow(() -> new Exception("Anagrafica " + recaId + " not found"));

        recapiti.setTipo_recapito(recaDetails.getTipo_recapito());
        recapiti.setNumero_recapito(recaDetails.getNumero_recapito());

        final RecapitiTelefonici updatedRecapiti = recapitiService.save(recapiti);
        return ResponseEntity.ok(updatedRecapiti);
    }

    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteRecapiti(@PathVariable(value = "id") Long recaID) throws Exception {
        RecapitiTelefonici recapiti = recapitiService.findById(recaID)
                .orElseThrow(() -> new Exception("Phone " + recaID + " not found"));

        recapitiService.delete(recapiti);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
