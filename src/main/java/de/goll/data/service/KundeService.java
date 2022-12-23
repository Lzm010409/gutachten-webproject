package de.goll.data.service;

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

    public Optional<Kunde> get(UUID id) {
        return repository.findById(id);
    }

    public Kunde update(Kunde entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Kunde> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

    public void saveKunde(Kunde kunde) {
        if (kunde == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        repository.save(kunde);
    }

}
