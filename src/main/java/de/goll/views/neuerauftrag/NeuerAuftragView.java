package de.goll.views.neuerauftrag;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goll.components.aufnahmebogen.FahrzeugSection;
import de.goll.components.aufnahmebogen.HeadSection;
import de.goll.components.aufnahmebogen.KundeSection;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;
import java.awt.*;

@PageTitle("Neuer Auftrag")
@Route(value = "neuerauftrag", layout = MainLayout.class)
@RolesAllowed("USER")
public class NeuerAuftragView extends VerticalLayout {
    HeadSection headSection;
    KundeSection kundeSection;
    FahrzeugSection fahrzeugSection;


    public NeuerAuftragView() {

        add(createHeadSection(), createKundenSection(), createFahrzeugSection());
    }

    public Component createHeadSection() {
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

    public Component createKundenSection() {
        H2 header = new H2("Kundeninformationen");
        KundeSection kundeSection = new KundeSection();
        VerticalLayout verticalLayout = new VerticalLayout(header, kundeSection);
        return verticalLayout;

    }

    public Component createFahrzeugSection() {
        H2 header = new H2("Fahrzeuginformationen");
        FahrzeugSection fahrzeugSection1 = new FahrzeugSection();
        VerticalLayout verticalLayout = new VerticalLayout(header, fahrzeugSection1);
        return verticalLayout;

    }

}
