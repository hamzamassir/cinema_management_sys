package com.example.cinema.generators;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class TicketPdfGenerator {



    public void generateTicket(String username, String eventName, Integer codePayment, String filePath, int numberTicket)
            throws DocumentException, IOException {
        // Set a custom page size (adjust width and height as needed)
        Document document = new Document( PageSize.A5);

        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Add logo (adjust the path accordingly)
        Image logo = Image.getInstance("src/main/resources/static/assets/logoPdf.png");
        logo.scaleToFit(50, 50);
        document.add(logo);

        // Add ticket information
        document.add(new Paragraph("Ticket Information"));

        // Customize font and alignment for a better design
        Paragraph usernameParagraph = new Paragraph("Username: " + username);
        usernameParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(usernameParagraph);

        Paragraph eventParagraph = new Paragraph("Event: " + eventName);
        eventParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(eventParagraph);

        Paragraph ticketNumberParagraph = new Paragraph("Ticket Number: " + numberTicket);
        ticketNumberParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(ticketNumberParagraph);

        Paragraph paymentCodeParagraph = new Paragraph("Payment Code: " + codePayment);
        paymentCodeParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paymentCodeParagraph);

        document.close();
    }

}
