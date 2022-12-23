package de.goll.views.auftragsübersicht;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.goll.components.aufnahmebogen.AuftragsSection;
import de.goll.data.entity.Auftrag;
import de.goll.data.service.AuftragService;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;

@PageTitle("Auftragsübersicht")
@Route(value = "Auftragsübersicht", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@RolesAllowed("USER")
public class AuftragsübersichtView extends VerticalLayout {

    Grid<Auftrag> grid = new Grid<>(Auftrag.class);
    AuftragService auftragService;

    AuftragsSection auftragsSection;

    public AuftragsübersichtView(AuftragService auftragService) {
        this.auftragService = auftragService;
        auftragsSection = new AuftragsSection();
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        add(grid);
        updateList();
    }

    TextField filterText = new TextField();


    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("auftragsNummer");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(event ->
                editAuftrag(event.getValue()));
    }

    public void editAuftrag(Auftrag auftrag) {
        if (auftrag != null) {
            auftragsSection.setAuftrag(auftrag);
            addClassName("editing");
        }

    }

    private void updateList() {
        grid.setItems(auftragService.findAllAuftraege());
    }

   /* private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Add contact");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }*/


}
