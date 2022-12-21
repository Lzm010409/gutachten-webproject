package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Rechtsanwalt;

public class HeadSection extends FormLayout {

    DatePicker auftragsDatum = new DatePicker("Auftragsdatum");
    DatePicker schadenDatum = new DatePicker("Schadendatum");
    TextField schadenOrt = new TextField("Schadenort");
    TextField gutachtenNummer = new TextField("Gutachtennummer");
    TextField schadennummer = new TextField("VU/Schadennummer");
    TextField kennzeichenUG = new TextField("Kennezeichen-UG");
    ComboBox<Rechtsanwalt> rechtsanwaltComboBox = new ComboBox<>("Rechtsanwalt");


    public HeadSection() {
        Button save = new Button("Sichern");
        Button delete = new Button("Löschen");
        Button cancel = new Button("Abbrechen");
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        H2 header = new H2("Auftragsdetails");


        addClassName("head-section");
        add(    header,
                horizontalLayout,
                auftragsDatum,
                schadenDatum,
                schadenOrt,
                gutachtenNummer,
                schadennummer,
                kennzeichenUG,
                rechtsanwaltComboBox
        );
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

    public ComboBox<Rechtsanwalt> getRechtsanwaltComboBox() {
        return rechtsanwaltComboBox;
    }

    public void setRechtsanwaltComboBox(ComboBox<Rechtsanwalt> rechtsanwaltComboBox) {
        this.rechtsanwaltComboBox = rechtsanwaltComboBox;
    }


}
