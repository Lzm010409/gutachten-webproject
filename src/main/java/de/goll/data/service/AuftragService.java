package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuftragService {

    private final AuftragRepository repository;

    @Autowired
    public AuftragService(AuftragRepository repository) {
        this.repository = repository;
    }

    public Optional<Auftrag> get(UUID id) {
        return repository.findById(id);
    }

    public Auftrag update(Auftrag entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Auftrag> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
