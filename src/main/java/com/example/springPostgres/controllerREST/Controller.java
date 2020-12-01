package com.example.springPostgres.controllerREST;

import com.example.springPostgres.bean.*;
import com.example.springPostgres.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    public AnagraficaRepository anaRepository;

    @GetMapping("/anagrafica")   // GET Method for reading operation
    public List<Anagrafica> getAllanagrafica() {
        return anaRepository.findAll();
    }

    @PostMapping("/anagrafica")     // POST Method for Create operation
    public Anagrafica createPhone(@RequestBody Anagrafica ana) {
        return anaRepository.save(ana);
    }
}
