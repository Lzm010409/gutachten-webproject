package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Fahrzeug;
import de.goll.data.entity.Kunde;

public class AuftragsSection extends FormLayout {

    private DatePicker auftragsDatum = new DatePicker("Auftragsdatum");
    private DatePicker schadenDatum = new DatePicker("Schadendatum");
    private TextField schadenOrt = new TextField("Schadenort");
    private TextField gutachtenNummer = new TextField("Gutachtennummer");
    private TextField schadennummer = new TextField("VU/Schadennummer");
    private TextField kennzeichenUG = new TextField("Kennezeichen-UG");
    private TextArea damageCourse = new TextArea("Schadenhergang");
    private RadioButtonGroup<String> damageCourseStatement = new RadioButtonGroup<>("Schadenhergang laut");
    private RadioButtonGroup<String> damagePlausibility = new RadioButtonGroup<>("Schadenhergang plausibel");
    private TextArea particularities = new TextArea("Auftragsbesonderheiten");
    private TextField mField = new TextField("M - Wertminderung");
    private TextField kField = new TextField("K - Wertminderung");
    private TextField lField = new TextField("L - Wertminderung");
    private TextArea damageDescription = new TextArea("Schadenbeschreibung");
    private TextField replacementValue = new TextField("Wiederbeschaffungswert");
    private TextField repairDuration = new TextField("Reparaturdauer");
    private RadioButtonGroup<String> vehicleSave = new RadioButtonGroup<>("Verkehrssicher");
    private RadioButtonGroup<String> replacementValueEvaluation = new RadioButtonGroup<>("Wiederbeschaffungswert Ermittlungsmethode");
    private TextField replacementDuration = new TextField("Wiederbeschaffungsdauer");
    private ComboBox<String> lossOfUseGroup = new ComboBox<>("Nutzungsausfall-Gruppe");
    private TextField rentalClass = new TextField("Mietwagenklasse");
    private TextArea comments = new TextArea("Kommentare");
    private RadioButtonGroup<String> empty = new RadioButtonGroup();

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
    private VerticalLayout notFixed = new VerticalLayout();
    private VerticalLayout fixed = new VerticalLayout();

    private RadioButtonGroup<String> gender = new RadioButtonGroup<>("Anrede");
    private TextField nameKunde = new TextField("Name");
    private TextField streetKunde = new TextField("Straße");
    private TextField zipKunde = new TextField("Postleitzahl");
    private TextField cityKunde = new TextField("Stadt");
    private TextField telKunde = new TextField("Telefonnummer");
    private EmailField mailKunde = new EmailField("E-Mail");
    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");


    // Binder<Fahrzeug> fahrzeugBinder = new BeanValidationBinder<>(Fahrzeug.class);
    Binder<Auftrag> auftragBinder = new BeanValidationBinder<>(Auftrag.class);
    // Binder<Kunde> kundeBinder = new BeanValidationBinder<>(Kunde.class);

    private Auftrag auftrag = new Auftrag();


    public AuftragsSection() {
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
        auftragBinder.bindInstanceFields(this);
        /*fahrzeugBinder.bindInstanceFields(this);
        kundeBinder.bindInstanceFields(this);*/


    }

    public Component createKundenSection() {
        H2 header = new H2("Kundendetails");
        configureGender();
        FormLayout formLayout = new FormLayout();
        formLayout.add(gender,
                nameKunde,
                streetKunde,
                zipKunde,
                cityKunde,
                telKunde,
                mailKunde);
        VerticalLayout verticalLayout = new VerticalLayout(header, formLayout);
        addClassName("kunde-section");
        return verticalLayout;
    }

    public Component createFahrzeugSection() {
        addClassName("fahrzeug-section");
        H2 header = new H2("Fahrzeugdetails");
        FormLayout formLayout = new FormLayout();
        formLayout.add(header, /*emailWorkShop,
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

        VerticalLayout verticalLayout = new VerticalLayout(header, formLayout);
        return verticalLayout;
    }

    public Component createAuftragsDetails() {
        addClassName("auftragsdetails-section");
        H2 header = new H2("Auftragsdetails");
        FormLayout formLayout = new FormLayout();
        formLayout.add(header,
                auftragsDatum,
                schadenDatum,
                schadenOrt,
                gutachtenNummer,
                schadennummer,
                kennzeichenUG);
        VerticalLayout verticalLayout = new VerticalLayout(header, formLayout);

        return verticalLayout;
    }

    public Component createSchadenDetails() {
        addClassName("schadendetails-section");
        configureDamagePlausibility();
        configureSave();
        configureImpairment();
        configureTextAreas();
        configureDamageCourseStatement();
        configureReplacementValueEvaluation();
        H2 header = new H2("Schadendetails");
        FormLayout formLayout = new FormLayout();
        formLayout.add(header,
                damageCourse,
                particularities,
                damageCourseStatement,
                empty,
                damagePlausibility,
                configureImpairment(),
                damageDescription,
                replacementValue,
                repairDuration,
                replacementValueEvaluation,
                replacementDuration,
                lossOfUseGroup,
                rentalClass,
                empty,
                comments
        );
        VerticalLayout verticalLayout = new VerticalLayout(header, formLayout);

        return verticalLayout;
    }


    private Component configureImpairment() {
        Div euroSuffix = new Div();
        euroSuffix.setText("€");

        mField.setSuffixComponent(euroSuffix);
        kField.setSuffixComponent(euroSuffix);
        lField.setSuffixComponent(euroSuffix);
        mField.setSizeFull();
        kField.setSizeFull();
        lField.setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout(mField, kField, lField);
        verticalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        return verticalLayout;
    }


    public static abstract class AuftragsSectionEvent extends ComponentEvent<AuftragsSection> {
        private Auftrag auftrag;

        protected AuftragsSectionEvent(AuftragsSection source, Auftrag auftrag) {
            super(source, false);
            this.auftrag = auftrag;
        }

        public Auftrag getAuftrag() {
            return auftrag;
        }
    }

    public static class SaveAuftragEvent extends AuftragsSectionEvent {
        SaveAuftragEvent(AuftragsSection source, Auftrag auftrag) {
            super(source, auftrag);
        }
    }


    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

    public void validateAndSaveAuftrag() {
        try {
            auftragBinder.writeBean(auftrag);
            fireEvent(new SaveAuftragEvent(this, auftrag));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    private void configureVehcilePapers() {
        vehiclePapers.setItems("Original", "Kopie", "Auftrag", "Keine");
        vehiclePapers.setValue("Original");
    }

    private void configureGender() {
        gender.setItems("Frau", "Herr", "Divers", "Nicht angegeben");
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
        generalCondition.setItems(1.0, 2.0, 3.0, 4.0, 5.0);
        generalCondition.setValue(2.0);
    }

    private void configureBodyCondition() {
        bodyCondition.setItems(1.0, 2.0, 3.0, 4.0, 5.0);
        bodyCondition.setValue(2.0);
    }

    private void configureColorCondition() {
        colorCondition.setItems(1.0, 2.0, 3.0, 4.0, 5.0);
        colorCondition.setValue(2.0);
    }

    private void configureVisitCondition() {
        visitCondition.setItems(1.0, 2.0, 3.0, 4.0, 5.0);
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

    public Binder<Auftrag> getAuftragsdetailsBinder() {
        return auftragBinder;
    }

    public void setAuftragsdetailsBinder(Binder<Auftrag> auftragsdetailsBinder) {
        this.auftragBinder = auftragsdetailsBinder;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

    public DatePicker getAuftragsDatum() {
        return auftragsDatum;
    }

    public void setAuftragsDatum(DatePicker auftragsDatum) {
        this.auftragsDatum = auftragsDatum;
    }

    public DatePicker getSchadenDatum() {
        return schadenDatum;
    }

    public void setSchadenDatum(DatePicker schadenDatum) {
        this.schadenDatum = schadenDatum;
    }

    public TextField getSchadenOrt() {
        return schadenOrt;
    }

    public void setSchadenOrt(TextField schadenOrt) {
        this.schadenOrt = schadenOrt;
    }

    public TextField getGutachtenNummer() {
        return gutachtenNummer;
    }

    public void setGutachtenNummer(TextField gutachtenNummer) {
        this.gutachtenNummer = gutachtenNummer;
    }

    public TextField getSchadennummer() {
        return schadennummer;
    }

    public void setSchadennummer(TextField schadennummer) {
        this.schadennummer = schadennummer;
    }

    public TextField getKennzeichenUG() {
        return kennzeichenUG;
    }

    public void setKennzeichenUG(TextField kennzeichenUG) {
        this.kennzeichenUG = kennzeichenUG;
    }


    private void configureDamageCourseStatement() {
        damageCourseStatement.setItems("VN", "AS", "Werkstatt", "Eigene Aussage");
        damageCourseStatement.setValue("AS");
    }

    private void configureDamagePlausibility() {
        damagePlausibility.setItems("Plausibel", "Fraglich", "Nicht gegeben");
        damagePlausibility.setValue("Plausibel");
    }

    private void configureSave() {
        vehicleSave.setItems("Gegeben", "Nicht gegeben");
        vehicleSave.setValue("gegeben");
    }

    private void configureReplacementValueEvaluation() {
        replacementValueEvaluation.setItems("Differenz", "Regel", "Neutral", "Überdurchschnittlich ermittelt", "Ausreichend");
        replacementValueEvaluation.setValue("gegeben");
    }

    private void configureTextAreas() {
        damageDescription.setHeight("250px");
        damageCourse.setHeight("250px");
        particularities.setHeight("250px");
        comments.setHeight("250px");
        fixedDamages.setHeight("300px");
        notFixedDamages.setHeight("300px");
    }

    public TextArea getDamageCourse() {
        return damageCourse;
    }

    public void setDamageCourse(TextArea damageCourse) {
        this.damageCourse = damageCourse;
    }

    public RadioButtonGroup<String> getDamageCourseStatement() {
        return damageCourseStatement;
    }

    public void setDamageCourseStatement(RadioButtonGroup<String> damageCourseStatement) {
        this.damageCourseStatement = damageCourseStatement;
    }

    public RadioButtonGroup<String> getDamagePlausibility() {
        return damagePlausibility;
    }

    public void setDamagePlausibility(RadioButtonGroup<String> damagePlausibility) {
        this.damagePlausibility = damagePlausibility;
    }

    public TextArea getParticularities() {
        return particularities;
    }

    public void setParticularities(TextArea particularities) {
        this.particularities = particularities;
    }

    public TextField getmField() {
        return mField;
    }

    public void setmField(TextField mField) {
        this.mField = mField;
    }

    public TextField getkField() {
        return kField;
    }

    public void setkField(TextField kField) {
        this.kField = kField;
    }

    public TextField getlField() {
        return lField;
    }

    public void setlField(TextField lField) {
        this.lField = lField;
    }

    public TextArea getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(TextArea damageDescription) {
        this.damageDescription = damageDescription;
    }

    public TextField getReplacementValue() {
        return replacementValue;
    }

    public void setReplacementValue(TextField replacementValue) {
        this.replacementValue = replacementValue;
    }

    public TextField getRepairDuration() {
        return repairDuration;
    }

    public void setRepairDuration(TextField repairDuration) {
        this.repairDuration = repairDuration;
    }

    public RadioButtonGroup<String> getVehicleSave() {
        return vehicleSave;
    }

    public void setVehicleSave(RadioButtonGroup<String> vehicleSave) {
        this.vehicleSave = vehicleSave;
    }

    public RadioButtonGroup<String> getReplacementValueEvaluation() {
        return replacementValueEvaluation;
    }

    public void setReplacementValueEvaluation(RadioButtonGroup<String> replacementValueEvaluation) {
        this.replacementValueEvaluation = replacementValueEvaluation;
    }

    public TextField getReplacementDuration() {
        return replacementDuration;
    }

    public void setReplacementDuration(TextField replacementDuration) {
        this.replacementDuration = replacementDuration;
    }

    public ComboBox<String> getLossOfUseGroup() {
        return lossOfUseGroup;
    }

    public void setLossOfUseGroup(ComboBox<String> lossOfUseGroup) {
        this.lossOfUseGroup = lossOfUseGroup;
    }

    public TextField getRentalClass() {
        return rentalClass;
    }

    public void setRentalClass(TextField rentalClass) {
        this.rentalClass = rentalClass;
    }

    public TextArea getComments() {
        return comments;
    }

    public void setComments(TextArea comments) {
        this.comments = comments;
    }

    public RadioButtonGroup<String> getEmpty() {
        return empty;
    }

    public void setEmpty(RadioButtonGroup<String> empty) {
        this.empty = empty;
    }


}
