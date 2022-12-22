package de.goll.data.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "application_auftrag")
public class Auftrag extends AbstractEntity {
    private String auftragsNummer;
    private String kundeName;
    private UUID rechtsanwaltUUID;
    private String rechtsanwaltName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Fahrzeug",
            referencedColumnName = "FahrzeugUUID",
            updatable = false,
            nullable = false)
    private Fahrzeug fahrzeug;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Auftragsdetails",
            referencedColumnName = "AuftragsdetailsUUID",
            updatable = false,
            nullable = false)
    private Auftragsdetails auftragsdetails;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Kunde",
            referencedColumnName = "KundeUUID",
            updatable = false,
            nullable = false)
    private Kunde kunde;

    public String getAuftragsNummer() {
        return auftragsNummer;
    }

    public void setAuftragsNummer(String auftragsNummer) {
        this.auftragsNummer = auftragsNummer;
    }

    public String getKundeName() {
        return kundeName;
    }

    public void setKundeName(String kundeName) {
        this.kundeName = kundeName;
    }

    public UUID getRechtsanwaltUUID() {
        return rechtsanwaltUUID;
    }

    public void setRechtsanwaltUUID(UUID rechtsanwaltUUID) {
        this.rechtsanwaltUUID = rechtsanwaltUUID;
    }

    public String getRechtsanwaltName() {
        return rechtsanwaltName;
    }

    public void setRechtsanwaltName(String rechtsanwaltName) {
        this.rechtsanwaltName = rechtsanwaltName;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Auftragsdetails getAuftragsdetails() {
        return auftragsdetails;
    }

    public void setAuftragsdetails(Auftragsdetails auftragsdetails) {
        this.auftragsdetails = auftragsdetails;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
