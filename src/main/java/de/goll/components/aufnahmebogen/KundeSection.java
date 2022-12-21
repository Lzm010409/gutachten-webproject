package de.goll.components.aufnahmebogen;

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
import de.goll.data.entity.Kunde;

public class KundeSection extends FormLayout {
    private ComboBox<String> gender = new ComboBox<>("Anrede");
    private TextField name = new TextField("Name");
    private TextField street = new TextField("Straße");
    private TextField zip = new TextField("Postleitzahl");
    private TextField city = new TextField("Stadt");
    private TextField tel = new TextField("Telefonnummer");
    private EmailField mail = new EmailField("E-Mail");

    public KundeSection() {
        Button save = new Button("Sichern");
        Button delete = new Button("Löschen");
        Button cancel = new Button("Abbrechen");
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        H2 header = new H2("Kundendetails");
        addClassName("kunde-section");
        add(header, horizontalLayout,
                gender,
                name,
                street,
                zip,
                city,
                tel,
                mail
        );
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
