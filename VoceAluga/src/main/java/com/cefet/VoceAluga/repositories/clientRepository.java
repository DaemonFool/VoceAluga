package com.cefet.VoceAluga.repositories;

import com.cefet.VoceAluga.models.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<client, Integer> {
}
