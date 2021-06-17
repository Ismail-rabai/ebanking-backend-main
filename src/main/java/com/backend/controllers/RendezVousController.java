package com.backend.controllers;

import com.backend.entities.RendezVous;
import com.backend.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RendezVousController {
    @Autowired
    private RendezVousService rendezVousService;


    //Get
    @GetMapping("/RendezVous")
    @ResponseStatus(HttpStatus.OK)
    public List<RendezVous> findAll() {
        return rendezVousService.findAll();
    }
    @GetMapping("/RendesVous/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RendezVous> findById(@PathVariable Long id) {
        return rendezVousService.findById(id);
    }


    //Post
    @PostMapping("/RendezVous")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRendezVous(@RequestBody RendezVous s) {
        rendezVousService.addRendezVous(s);
    }


    //Delete
    @DeleteMapping("/RendezVous/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        rendezVousService.deleteById(id);
    }

}
