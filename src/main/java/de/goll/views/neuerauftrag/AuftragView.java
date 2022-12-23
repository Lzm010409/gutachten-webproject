package de.goll.views.neuerauftrag;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goll.components.abtrittserklärung.AbtrittserklärungSection;
import de.goll.components.aufnahmebogen.*;
import de.goll.data.entity.Auftrag;
import de.goll.data.entity.Fahrzeug;
import de.goll.data.entity.Kunde;
import de.goll.data.service.*;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;

@PageTitle("Neuer Auftrag")
@Route(value = "neuerauftrag", layout = MainLayout.class)
@RolesAllowed("USER")
public class AuftragView extends VerticalLayout {
    AuftragsSection auftragsSection;
    KundeSection kundeSection = new KundeSection();

    FahrzeugSection fahrzeugSection;

    AuftragService auftragService;
    KundeService kundeService;
    RechtsanwaltService rechtsanwaltService;
    FahrzeugService fahrzeugService;

    AbtrittserklärungSection abtrittserklärungSection = new AbtrittserklärungSection();

    private Auftrag auftrag = new Auftrag();
    private Fahrzeug fahrzeug = new Fahrzeug();
    private Kunde kunde = new Kunde();

    Button save = new Button("Sichern");
    Button delete = new Button("Löschen");
    Button cancel = new Button("Abbrechen");

    public AuftragView(AuftragService auftragService,
                       KundeService kundeService,
                       RechtsanwaltService rechtsanwaltService,
                       FahrzeugService fahrzeugService) {
        this.auftragService = auftragService;
        this.kundeService = kundeService;
        this.rechtsanwaltService = rechtsanwaltService;
        this.fahrzeugService = fahrzeugService;
        //configureFahrzeugSection();
        configureAuftragsSection();
        // configureKundeSection();
        add(createButtonLayout());

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Auftragsdetails", auftragsSection.createAuftragsDetails());
        tabSheet.add("Kundendetails", auftragsSection.createKundenSection());
        tabSheet.add("Fahrzeugdetails", auftragsSection.createFahrzeugSection());
        tabSheet.add("Schadendetails", auftragsSection.createSchadenDetails());
        tabSheet.add("Abtrittserklärung", abtrittserklärungSection.configureAbtrittserklärungSection());
        add(tabSheet);

    }

    public Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout horizontalLayout = new HorizontalLayout(save, delete, cancel);

        save.addClickListener(buttonClickEvent -> auftragsSection.validateAndSaveAuftrag());
        auftragsSection.getAuftragsdetailsBinder().addStatusChangeListener(e -> save.setEnabled(auftragsSection.getAuftragsdetailsBinder().isValid()));
        return horizontalLayout;
    }

    /*  private void configureFahrzeugSection() {
          fahrzeugSection = new FahrzeugSection();
          fahrzeugSection.addListener(FahrzeugSection.SaveFahrzeugEvent.class, this::saveFahrzeug);
      }
  */
    private void configureAuftragsSection() {
        auftragsSection = new AuftragsSection();
        auftragsSection.addListener(AuftragsSection.SaveAuftragEvent.class, this::saveAuftrag);
    }

   /* private void configureKundeSection() {
        kundeSection = new KundeSection();
        kundeSection.addListener(KundeSection.SaveKundeEvent.class, this::saveKunde);
    }*/

    /*public void saveFahrzeug(FahrzeugSection.SaveFahrzeugEvent event) {
        fahrzeugService.saveFahrzeug(event.getFahrzeug());
        setFahrzeug(event.getFahrzeug());
    }*/

    public void saveAuftrag(AuftragsSection.SaveAuftragEvent event) {
        auftragService.saveAuftrag(event.getAuftrag());
    }

   /* public void saveKunde(KundeSection.SaveKundeEvent event) {
        kundeService.saveKunde(event.getKunde());
        setKunde(event.getKunde());
    }*/


    public AuftragsSection getAuftragsSection() {
        return auftragsSection;
    }

    public void setAuftragsSection(AuftragsSection auftragsSection) {
        this.auftragsSection = auftragsSection;
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

    public FahrzeugSection getFahrzeugSection() {
        return fahrzeugSection;
    }

    public void setFahrzeugSection(FahrzeugSection fahrzeugSection) {
        this.fahrzeugSection = fahrzeugSection;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
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

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
