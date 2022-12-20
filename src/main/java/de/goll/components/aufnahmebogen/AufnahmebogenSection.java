package de.goll.components.aufnahmebogen;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Fahrzeug;
import de.goll.data.service.AuftragService;
import de.goll.data.service.FahrzeugService;
import de.goll.data.service.KundeService;
import de.goll.data.service.RechtsanwaltService;

public class AufnahmebogenSection {

    HeadSection headSection;
    KundeSection kundeSection;
    FahrzeugSection fahrzeugSection;
    SchadenSection schadenSection;

    AuftragService auftragService;
    KundeService kundeService;
    RechtsanwaltService rechtsanwaltService;
    FahrzeugService fahrzeugService;


    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");
    Binder<Auftrag> auftragBinder = new BeanValidationBinder<>(Auftrag.class);
    Binder<Fahrzeug> fahrzeugBinder = new BeanValidationBinder<>(Fahrzeug.class);


    public AufnahmebogenSection() {
       ??? auftragBinder.forField()
    }

    public Component createAufnahmebogenSection() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(horizontalLayout, createHeadSection(), createKundenSection(), createFahrzeugSection(), createSchadenSection());
        return verticalLayout;
    }

    private Component createHeadSection() {
        H2 header = new H2("Auftragsdetails");
        headSection = new HeadSection();
       /* Image image = new Image();
        image.setSrc("/Users/lukegollenstede/IdeaProjects/gutachten-webproject/src/main/resources/gollenstede-1.png");*/
        HorizontalLayout content = new HorizontalLayout(headSection);
       /* content.setFlexGrow(1, image);
        content.setFlexGrow(2, headSection);*/
        content.setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout(header, content);
        return verticalLayout;
        //TEST

    }

    private Component createKundenSection() {
        H2 header = new H2("Kundeninformationen");
        kundeSection = new KundeSection();
        VerticalLayout verticalLayout = new VerticalLayout(header, kundeSection);
        return verticalLayout;

    }

    private Component createFahrzeugSection() {
        H2 header = new H2("Fahrzeuginformationen");
        fahrzeugSection = new FahrzeugSection();
        VerticalLayout verticalLayout = new VerticalLayout(header, fahrzeugSection);
        return verticalLayout;

    }

    private Component createSchadenSection() {
        H2 header = new H2("Schadeninformationen");
        schadenSection = new SchadenSection();
        VerticalLayout verticalLayout = new VerticalLayout(header, schadenSection);
        return verticalLayout;

    }

}
