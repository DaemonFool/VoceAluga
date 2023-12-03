package com.cefet.VoceAluga.repositories;

import com.cefet.VoceAluga.models.rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rentalRepository extends JpaRepository<rental, Integer> {
}
