package com.backend.services;


import com.backend.entities.Client;
import com.backend.entities.RendezVous;
import com.backend.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {
    @Autowired
    RendezVousRepository rendezVousRepository;
    @Autowired
    ClientService clientService;

    public List<RendezVous> findAll() {
        return rendezVousRepository.findAll();
    }
    public void addRendezVous(RendezVous s) {
        Client tmp = clientService.getByUsername(s.getClients().getUsername());
        if(tmp!= null) {
            if (s.getDate1()!=s.getDate2() && !s.getDate1().equals(LocalDateTime.now()) && s.getDate2().after(s.getDate1())) {
                s.setDt(LocalDateTime.now());
                rendezVousRepository.save(s);
            }
        }
    }
    public void deleteById(Long aLong) {
        rendezVousRepository.deleteById(aLong);
    }
    public void confirmRendezVous(RendezVous s){
       s.setConfirmed(true);
       rendezVousRepository.save(s);

    }

    public Optional<RendezVous> findById(Long id) {
        return rendezVousRepository.findById(id);
    }

}
