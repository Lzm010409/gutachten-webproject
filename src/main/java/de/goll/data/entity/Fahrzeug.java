package de.goll.data.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "fahrzeug")
public class Fahrzeug extends AbstractEntity {


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Auftrag auftrag;
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


    public Fahrzeug() {
    }


    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
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

    public String getTireDepth() {
        return tireDepth;
    }

    public void setTireDepth(String tireDepth) {
        this.tireDepth = tireDepth;
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
}
