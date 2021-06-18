package com.backend.repositories;

import com.backend.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
