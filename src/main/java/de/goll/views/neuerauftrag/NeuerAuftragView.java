package de.goll.views.neuerauftrag;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goll.components.abtrittserklärung.AbtrittserklärungSection;
import de.goll.components.aufnahmebogen.*;
import de.goll.data.service.AuftragService;
import de.goll.data.service.FahrzeugService;
import de.goll.data.service.KundeService;
import de.goll.data.service.RechtsanwaltService;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;

@PageTitle("Neuer Auftrag")
@Route(value = "neuerauftrag", layout = MainLayout.class)
@RolesAllowed("USER")
public class NeuerAuftragView extends VerticalLayout {
    AuftragService auftragService;
    KundeService kundeService;
    RechtsanwaltService rechtsanwaltService;
    FahrzeugService fahrzeugService;

    AufnahmebogenSection aufnahmebogenSection = new AufnahmebogenSection();
    AbtrittserklärungSection abtrittserklärungSection = new AbtrittserklärungSection();

    public NeuerAuftragView(AuftragService auftragService,
                            KundeService kundeService,
                            RechtsanwaltService rechtsanwaltService,
                            FahrzeugService fahrzeugService) {
        this.auftragService = auftragService;
        this.kundeService = kundeService;
        this.rechtsanwaltService = rechtsanwaltService;
        this.fahrzeugService = fahrzeugService;

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Aufnahmebogen", aufnahmebogenSection.createAufnahmebogenSection());
        tabSheet.add("Abtrittserklärung", abtrittserklärungSection.configureAbtrittserklärungSection());
        add(tabSheet);
    }


}
