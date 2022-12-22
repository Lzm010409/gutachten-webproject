package de.goll.data.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "application_auftragsdetails")
public class Auftragsdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuftragsdetailsUUID", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    private String auftragsDatum;
    private String schadenDatum;
    private String schadenOrt;
    private String gutachtenNummer;
    private String schadennummer;
    private String kennzeichenUG;
    private String damageCourse;
    private String damageCourseStatement;
    private String damagePlausibility;
    private String particularities;
    private double mField;
    private double kField;
    private double lField;
    private String damageDescription;
    private double repairDuration;
    private double replacementValue;
    private String vehicleSave;
    private String replacementValueEvaluation;
    private double replacementDuration;
    private String lossOfUseGroup;
    private String rentalClass;
    private String comments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuftragsDatum() {
        return auftragsDatum;
    }

    public void setAuftragsDatum(String auftragsDatum) {
        this.auftragsDatum = auftragsDatum;
    }

    public String getSchadenDatum() {
        return schadenDatum;
    }

    public void setSchadenDatum(String schadenDatum) {
        this.schadenDatum = schadenDatum;
    }

    public String getSchadenOrt() {
        return schadenOrt;
    }

    public void setSchadenOrt(String schadenOrt) {
        this.schadenOrt = schadenOrt;
    }

    public String getGutachtenNummer() {
        return gutachtenNummer;
    }

    public void setGutachtenNummer(String gutachtenNummer) {
        this.gutachtenNummer = gutachtenNummer;
    }

    public String getSchadennummer() {
        return schadennummer;
    }

    public void setSchadennummer(String schadennummer) {
        this.schadennummer = schadennummer;
    }

    public String getKennzeichenUG() {
        return kennzeichenUG;
    }

    public void setKennzeichenUG(String kennzeichenUG) {
        this.kennzeichenUG = kennzeichenUG;
    }

    public String getDamageCourse() {
        return damageCourse;
    }

    public void setDamageCourse(String damageCourse) {
        this.damageCourse = damageCourse;
    }

    public String getDamageCourseStatement() {
        return damageCourseStatement;
    }

    public void setDamageCourseStatement(String damageCourseStatement) {
        this.damageCourseStatement = damageCourseStatement;
    }

    public String getDamagePlausibility() {
        return damagePlausibility;
    }

    public void setDamagePlausibility(String damagePlausibility) {
        this.damagePlausibility = damagePlausibility;
    }

    public String getParticularities() {
        return particularities;
    }

    public void setParticularities(String particularities) {
        this.particularities = particularities;
    }

    public double getmField() {
        return mField;
    }

    public void setmField(double mField) {
        this.mField = mField;
    }

    public double getkField() {
        return kField;
    }

    public void setkField(double kField) {
        this.kField = kField;
    }

    public double getlField() {
        return lField;
    }

    public void setlField(double lField) {
        this.lField = lField;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public double getRepairDuration() {
        return repairDuration;
    }

    public void setRepairDuration(double repairDuration) {
        this.repairDuration = repairDuration;
    }

    public double getReplacementValue() {
        return replacementValue;
    }

    public void setReplacementValue(double replacementValue) {
        this.replacementValue = replacementValue;
    }

    public String getVehicleSave() {
        return vehicleSave;
    }

    public void setVehicleSave(String vehicleSave) {
        this.vehicleSave = vehicleSave;
    }

    public String getReplacementValueEvaluation() {
        return replacementValueEvaluation;
    }

    public void setReplacementValueEvaluation(String replacementValueEvaluation) {
        this.replacementValueEvaluation = replacementValueEvaluation;
    }

    public double getReplacementDuration() {
        return replacementDuration;
    }

    public void setReplacementDuration(double replacementDuration) {
        this.replacementDuration = replacementDuration;
    }

    public String getLossOfUseGroup() {
        return lossOfUseGroup;
    }

    public void setLossOfUseGroup(String lossOfUseGroup) {
        this.lossOfUseGroup = lossOfUseGroup;
    }

    public String getRentalClass() {
        return rentalClass;
    }

    public void setRentalClass(String rentalClass) {
        this.rentalClass = rentalClass;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
