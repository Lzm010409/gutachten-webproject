package de.goll.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "application_auftrag")
public class Auftrag extends AbstractEntity {
    private String auftragsNummer;

    private String kundeName;
    private UUID kundenUUID;
    private UUID rechtsanwaltUUID;
    private String rechtsanwaltName;
    private UUID fahrzeugUUID;

    private String fahrzeugLicense;

    private String date;
    private String accidentDate;
    private String accidentPlace;
    private String damageNumber;
    private String insurance;
    private String licensePlateEnemy;
    private String emailWorkshop;
    private String visitPlace;
    private String visitTimePlace;
    private String telWorkshop;
    private String contactPersonWorkshop;
    private String visitContactPerson;
    private String howDamageDeald;
    private String particularities;
    private String plausibility;
    private int mDegradation;
    private int kDegradation;
    private int lDegradation;
    private String damageDescription;
    private String comments;

    public Auftrag(){

    }

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

    public UUID getKundenUUID() {
        return kundenUUID;
    }

    public void setKundenUUID(UUID kundenUUID) {
        this.kundenUUID = kundenUUID;
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

    public UUID getFahrzeugUUID() {
        return fahrzeugUUID;
    }

    public void setFahrzeugUUID(UUID fahrzeugUUID) {
        this.fahrzeugUUID = fahrzeugUUID;
    }

    public String getFahrzeugLicense() {
        return fahrzeugLicense;
    }

    public void setFahrzeugLicense(String fahrzeugLicense) {
        this.fahrzeugLicense = fahrzeugLicense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(String accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getAccidentPlace() {
        return accidentPlace;
    }

    public void setAccidentPlace(String accidentPlace) {
        this.accidentPlace = accidentPlace;
    }

    public String getDamageNumber() {
        return damageNumber;
    }

    public void setDamageNumber(String damageNumber) {
        this.damageNumber = damageNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getLicensePlateEnemy() {
        return licensePlateEnemy;
    }

    public void setLicensePlateEnemy(String licensePlateEnemy) {
        this.licensePlateEnemy = licensePlateEnemy;
    }

    public String getEmailWorkshop() {
        return emailWorkshop;
    }

    public void setEmailWorkshop(String emailWorkshop) {
        this.emailWorkshop = emailWorkshop;
    }

    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }

    public String getVisitTimePlace() {
        return visitTimePlace;
    }

    public void setVisitTimePlace(String visitTimePlace) {
        this.visitTimePlace = visitTimePlace;
    }

    public String getTelWorkshop() {
        return telWorkshop;
    }

    public void setTelWorkshop(String telWorkshop) {
        this.telWorkshop = telWorkshop;
    }

    public String getContactPersonWorkshop() {
        return contactPersonWorkshop;
    }

    public void setContactPersonWorkshop(String contactPersonWorkshop) {
        this.contactPersonWorkshop = contactPersonWorkshop;
    }

    public String getVisitContactPerson() {
        return visitContactPerson;
    }

    public void setVisitContactPerson(String visitContactPerson) {
        this.visitContactPerson = visitContactPerson;
    }

    public String getHowDamageDeald() {
        return howDamageDeald;
    }

    public void setHowDamageDeald(String howDamageDeald) {
        this.howDamageDeald = howDamageDeald;
    }

    public String getParticularities() {
        return particularities;
    }

    public void setParticularities(String particularities) {
        this.particularities = particularities;
    }

    public String getPlausibility() {
        return plausibility;
    }

    public void setPlausibility(String plausibility) {
        this.plausibility = plausibility;
    }

    public int getmDegradation() {
        return mDegradation;
    }

    public void setmDegradation(int mDegradation) {
        this.mDegradation = mDegradation;
    }

    public int getkDegradation() {
        return kDegradation;
    }

    public void setkDegradation(int kDegradation) {
        this.kDegradation = kDegradation;
    }

    public int getlDegradation() {
        return lDegradation;
    }

    public void setlDegradation(int lDegradation) {
        this.lDegradation = lDegradation;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
