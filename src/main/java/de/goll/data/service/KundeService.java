package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class KundeService {

    private final KundeRepository repository;

    @Autowired
    public KundeService(KundeRepository repository) {
        this.repository = repository;
    }

    public Optional<Kunde> get(Long id) {
        return repository.findById(id);
    }

    public Kunde update(Kunde entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Kunde> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
