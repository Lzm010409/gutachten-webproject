package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Fahrzeug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FahrzeugRepository extends JpaRepository<Fahrzeug, UUID> {

    Fahrzeug findFahrzeugByLicensePlate(String license);
    Fahrzeug findFahrzeugByFin(String license);
}