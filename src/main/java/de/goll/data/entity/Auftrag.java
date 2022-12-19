package de.goll.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "application_auftrag")
public class Auftrag {
    @Id
    @GeneratedValue
    private long id;
    private String auftragsNummer;

    private String kunde;

    private String rechtsanwalt;


    public String getAuftragsNummer() {
        return auftragsNummer;
    }

    public void setAuftragsNummer(String auftragsNummer) {
        this.auftragsNummer = auftragsNummer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public String getRechtsanwalt() {
        return rechtsanwalt;
    }

    public void setRechtsanwalt(String rechtsanwalt) {
        this.rechtsanwalt = rechtsanwalt;
    }
}
