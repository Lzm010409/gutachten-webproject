package de.goll.data.service;

import de.goll.data.entity.Kunde;
import de.goll.data.entity.Rechtsanwalt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RechtsanwaltRepository extends JpaRepository<Rechtsanwalt, UUID> {

    Rechtsanwalt findRechtsanwaltByName(String name);
}