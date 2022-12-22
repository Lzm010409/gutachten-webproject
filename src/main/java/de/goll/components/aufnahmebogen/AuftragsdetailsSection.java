package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import de.goll.data.entity.Auftragsdetails;
import de.goll.data.entity.Rechtsanwalt;

public class AuftragsdetailsSection extends FormLayout {

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
    private NumberField mField = new NumberField("M - Wertminderung");
    private NumberField kField = new NumberField("K - Wertminderung");
    private NumberField lField = new NumberField("L - Wertminderung");
    private TextArea damageDescription = new TextArea("Schadenbeschreibung");
    private NumberField replacementValue = new NumberField("Wiederbeschaffungswert");
    private NumberField repairDuration = new NumberField("Reparaturdauer");
    private RadioButtonGroup<String> vehicleSave = new RadioButtonGroup<>("Verkehrssicher");
    private RadioButtonGroup<String> replacementValueEvaluation = new RadioButtonGroup<>("Wiederbeschaffungswert Ermittlungsmethode");
    private NumberField replacementDuration = new NumberField("Wiederbeschaffungsdauer");
    private ComboBox<String> lossOfUseGroup = new ComboBox<>("Nutzungsausfall-Gruppe");
    private TextField rentalClass = new TextField("Mietwagenklasse");
    private TextArea comments = new TextArea("Kommentare");
    private RadioButtonGroup<String> empty = new RadioButtonGroup();
    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");

    Binder<Auftragsdetails> auftragsdetailsBinder = new BeanValidationBinder<>(Auftragsdetails.class);
    Auftragsdetails auftragsdetails;

    public AuftragsdetailsSection() {
        auftragsdetailsBinder.bindInstanceFields(this);
        H2 header = new H2("Auftragsdetails");


        addClassName("head-section");
        add(header,
                createButtonLayout(),
                auftragsDatum,
                schadenDatum,
                schadenOrt,
                gutachtenNummer,
                schadennummer,
                kennzeichenUG
        );
    }

    public Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        save.addClickListener(buttonClickEvent -> validateAndSaveAuftrag());
        auftragsdetailsBinder.addStatusChangeListener(e -> save.setEnabled(auftragsdetailsBinder.isValid()));

        return horizontalLayout;
    }

    public FormLayout createSchadenDetails() {
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

        return formLayout;
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


    public static abstract class AuftragsdetailsSectionEvent extends ComponentEvent<AuftragsdetailsSection> {
        private Auftragsdetails auftrag;

        protected AuftragsdetailsSectionEvent(AuftragsdetailsSection source, Auftragsdetails auftrag) {
            super(source, false);
            this.auftrag = auftrag;
        }

        public Auftragsdetails getAuftragsdetails() {
            return auftrag;
        }
    }

    public static class SaveAuftragdetailsEvent extends AuftragsdetailsSectionEvent {
        SaveAuftragdetailsEvent(AuftragsdetailsSection source, Auftragsdetails auftrag) {
            super(source, auftrag);
        }
    }


    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

    public void validateAndSaveAuftrag() {
        try {
            auftragsdetailsBinder.writeBean(auftragsdetails);
            fireEvent(new SaveAuftragdetailsEvent(this, auftragsdetails));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
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

    public NumberField getmField() {
        return mField;
    }

    public void setmField(NumberField mField) {
        this.mField = mField;
    }

    public NumberField getkField() {
        return kField;
    }

    public void setkField(NumberField kField) {
        this.kField = kField;
    }

    public NumberField getlField() {
        return lField;
    }

    public void setlField(NumberField lField) {
        this.lField = lField;
    }

    public TextArea getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(TextArea damageDescription) {
        this.damageDescription = damageDescription;
    }

    public NumberField getReplacementValue() {
        return replacementValue;
    }

    public void setReplacementValue(NumberField replacementValue) {
        this.replacementValue = replacementValue;
    }

    public NumberField getRepairDuration() {
        return repairDuration;
    }

    public void setRepairDuration(NumberField repairDuration) {
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

    public NumberField getReplacementDuration() {
        return replacementDuration;
    }

    public void setReplacementDuration(NumberField replacementDuration) {
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
