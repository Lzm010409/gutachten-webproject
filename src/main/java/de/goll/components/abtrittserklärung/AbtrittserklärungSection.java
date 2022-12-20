package de.goll.components.abtrittserklärung;

import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.goll.components.signature.ImageEncode;
import de.goll.components.signature.SignaturePad;
import de.goll.pdf.PdfWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AbtrittserklärungSection {
    PdfViewer pdfViewer = new PdfViewer();
    SignaturePad signaturePad = new SignaturePad();
    Button button = new Button("Absenden");
    DatePicker date = new DatePicker("Datum");
    TextField place = new TextField("Ort");

    public AbtrittserklärungSection() {
    }

    public Component configureAbtrittserklärungSection() {
        configureButton();
        configureSiganturePad();
        H2 header = new H2("Abtrittserklärung");
        VerticalLayout verticalLayout = new VerticalLayout(header, configurePlaceDate(), signaturePad, button);
        return verticalLayout;
    }

    private void configureSiganturePad() {
        signaturePad.setWidth("500px");
        signaturePad.setHeight("500px");
        signaturePad.setPenColor("#000000");
    }

    private Component configurePlaceDate() {
        HorizontalLayout horizontalLayout = new HorizontalLayout(place, date);
        return horizontalLayout;
    }

    public void configureButton() {
        button.addClickListener(buttonClickEvent -> createAbtretungserklärung());
    }

    private void createAbtretungserklärung(){
        byte [] arr = getSignatureByteArray();
        try {
            new PdfWorker().addImageToPdf("/pdf/Abtretung.pdf",arr,"Abtretung.pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getSignatureByteArray() {
        byte[] decoded = signaturePad.getImageBase64();
        return decoded;
    }


}
