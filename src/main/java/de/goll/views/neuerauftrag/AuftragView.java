package de.goll.views.neuerauftrag;

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
public class AuftragView extends VerticalLayout {
    HeadSection headSection = new HeadSection();
    KundeSection kundeSection = new KundeSection();
    FahrzeugSection fahrzeugSection = new FahrzeugSection();
    SchadenSection schadenSection = new SchadenSection();
    AuftragService auftragService;
    KundeService kundeService;
    RechtsanwaltService rechtsanwaltService;
    FahrzeugService fahrzeugService;

    AbtrittserklärungSection abtrittserklärungSection = new AbtrittserklärungSection();

    public AuftragView(AuftragService auftragService,
                       KundeService kundeService,
                       RechtsanwaltService rechtsanwaltService,
                       FahrzeugService fahrzeugService) {
        this.auftragService = auftragService;
        this.kundeService = kundeService;
        this.rechtsanwaltService = rechtsanwaltService;
        this.fahrzeugService = fahrzeugService;

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Auftragsdetails", headSection);
        tabSheet.add("Kundendetails", kundeSection);
        tabSheet.add("Fahrzeugdetails", fahrzeugSection);
        tabSheet.add("Schadendetails", schadenSection);
        tabSheet.add("Abtrittserklärung", abtrittserklärungSection.configureAbtrittserklärungSection());
        add(tabSheet);
    }


}
