package de.goll.pdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfOutputStream;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.*;
import java.net.MalformedURLException;

public class PdfWorker {


    public PdfWorker() {

    }


    public PdfDocument readPdf(String source) {
        try {
            return new PdfDocument(new PdfReader(source));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addImageToPdf(String source, byte[] imagePath, String dest) throws IOException {
        PdfDocument input = new PdfDocument(new PdfReader(new File(source)), new PdfWriter(dest));
        Document document = new Document(input);
        ImageData data = ImageDataFactory.create(imagePath);
        Image image = new Image(data);
        //image.setHeight(15);
        //image.setWidth(15);
        image.setFixedPosition( input.getDefaultPageSize().getHeight()/2, input.getDefaultPageSize().getWidth()/2);
        image.setOpacity(0.8f);
        document.add(image);
        document.close();
    }
}
