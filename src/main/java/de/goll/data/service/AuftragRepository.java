package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuftragRepository extends JpaRepository<Auftrag, Long> {

    Auftrag findAuftragByAuftragsNummer(String name);
}