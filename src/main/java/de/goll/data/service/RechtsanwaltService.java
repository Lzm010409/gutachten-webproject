package de.goll.data.service;

import de.goll.data.entity.Kunde;
import de.goll.data.entity.Rechtsanwalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RechtsanwaltService {

    private final RechtsanwaltRepository repository;

    @Autowired
    public RechtsanwaltService(RechtsanwaltRepository repository) {
        this.repository = repository;
    }

    public Optional<Rechtsanwalt> get(Long id) {
        return repository.findById(id);
    }

    public Rechtsanwalt update(Rechtsanwalt entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Rechtsanwalt> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
