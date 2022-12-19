package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

import java.awt.*;

public class FahrzeugSection extends FormLayout {

    private TextField visitPlace = new TextField("Besichtigungsort");
    private DateTimePicker visitDate = new DateTimePicker("Besichtigungsdatum & Uhrzeit");
    private EmailField emailWorkShop = new EmailField("E-Mail - Werkstatt");
    private TextField telWorkShop = new TextField("Telefon - Werkstatt");
    private TextField workShopContactPerson = new TextField("Ansprechpartner - Werkstatt");
    private TextField visitContactPerson = new TextField("Anwesend bei Besichtigung");
    private TextField licensePlate = new TextField("Kennzeichen");
    private TextField vehicleKind = new TextField("Fahrzeug-Art");
    private TextField vehicleManufactur = new TextField("Hersteller");
    private TextField vehicleType = new TextField("Fahrzeug-Typ");
    private TextField hsntsn = new TextField("HSN/TSN");
    private RadioButtonGroup<String> vehiclePapers = new RadioButtonGroup("Papiere");
    private TextField fin = new TextField("FIN");
    private TextField vehicleFirstAdmission = new TextField("erste Zulassung");
    private TextField vehicleLastAdmission = new TextField("letzte Zulassung");
    private TextField power = new TextField("Leistung in Kw");
    private TextField displacement = new TextField("Hubraum");
    private TextField hu = new TextField("HU");
    private TextField sp = new TextField("SP");
    private TextField preOwner = new TextField("Anzahl der Vorbesitzer");
    private TextField mileage = new TextField("Laufleistung in Km");
    private RadioButtonGroup<String> mileageReadType = new RadioButtonGroup("Wie wurde die Laufleistung erfasst");
    private RadioButtonGroup<String> vehicleColor = new RadioButtonGroup("Fahrzeug Farbe");
    private TextField frontTire = new TextField("Vorderreifen");
    private TextField rearTire = new TextField("Hinterreifen");
    private TextField tireManufacture = new TextField("Reifen Hersteller");
    private TextField tireDepth = new TextField("Profiltiefe");
    private RadioButtonGroup<String> driveType = new RadioButtonGroup("Antriebsart");
    private RadioButtonGroup<String> enviromentalBadge = new RadioButtonGroup("Umweltplakette");
    private RadioButtonGroup<String> fuel = new RadioButtonGroup("Treibstoff");
    private TextField pollutantClass = new TextField("Schadstoffklasse");
    private RadioButtonGroup<String> generalCondition = new RadioButtonGroup("Allgemeinzustand");
    private RadioButtonGroup<String> bodyCondition = new RadioButtonGroup("Karosseriezustand");
    private RadioButtonGroup<String> colorCondition = new RadioButtonGroup("Lackzustand");
    private RadioButtonGroup<String> visitCondition = new RadioButtonGroup("Besichtigungszustand");
   /* private TextArea equipment = new TextArea("Ausstattung");
    private TextArea fixedDamages = new TextArea("Beh. Vorschäden");
    private RadioButtonGroup<String> fixedMinorDamages = new RadioButtonGroup<>();
    private TextArea notFixedDamages = new TextArea("Nicht beh. Vorschäden");
    private RadioButtonGroup<String> notFixedMinorDamages = new RadioButtonGroup<>();
    private RadioButtonGroup<String> colorThickness = new RadioButtonGroup<>();*/


    public FahrzeugSection() {
        addClassName("fahrzeug-section");
        configureVisitCondition();
        configureBodyCondition();
        configureDriveType();
        configureFuel();
        configureFuel();
        configureColorCondition();
        configureEnviromentalBadge();
        configureGeneralCondition();
        configureMileageReadType();
        configureVehcilePapers();
        configureVehicleColor();
        add(emailWorkShop,
                visitPlace,
                visitDate,

                telWorkShop,
                workShopContactPerson,
                visitContactPerson,
                licensePlate,
                mileage,
                vehicleKind,
                mileageReadType,
                vehicleManufactur,
                vehicleColor,
                vehicleType,
                frontTire,
                hsntsn,
                rearTire,
                vehiclePapers,
                tireManufacture,
                fin,
                tireDepth,
                vehicleFirstAdmission,
                driveType,
                vehicleLastAdmission,
                enviromentalBadge,
                power,
                fuel,
                displacement,
                pollutantClass,
                hu,
                generalCondition,
                sp,
                bodyCondition,
                preOwner,
                colorCondition,
                visitCondition
        );
    }


    private void configureVehcilePapers() {
        vehiclePapers.setItems("Original", "Kopie", "Auftrag", "Keine");
        vehiclePapers.setValue("Original");
    }

    private void configureVehicleColor() {
        vehicleColor.setItems("Uni", "Metallic", "Perl-Effekt", "Folie");
        vehicleColor.setValue("Uni");
    }

    private void configureMileageReadType() {
        mileageReadType.setItems("Original", "Kopie", "Auftrag", "Keine");
        mileageReadType.setValue("Original");
    }

    private void configureDriveType() {
        mileageReadType.setItems("2WD", "4WD");
        mileageReadType.setValue("2WD");
    }

    private void configureEnviromentalBadge() {
        enviromentalBadge.setItems("Keine", "Rot", "Gelb", "Grün");
        enviromentalBadge.setValue("Grün");
    }

    private void configureFuel() {
        fuel.setItems("Otto", "Diesel", "Elektrisch", "LPG", "CNG", "Hybrid");
        fuel.setValue("Otto");
    }

    private void configureGeneralCondition() {
        generalCondition.setItems("1", "2", "3", "4", "5");
        generalCondition.setValue("2");
    }

    private void configureBodyCondition() {
        bodyCondition.setItems("1", "2", "3", "4", "5");
        bodyCondition.setValue("2");
    }

    private void configureColorCondition() {
        colorCondition.setItems("1", "2", "3", "4", "5");
        colorCondition.setValue("2");
    }

    private void configureVisitCondition() {
        visitCondition.setItems("1", "2", "3", "4", "5");
        visitCondition.setValue("2");
    }

    private void configureNotFixedMinorDamages() {
        visitCondition.setItems("Gebrauchsspuren", "Hagel", "Keine");
    }

    private void configureFixedMinorDamages() {
        visitCondition.setItems("keine festgestellt", "Hagel", "lt. Angabe", "festgestellt");
    }

    private void configureColorThickness() {
        visitCondition.setItems("Ja", "Nein");
        visitCondition.setValue("Nein");
    }

  /*  private Component createVehicleDamageSection() {
        HorizontalLayout horizontalLayout;
        VerticalLayout fixed = new VerticalLayout(fixedMinorDamages, colorThickness);
        horizontalLayout = new HorizontalLayout(notFixedMinorDamages, fixed);
        return horizontalLayout;
    }*/

}

