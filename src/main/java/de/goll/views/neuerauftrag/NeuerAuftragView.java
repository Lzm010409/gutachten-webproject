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
import de.goll.components.aufnahmebogen.HeadSection;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;
import java.awt.*;

@PageTitle("Neuer Auftrag")
@Route(value = "neuerauftrag", layout = MainLayout.class)
@RolesAllowed("USER")
public class NeuerAuftragView extends VerticalLayout {
    HeadSection headSection;


    public NeuerAuftragView() {

        add(createHeadSection());
    }

    public Component createHeadSection() {
        H2 header = new H2("Auftragsdetails");
        headSection= new HeadSection();
        Image image = new Image();
        image.setSrc("/Users/lukegollenstede/IdeaProjects/gutachten-webproject/src/main/resources/gollenstede-1.png");
        HorizontalLayout content = new HorizontalLayout(image, headSection);
        content.setFlexGrow(1, image);
        content.setFlexGrow(2, headSection);
        content.setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout(header,content);
        return verticalLayout;

    }

}
