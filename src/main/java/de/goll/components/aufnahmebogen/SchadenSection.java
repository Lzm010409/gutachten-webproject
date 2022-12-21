package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
import de.goll.data.entity.Auftrag;

public class SchadenSection extends FormLayout {

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
    private RadioButtonGroup<String> save = new RadioButtonGroup<>("Verkehrssicher");
    private RadioButtonGroup<String> replacementValueEvaluation = new RadioButtonGroup<>("Wiederbeschaffungswert Ermittlungsmethode");
    private NumberField replacementDuration = new NumberField("Wiederbeschaffungsdauer");
    private ComboBox<String> lossOfUseGroup = new ComboBox<>("Nutzungsausfall-Gruppe");
    private TextField rentalClass = new TextField("Mietwagenklasse");
    private TextArea comments = new TextArea("Kommentare");
    private RadioButtonGroup<String> empty = new RadioButtonGroup();


    public SchadenSection() {
        Button save = new Button("Sichern");
        Button delete = new Button("Löschen");
        Button cancel = new Button("Abbrechen");
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        H2 header = new H2("Schadendetails");
        configureSave();
        configureDamagePlausibility();
        configureReplacementValueEvaluation();
        configureDamageCourseStatement();
        configureTextAreas();

        add(header, horizontalLayout,
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

    private void configureDamageCourseStatement() {
        damageCourseStatement.setItems("VN", "AS", "Werkstatt", "Eigene Aussage");
        damageCourseStatement.setValue("AS");
    }

    private void configureDamagePlausibility() {
        damagePlausibility.setItems("Plausibel", "Fraglich", "Nicht gegeben");
        damagePlausibility.setValue("Plausibel");
    }

    private void configureSave() {
        save.setItems("Gegeben", "Nicht gegeben");
        save.setValue("gegeben");
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

    public RadioButtonGroup<String> getSave() {
        return save;
    }

    public void setSave(RadioButtonGroup<String> save) {
        this.save = save;
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
