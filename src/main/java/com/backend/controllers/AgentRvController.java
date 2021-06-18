package com.backend.controllers;

import com.backend.entities.RendezVous;
import com.backend.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AgentRvController {
    @Autowired
    RendezVousService rendezVousService;

    //Get
    @GetMapping("/AgentRv")
    @ResponseStatus(HttpStatus.OK)
    public List<RendezVous> findAll() {
        return rendezVousService.findAll();
    }

    //Put
    @PutMapping("/AgentRv")
    @ResponseStatus(HttpStatus.OK)
    public void confirmRendezVous(@RequestBody RendezVous s) {
        rendezVousService.confirmRendezVous(s);
    }

    //Delete
    @DeleteMapping("/AgentRv/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Long id) {
        rendezVousService.deleteById(id);
    }


}
