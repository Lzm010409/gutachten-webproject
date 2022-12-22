package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Auftragsdetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuftragsDetailsRepository extends JpaRepository<Auftragsdetails, UUID> {

    Auftragsdetails findAuftragsdetailsById(UUID name);
}