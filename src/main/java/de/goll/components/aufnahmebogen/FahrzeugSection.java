package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import de.goll.data.entity.Fahrzeug;
import de.goll.data.service.FahrzeugService;


public class FahrzeugSection extends FormLayout {

    /*private TextField visitPlace = new TextField("Besichtigungsort");
    private DateTimePicker visitDate = new DateTimePicker("Besichtigungsdatum & Uhrzeit");
    private EmailField emailWorkShop = new EmailField("E-Mail - Werkstatt");
    private TextField telWorkShop = new TextField("Telefon - Werkstatt");
    private TextField workShopContactPerson = new TextField("Ansprechpartner - Werkstatt");
    private TextField visitContactPerson = new TextField("Anwesend bei Besichtigung");
    */
    private TextField licensePlate = new TextField("Kennzeichen");

    private TextField vehicleKind = new TextField("Fahrzeug-Art");
    private TextField manufacturer = new TextField("Hersteller");
    private TextField vehicleType = new TextField("Fahrzeug-Typ");
    private TextField hsntsn = new TextField("HSN/TSN");
    private RadioButtonGroup<String> vehiclePapers = new RadioButtonGroup("Papiere");
    private TextField fin = new TextField("FIN");
    private TextField firstAdmission = new TextField("erste Zulassung");
    private TextField lastAdmission = new TextField("letzte Zulassung");
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
    private TextField tireManufacturer = new TextField("Reifen Hersteller");
    private TextField tireDepth = new TextField("Profiltiefe");
    private RadioButtonGroup<String> driveType = new RadioButtonGroup("Antriebsart");
    private RadioButtonGroup<String> enviromentalBadge = new RadioButtonGroup("Umweltplakette");
    private RadioButtonGroup<String> fuel = new RadioButtonGroup("Treibstoff");
    private TextField pollutantClass = new TextField("Schadstoffklasse");
    private RadioButtonGroup<Double> generalCondition = new RadioButtonGroup("Allgemeinzustand");
    private RadioButtonGroup<Double> bodyCondition = new RadioButtonGroup("Karosseriezustand");
    private RadioButtonGroup<Double> colorCondition = new RadioButtonGroup("Lackzustand");
    private RadioButtonGroup<Double> visitCondition = new RadioButtonGroup("Besichtigungszustand");
    private TextArea equipment = new TextArea("Ausstattung");
    private TextArea fixedDamages = new TextArea("Beh. Vorschäden");
    private RadioButtonGroup<String> fixedMinorDamages = new RadioButtonGroup<>("Reparierte geringfügige Schäden");
    private TextArea notFixedDamages = new TextArea("Nicht beh. Vorschäden");
    private RadioButtonGroup<String> notFixedMinorDamages = new RadioButtonGroup<>("Nicht reparierte geringfügige Schäden");
    private RadioButtonGroup<String> colorThickness = new RadioButtonGroup<>("Lackschichtdickenmessung");
    private RadioButtonGroup<String> empty = new RadioButtonGroup();
    private VerticalLayout notFixed = new VerticalLayout();
    private VerticalLayout fixed = new VerticalLayout();

    private Fahrzeug fahrzeug = new Fahrzeug();
    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");


    Binder<Fahrzeug> fahrzeugBinder = new BeanValidationBinder<>(Fahrzeug.class);

    public FahrzeugSection() {
        H2 header = new H2("Fahrzeugdetails");
        fahrzeugBinder.bindInstanceFields(this);
        addClassName("fahrzeug-section");
        configureVisitCondition();
        configureBodyCondition();
        configureDriveType();
        configureFuel();
        configureColorCondition();
        configureEnviromentalBadge();
        configureGeneralCondition();
        configureMileageReadType();
        configureVehcilePapers();
        configureVehicleColor();
        configureFixedMinorDamages();
        configureNotFixedMinorDamages();
        configureColorThickness();
        configureTextAreas();
        add(header, createButtonLayout(), /*emailWorkShop,
                visitPlace,
                visitDate,
                telWorkShop,
                workShopContactPerson,
                visitContactPerson,*/
                licensePlate,
                mileage,
                vehicleKind,
                mileageReadType,
                manufacturer,
                vehicleColor,
                vehicleType,
                frontTire,
                hsntsn,
                rearTire,
                vehiclePapers,
                tireManufacturer,
                fin,
                tireDepth,
                firstAdmission,
                driveType,
                lastAdmission,
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
                visitCondition,
                equipment,
                notFixedDamages,
                fixedDamages,
                notFixedMinorDamages,
                fixedMinorDamages,
                colorThickness


        );
    }

    public Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        save.addClickListener(buttonClickEvent -> validateAndSaveFahrzeug());
        fahrzeugBinder.addStatusChangeListener(e -> save.setEnabled(fahrzeugBinder.isValid()));

        return horizontalLayout;
    }
    public static abstract class FahrzeugSectionEvent extends ComponentEvent<FahrzeugSection> {
        private Fahrzeug fahrzeug;

        protected FahrzeugSectionEvent(FahrzeugSection source, Fahrzeug fahrzeug) {
            super(source, false);
            this.fahrzeug = fahrzeug;
        }

        public Fahrzeug getFahrzeug() {
            return fahrzeug;
        }
    }

    public static class SaveFahrzeugEvent extends FahrzeugSectionEvent {
        SaveFahrzeugEvent(FahrzeugSection source, Fahrzeug fahrzeug) {
            super(source, fahrzeug);
        }
    }


    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

    public void validateAndSaveFahrzeug() {
        try {
            fahrzeugBinder.writeBean(fahrzeug);
            fireEvent(new SaveFahrzeugEvent(this, fahrzeug));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
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
        driveType.setItems("2WD", "4WD");
        driveType.setValue("2WD");
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
        generalCondition.setItems(1.0,2.0,3.0,4.0,5.0);
        generalCondition.setValue(2.0);
    }

    private void configureBodyCondition() {
        bodyCondition.setItems(1.0,2.0,3.0,4.0,5.0);
        bodyCondition.setValue(2.0);
    }

    private void configureColorCondition() {
        colorCondition.setItems(1.0,2.0,3.0,4.0,5.0);
        colorCondition.setValue(2.0);
    }

    private void configureVisitCondition() {
        visitCondition.setItems(1.0,2.0,3.0,4.0,5.0);
        visitCondition.setValue(2.0);
    }

    private void configureNotFixedMinorDamages() {
        notFixedMinorDamages.setItems("Gebrauchsspuren", "Hagel", "Keine");
    }

    private void configureFixedMinorDamages() {
        fixedMinorDamages.setItems("keine festgestellt", "Hagel", "lt. Angabe", "festgestellt");
    }

    private void configureColorThickness() {
        colorThickness.setItems("Ja", "Nein");
        colorThickness.setValue("Nein");
    }

    private void configureTextAreas() {
        fixedDamages.setHeight("300px");
        notFixedDamages.setHeight("300px");
    }

    /*public TextField getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(TextField visitPlace) {
        this.visitPlace = visitPlace;
    }

    public DateTimePicker getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(DateTimePicker visitDate) {
        this.visitDate = visitDate;
    }

    public EmailField getEmailWorkShop() {
        return emailWorkShop;
    }

    public void setEmailWorkShop(EmailField emailWorkShop) {
        this.emailWorkShop = emailWorkShop;
    }

    public TextField getTelWorkShop() {
        return telWorkShop;
    }

    public void setTelWorkShop(TextField telWorkShop) {
        this.telWorkShop = telWorkShop;
    }

    public TextField getWorkShopContactPerson() {
        return workShopContactPerson;
    }

    public void setWorkShopContactPerson(TextField workShopContactPerson) {
        this.workShopContactPerson = workShopContactPerson;
    }

    public TextField getVisitContactPerson() {
        return visitContactPerson;
    }

    public void setVisitContactPerson(TextField visitContactPerson) {
        this.visitContactPerson = visitContactPerson;
    }*/

    public TextField getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(TextField licensePlate) {
        this.licensePlate = licensePlate;
    }

    public TextField getVehicleKind() {
        return vehicleKind;
    }

    public void setVehicleKind(TextField vehicleKind) {
        this.vehicleKind = vehicleKind;
    }

    public TextField getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(TextField manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TextField getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(TextField vehicleType) {
        this.vehicleType = vehicleType;
    }

    public TextField getHsntsn() {
        return hsntsn;
    }

    public void setHsntsn(TextField hsntsn) {
        this.hsntsn = hsntsn;
    }

    public RadioButtonGroup<String> getVehiclePapers() {
        return vehiclePapers;
    }

    public void setVehiclePapers(RadioButtonGroup<String> vehiclePapers) {
        this.vehiclePapers = vehiclePapers;
    }

    public TextField getFin() {
        return fin;
    }

    public void setFin(TextField fin) {
        this.fin = fin;
    }

    public TextField getFirstAdmission() {
        return firstAdmission;
    }

    public void setFirstAdmission(TextField firstAdmission) {
        this.firstAdmission = firstAdmission;
    }

    public TextField getLastAdmission() {
        return lastAdmission;
    }

    public void setLastAdmission(TextField lastAdmission) {
        this.lastAdmission = lastAdmission;
    }

    public TextField getPower() {
        return power;
    }

    public void setPower(TextField power) {
        this.power = power;
    }

    public TextField getDisplacement() {
        return displacement;
    }

    public void setDisplacement(TextField displacement) {
        this.displacement = displacement;
    }

    public TextField getHu() {
        return hu;
    }

    public void setHu(TextField hu) {
        this.hu = hu;
    }

    public TextField getSp() {
        return sp;
    }

    public void setSp(TextField sp) {
        this.sp = sp;
    }

    public TextField getPreOwner() {
        return preOwner;
    }

    public void setPreOwner(TextField preOwner) {
        this.preOwner = preOwner;
    }

    public TextField getMileage() {
        return mileage;
    }

    public void setMileage(TextField mileage) {
        this.mileage = mileage;
    }

    public RadioButtonGroup<String> getMileageReadType() {
        return mileageReadType;
    }

    public void setMileageReadType(RadioButtonGroup<String> mileageReadType) {
        this.mileageReadType = mileageReadType;
    }

    public RadioButtonGroup<String> getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(RadioButtonGroup<String> vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public TextField getFrontTire() {
        return frontTire;
    }

    public void setFrontTire(TextField frontTire) {
        this.frontTire = frontTire;
    }

    public TextField getRearTire() {
        return rearTire;
    }

    public void setRearTire(TextField rearTire) {
        this.rearTire = rearTire;
    }

    public TextField getTireManufacturer() {
        return tireManufacturer;
    }

    public void setTireManufacturer(TextField tireManufacturer) {
        this.tireManufacturer = tireManufacturer;
    }

    public TextField getTireDepth() {
        return tireDepth;
    }

    public void setTireDepth(TextField tireDepth) {
        this.tireDepth = tireDepth;
    }

    public RadioButtonGroup<String> getDriveType() {
        return driveType;
    }

    public void setDriveType(RadioButtonGroup<String> driveType) {
        this.driveType = driveType;
    }

    public RadioButtonGroup<String> getEnviromentalBadge() {
        return enviromentalBadge;
    }

    public void setEnviromentalBadge(RadioButtonGroup<String> enviromentalBadge) {
        this.enviromentalBadge = enviromentalBadge;
    }

    public RadioButtonGroup<String> getFuel() {
        return fuel;
    }

    public void setFuel(RadioButtonGroup<String> fuel) {
        this.fuel = fuel;
    }

    public TextField getPollutantClass() {
        return pollutantClass;
    }

    public void setPollutantClass(TextField pollutantClass) {
        this.pollutantClass = pollutantClass;
    }

    public RadioButtonGroup<Double> getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(RadioButtonGroup<Double> generalCondition) {
        this.generalCondition = generalCondition;
    }

    public RadioButtonGroup<Double> getBodyCondition() {
        return bodyCondition;
    }

    public void setBodyCondition(RadioButtonGroup<Double> bodyCondition) {
        this.bodyCondition = bodyCondition;
    }

    public RadioButtonGroup<Double> getColorCondition() {
        return colorCondition;
    }

    public void setColorCondition(RadioButtonGroup<Double> colorCondition) {
        this.colorCondition = colorCondition;
    }

    public RadioButtonGroup<Double> getVisitCondition() {
        return visitCondition;
    }

    public void setVisitCondition(RadioButtonGroup<Double> visitCondition) {
        this.visitCondition = visitCondition;
    }

    public TextArea getEquipment() {
        return equipment;
    }

    public void setEquipment(TextArea equipment) {
        this.equipment = equipment;
    }

    public TextArea getFixedDamages() {
        return fixedDamages;
    }

    public void setFixedDamages(TextArea fixedDamages) {
        this.fixedDamages = fixedDamages;
    }

    public RadioButtonGroup<String> getFixedMinorDamages() {
        return fixedMinorDamages;
    }

    public void setFixedMinorDamages(RadioButtonGroup<String> fixedMinorDamages) {
        this.fixedMinorDamages = fixedMinorDamages;
    }

    public TextArea getNotFixedDamages() {
        return notFixedDamages;
    }

    public void setNotFixedDamages(TextArea notFixedDamages) {
        this.notFixedDamages = notFixedDamages;
    }

    public RadioButtonGroup<String> getNotFixedMinorDamages() {
        return notFixedMinorDamages;
    }

    public void setNotFixedMinorDamages(RadioButtonGroup<String> notFixedMinorDamages) {
        this.notFixedMinorDamages = notFixedMinorDamages;
    }

    public RadioButtonGroup<String> getColorThickness() {
        return colorThickness;
    }

    public void setColorThickness(RadioButtonGroup<String> colorThickness) {
        this.colorThickness = colorThickness;
    }

    public RadioButtonGroup<String> getEmpty() {
        return empty;
    }

    public void setEmpty(RadioButtonGroup<String> empty) {
        this.empty = empty;
    }

    public VerticalLayout getNotFixed() {
        return notFixed;
    }

    public void setNotFixed(VerticalLayout notFixed) {
        this.notFixed = notFixed;
    }

    public VerticalLayout getFixed() {
        return fixed;
    }

    public void setFixed(VerticalLayout fixed) {
        this.fixed = fixed;
    }


    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
        fahrzeugBinder.readBean(fahrzeug);
    }





    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public Binder<Fahrzeug> getFahrzeugBinder() {
        return fahrzeugBinder;
    }

    public void setFahrzeugBinder(Binder<Fahrzeug> fahrzeugBinder) {
        this.fahrzeugBinder = fahrzeugBinder;
    }

    public Button getSave() {
        return save;
    }

    public void setSave(Button save) {
        this.save = save;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }


}

