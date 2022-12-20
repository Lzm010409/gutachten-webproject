package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KundeRepository extends JpaRepository<Kunde, UUID> {

    Kunde findKundeByName(String name);
}