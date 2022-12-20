package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Fahrzeug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FahrzeugService {

    private final FahrzeugRepository repository;

    @Autowired
    public FahrzeugService(FahrzeugRepository repository) {
        this.repository = repository;
    }

    public Optional<Fahrzeug> get(UUID id) {
        return repository.findById(id);
    }

    public Fahrzeug update(Fahrzeug entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Fahrzeug> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
