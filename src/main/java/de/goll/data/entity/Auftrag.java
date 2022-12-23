package de.goll.data.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "auftrag")
public class Auftrag extends AbstractEntity {

    private String auftragsNummer;
    private LocalDate auftragsDatum;
    private LocalDate schadenDatum;
    private String schadenOrt;
    private String gutachtenNummer;
    private String schadennummer;
    private String kennzeichenUG;
    private String damageCourse;
    private String damageCourseStatement;
    private String damagePlausibility;
    private String particularities;
    private String mField;
    private String kField;
    private String lField;
    private String damageDescription;
    private String repairDuration;
    private String replacementValue;
    private String vehicleSave;
    private String replacementValueEvaluation;
    private String replacementDuration;
    private String lossOfUseGroup;
    private String rentalClass;
    private String comments;

    private String licensePlate;

    private String mileage;
    private String vehicleKind;
    private String vehicleType;
    private String vehiclePapers;
    private String manufacturer;
    private String frontTire;
    private String hsntsn;
    private String rearTire;
    private String tireManufaturer;
    private String tireDepth;
    private String fin;
    private String firstAdmission;
    private String lastAdmission;
    private String driveType;
    private String enviromentalBadge;
    private String power;
    private String fuel;
    private String pollutantClass;
    private String displacement;
    private String hu;
    private String sp;
    private String mileageReadType;
    private String vehicleColor;
    private double generalCondition;
    private double bodyCondition;
    private String preOwner;
    private double colorCondition;
    private double visitCondition;
    private String equipment;
    private String notFixedDamages;
    private String fixedDamages;
    private String fixedMinorDamages;
    private String notFixedMinorDamages;
    private String colorThickness;

    private String anredeKunde;
    @NotBlank
    private String nameKunde;

    @NotBlank
    private String streetKunde;

    @NotBlank
    private String zipKunde;

    @NotBlank
    private String cityKunde;


    private String emailKunde;


    private String telKunde;





    public String getAuftragsNummer() {
        return auftragsNummer;
    }

    public void setAuftragsNummer(String auftragsNummer) {
        this.auftragsNummer = auftragsNummer;
    }



    public LocalDate getAuftragsDatum() {
        return auftragsDatum;
    }

    public void setAuftragsDatum(LocalDate auftragsDatum) {
        this.auftragsDatum = auftragsDatum;
    }

    public LocalDate getSchadenDatum() {
        return schadenDatum;
    }

    public void setSchadenDatum(LocalDate schadenDatum) {
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

    public String getmField() {
        return mField;
    }

    public void setmField(String mField) {
        this.mField = mField;
    }

    public String getkField() {
        return kField;
    }

    public void setkField(String kField) {
        this.kField = kField;
    }

    public String getlField() {
        return lField;
    }

    public void setlField(String lField) {
        this.lField = lField;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public String getRepairDuration() {
        return repairDuration;
    }

    public void setRepairDuration(String repairDuration) {
        this.repairDuration = repairDuration;
    }

    public String getReplacementValue() {
        return replacementValue;
    }

    public void setReplacementValue(String replacementValue) {
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

    public String getReplacementDuration() {
        return replacementDuration;
    }

    public void setReplacementDuration(String replacementDuration) {
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
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVehicleKind() {
        return vehicleKind;
    }

    public void setVehicleKind(String vehicleKind) {
        this.vehicleKind = vehicleKind;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePapers() {
        return vehiclePapers;
    }

    public void setVehiclePapers(String vehiclePapers) {
        this.vehiclePapers = vehiclePapers;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFrontTire() {
        return frontTire;
    }

    public void setFrontTire(String frontTire) {
        this.frontTire = frontTire;
    }

    public String getHsntsn() {
        return hsntsn;
    }

    public void setHsntsn(String hsntsn) {
        this.hsntsn = hsntsn;
    }

    public String getRearTire() {
        return rearTire;
    }

    public void setRearTire(String rearTire) {
        this.rearTire = rearTire;
    }

    public String getTireManufaturer() {
        return tireManufaturer;
    }

    public void setTireManufaturer(String tireManufaturer) {
        this.tireManufaturer = tireManufaturer;
    }

    public String getTireDepth() {
        return tireDepth;
    }

    public void setTireDepth(String tireDepth) {
        this.tireDepth = tireDepth;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getFirstAdmission() {
        return firstAdmission;
    }

    public void setFirstAdmission(String firstAdmission) {
        this.firstAdmission = firstAdmission;
    }

    public String getLastAdmission() {
        return lastAdmission;
    }

    public void setLastAdmission(String lastAdmission) {
        this.lastAdmission = lastAdmission;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getEnviromentalBadge() {
        return enviromentalBadge;
    }

    public void setEnviromentalBadge(String enviromentalBadge) {
        this.enviromentalBadge = enviromentalBadge;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPollutantClass() {
        return pollutantClass;
    }

    public void setPollutantClass(String pollutantClass) {
        this.pollutantClass = pollutantClass;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getHu() {
        return hu;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getMileageReadType() {
        return mileageReadType;
    }

    public void setMileageReadType(String mileageReadType) {
        this.mileageReadType = mileageReadType;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public double getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(double generalCondition) {
        this.generalCondition = generalCondition;
    }

    public double getBodyCondition() {
        return bodyCondition;
    }

    public void setBodyCondition(double bodyCondition) {
        this.bodyCondition = bodyCondition;
    }

    public String getPreOwner() {
        return preOwner;
    }

    public void setPreOwner(String preOwner) {
        this.preOwner = preOwner;
    }

    public double getColorCondition() {
        return colorCondition;
    }

    public void setColorCondition(double colorCondition) {
        this.colorCondition = colorCondition;
    }

    public double getVisitCondition() {
        return visitCondition;
    }

    public void setVisitCondition(double visitCondition) {
        this.visitCondition = visitCondition;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getNotFixedDamages() {
        return notFixedDamages;
    }

    public void setNotFixedDamages(String notFixedDamages) {
        this.notFixedDamages = notFixedDamages;
    }

    public String getFixedDamages() {
        return fixedDamages;
    }

    public void setFixedDamages(String fixedDamages) {
        this.fixedDamages = fixedDamages;
    }

    public String getFixedMinorDamages() {
        return fixedMinorDamages;
    }

    public void setFixedMinorDamages(String fixedMinorDamages) {
        this.fixedMinorDamages = fixedMinorDamages;
    }

    public String getNotFixedMinorDamages() {
        return notFixedMinorDamages;
    }

    public void setNotFixedMinorDamages(String notFixedMinorDamages) {
        this.notFixedMinorDamages = notFixedMinorDamages;
    }

    public String getColorThickness() {
        return colorThickness;
    }

    public void setColorThickness(String colorThickness) {
        this.colorThickness = colorThickness;
    }

    public String getAnredeKunde() {
        return anredeKunde;
    }

    public void setAnredeKunde(String anredeKunde) {
        this.anredeKunde = anredeKunde;
    }

    public String getNameKunde() {
        return nameKunde;
    }

    public void setNameKunde(String nameKunde) {
        this.nameKunde = nameKunde;
    }

    public String getStreetKunde() {
        return streetKunde;
    }

    public void setStreetKunde(String streetKunde) {
        this.streetKunde = streetKunde;
    }

    public String getZipKunde() {
        return zipKunde;
    }

    public void setZipKunde(String zipKunde) {
        this.zipKunde = zipKunde;
    }

    public String getCityKunde() {
        return cityKunde;
    }

    public void setCityKunde(String cityKunde) {
        this.cityKunde = cityKunde;
    }

    public String getEmailKunde() {
        return emailKunde;
    }

    public void setEmailKunde(String emailKunde) {
        this.emailKunde = emailKunde;
    }

    public String getTelKunde() {
        return telKunde;
    }

    public void setTelKunde(String telKunde) {
        this.telKunde = telKunde;
    }

}
