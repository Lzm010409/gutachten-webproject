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

}
