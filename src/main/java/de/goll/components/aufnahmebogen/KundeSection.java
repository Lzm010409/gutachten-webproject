package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import de.goll.data.entity.Fahrzeug;
import de.goll.data.entity.Kunde;

public class KundeSection extends FormLayout {
    private ComboBox<String> gender = new ComboBox<>("Anrede");
    private TextField name = new TextField("Name");
    private TextField street = new TextField("Straße");
    private TextField zip = new TextField("Postleitzahl");
    private TextField city = new TextField("Stadt");
    private TextField tel = new TextField("Telefonnummer");
    private EmailField mail = new EmailField("E-Mail");
    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");

    Binder <Kunde> kundeBinder = new BeanValidationBinder<>(Kunde.class);

    private Kunde kunde;

    public KundeSection() {
        H2 header = new H2("Kundendetails");
        kundeBinder.bindInstanceFields(this);
        addClassName("kunde-section");
        add(header, createButtonLayout(),
                gender,
                name,
                street,
                zip,
                city,
                tel,
                mail
        );
    }

    public Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        save.addClickListener(buttonClickEvent -> validateAndSaveKunde());
        kundeBinder.addStatusChangeListener(e -> save.setEnabled(kundeBinder.isValid()));

        return horizontalLayout;
    }

    public static abstract class KundeSectionEvent extends ComponentEvent<KundeSection> {
        private Kunde kunde;

        protected KundeSectionEvent(KundeSection source, Kunde kunde) {
            super(source, false);
            this.kunde = kunde;
        }

        public Kunde getKunde() {
            return kunde;
        }
    }

    public static class SaveKundeEvent extends KundeSectionEvent {
        SaveKundeEvent(KundeSection source, Kunde kunde) {
            super(source, kunde);
        }
    }


    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

    public void validateAndSaveKunde() {
        try {
            kundeBinder.writeBean(kunde);
            fireEvent(new SaveKundeEvent(this, kunde));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
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

    public Binder<Kunde> getKundeBinder() {
        return kundeBinder;
    }

    public void setKundeBinder(Binder<Kunde> kundeBinder) {
        this.kundeBinder = kundeBinder;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public ComboBox<String> getGender() {
        return gender;
    }

    public void setGender(ComboBox<String> gender) {
        this.gender = gender;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getStreet() {
        return street;
    }

    public void setStreet(TextField street) {
        this.street = street;
    }

    public TextField getZip() {
        return zip;
    }

    public void setZip(TextField zip) {
        this.zip = zip;
    }

    public TextField getCity() {
        return city;
    }

    public void setCity(TextField city) {
        this.city = city;
    }

    public TextField getTel() {
        return tel;
    }

    public void setTel(TextField tel) {
        this.tel = tel;
    }

    public EmailField getMail() {
        return mail;
    }

    public void setMail(EmailField mail) {
        this.mail = mail;
    }


}
