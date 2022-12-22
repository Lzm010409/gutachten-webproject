package de.goll.views.neuerauftrag;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goll.components.abtrittserklärung.AbtrittserklärungSection;
import de.goll.components.aufnahmebogen.*;
import de.goll.data.service.*;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;

@PageTitle("Neuer Auftrag")
@Route(value = "neuerauftrag", layout = MainLayout.class)
@RolesAllowed("USER")
public class AuftragView extends VerticalLayout {
    AuftragsdetailsSection auftragsdetailsSection;
    KundeSection kundeSection = new KundeSection();

    FahrzeugSection fahrzeugSection;

    AuftragsDetailsService auftragsDetailsService;

    AuftragService auftragService;
    KundeService kundeService;
    RechtsanwaltService rechtsanwaltService;
    FahrzeugService fahrzeugService;

    AbtrittserklärungSection abtrittserklärungSection = new AbtrittserklärungSection();

    public AuftragView(AuftragService auftragService,
                       KundeService kundeService,
                       RechtsanwaltService rechtsanwaltService,
                       FahrzeugService fahrzeugService,
                       AuftragsDetailsService auftragsDetailsService) {
        this.auftragService = auftragService;
        this.kundeService = kundeService;
        this.rechtsanwaltService = rechtsanwaltService;
        this.fahrzeugService = fahrzeugService;
        this.auftragsDetailsService = auftragsDetailsService;
        configureFahrzeugSection();
        configureHeadSection();
        configureKundeSection();

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Auftragsdetails", auftragsdetailsSection);
        tabSheet.add("Kundendetails", kundeSection);
        tabSheet.add("Fahrzeugdetails", fahrzeugSection);
        tabSheet.add("Schadendetails", auftragsdetailsSection.createSchadenDetails());
        tabSheet.add("Abtrittserklärung", abtrittserklärungSection.configureAbtrittserklärungSection());
        add(tabSheet);

    }

    private void configureFahrzeugSection() {
        fahrzeugSection = new FahrzeugSection();
        fahrzeugSection.addListener(FahrzeugSection.SaveFahrzeugEvent.class, this::saveFahrzeug);
    }

    private void configureHeadSection() {
        auftragsdetailsSection = new AuftragsdetailsSection();
        auftragsdetailsSection.addListener(AuftragsdetailsSection.SaveAuftragdetailsEvent.class, this::saveAuftragdetails);
    }

    private void configureKundeSection() {
        kundeSection = new KundeSection();
        kundeSection.addListener(KundeSection.SaveKundeEvent.class, this::saveKunde);
    }

    public void saveFahrzeug(FahrzeugSection.SaveFahrzeugEvent event) {
        fahrzeugService.saveFahrzeug(event.getFahrzeug());

    }

    public void saveAuftragdetails(AuftragsdetailsSection.SaveAuftragdetailsEvent event) {
        auftragsDetailsService.saveAuftragdetails(event.getAuftragsdetails());
    }

    public void saveKunde(KundeSection.SaveKundeEvent event) {
        kundeService.saveKunde(event.getKunde());
    }


    public AuftragsdetailsSection getAuftragsdetailsSection() {
        return auftragsdetailsSection;
    }

    public void setAuftragsdetailsSection(AuftragsdetailsSection auftragsdetailsSection) {
        this.auftragsdetailsSection = auftragsdetailsSection;
    }

    public KundeSection getKundeSection() {
        return kundeSection;
    }

    public void setKundeSection(KundeSection kundeSection) {
        this.kundeSection = kundeSection;
    }

    public AuftragService getAuftragService() {
        return auftragService;
    }

    public void setAuftragService(AuftragService auftragService) {
        this.auftragService = auftragService;
    }

    public KundeService getKundeService() {
        return kundeService;
    }

    public void setKundeService(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    public RechtsanwaltService getRechtsanwaltService() {
        return rechtsanwaltService;
    }

    public void setRechtsanwaltService(RechtsanwaltService rechtsanwaltService) {
        this.rechtsanwaltService = rechtsanwaltService;
    }

    public FahrzeugService getFahrzeugService() {
        return fahrzeugService;
    }

    public void setFahrzeugService(FahrzeugService fahrzeugService) {
        this.fahrzeugService = fahrzeugService;
    }

    public AbtrittserklärungSection getAbtrittserklärungSection() {
        return abtrittserklärungSection;
    }

    public void setAbtrittserklärungSection(AbtrittserklärungSection abtrittserklärungSection) {
        this.abtrittserklärungSection = abtrittserklärungSection;
    }
}
