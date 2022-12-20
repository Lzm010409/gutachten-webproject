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
import de.goll.data.entity.Auftrag;
import de.goll.views.MainLayout;

import javax.annotation.security.RolesAllowed;

@PageTitle("Auftragsübersicht")
@Route(value = "Auftragsübersicht", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@RolesAllowed("USER")
public class AuftragsübersichtView extends VerticalLayout {

    Grid<Auftrag> grid = new Grid<>(Auftrag.class);

    public AuftragsübersichtView() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
    }
    TextField filterText = new TextField();



    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("auftragsNummer", "kundeName", "rechtsanwaltName");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
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
