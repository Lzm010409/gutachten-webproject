package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class KundeSection extends FormLayout {
    private ComboBox<String> gender = new ComboBox<>("Anrede");
    private TextField name= new TextField("Name");
    private TextField street= new TextField("Straße");
    private TextField zip= new TextField("Postleitzahl");
    private TextField city= new TextField("Stadt");
    private TextField tel= new TextField("Telefonnummer");
    private EmailField mail= new EmailField("E-Mail");

    public KundeSection(){
        addClassName("kunde-section");
        add(
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
