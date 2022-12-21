package de.goll.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "application_fahrzeug")
public class Fahrzeug extends AbstractEntity {

    private String licensePlate;

    private String mileage;
    private String vehicleArt;
    private String manufacturer;
    private String frontTire;
    private String hsntsn;
    private String rearTire;
    private String tireManufaturer;
    private String fin;
    private String firstAdmission;
    private String lastAdmission;
    private String driveType;
    private String pollutionBadge;
    private String power;
    private String fuel;
    private String pollutionClass;
    private String displacement;
    private String nextHU;
    private String nextSP;
    private double generalCount;
    private double bodyCount;
    private String preOwner;
    private double colorCount;
    private double visitCount;
    private String equipment;
    private String notFixedDamages;
    private String fixedDamages;

    public Fahrzeug() {
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

    public String getVehicleArt() {
        return vehicleArt;
    }

    public void setVehicleArt(String vehicleArt) {
        this.vehicleArt = vehicleArt;
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

    public String getPollutionBadge() {
        return pollutionBadge;
    }

    public void setPollutionBadge(String pollutionBadge) {
        this.pollutionBadge = pollutionBadge;
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

    public String getPollutionClass() {
        return pollutionClass;
    }

    public void setPollutionClass(String pollutionClass) {
        this.pollutionClass = pollutionClass;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getNextHU() {
        return nextHU;
    }

    public void setNextHU(String nextHU) {
        this.nextHU = nextHU;
    }

    public String getNextSP() {
        return nextSP;
    }

    public void setNextSP(String nextSP) {
        this.nextSP = nextSP;
    }

    public double getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(double generalCount) {
        this.generalCount = generalCount;
    }

    public double getBodyCount() {
        return bodyCount;
    }

    public void setBodyCount(double bodyCount) {
        this.bodyCount = bodyCount;
    }

    public String getPreOwner() {
        return preOwner;
    }

    public void setPreOwner(String preOwner) {
        this.preOwner = preOwner;
    }

    public double getColorCount() {
        return colorCount;
    }

    public void setColorCount(double colorCount) {
        this.colorCount = colorCount;
    }

    public double getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(double visitCount) {
        this.visitCount = visitCount;
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
}
