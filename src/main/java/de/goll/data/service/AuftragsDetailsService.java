package de.goll.data.service;

import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Auftragsdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuftragsDetailsService {

    private final AuftragsDetailsRepository repository;

    @Autowired
    public AuftragsDetailsService(AuftragsDetailsRepository repository) {
        this.repository = repository;
    }

    public Optional<Auftragsdetails> get(UUID id) {
        return repository.findById(id);
    }

    public Auftragsdetails update(Auftragsdetails entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Auftragsdetails> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

    public void saveAuftragdetails(Auftragsdetails auftragsdetails) {
        if (auftragsdetails == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        repository.save(auftragsdetails);
    }

}
