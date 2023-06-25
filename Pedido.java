/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snackbar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 *
 * @author LENOVO
 */
public class Pedido {
    private String nomeCliente;
    private double precoTotal;
    private double pagamento;
    private ArrayList<Prato> itensConsumido = new ArrayList<>();
    private Double taxaDeServico;

   
    public Pedido(String nomeCliente, double pagamento, ArrayList<Prato> itensConsumido, Double taxaDeServico) {
        this.nomeCliente = nomeCliente;
        this.pagamento = pagamento;
        this.itensConsumido = itensConsumido;
        this.taxaDeServico = taxaDeServico;
    }
    
    public Pedido() {
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double calcularPrecoTotal() {
        double precoTotal = 0;
        double peso = 0;
        for (Prato i : itensConsumido) {
            precoTotal += i.getPrecoDeVenda() + (i.getPrecoDeVenda() * taxaDeServico);
            peso += i.getPeso();
        }

        if (peso>=3 && peso <=5){
            precoTotal = precoTotal + precoTotal*0.1;
        } else if (peso>=6 && peso <=10) {
            precoTotal = precoTotal + precoTotal*0.2;
        } else{
            precoTotal = precoTotal + precoTotal*0.3;
        }

        return precoTotal;
    }

    public void factura(){

         try {
            String fileName = "C:\\Users\\LENOVO\\Desktop\\GeneratePdf\\factura.pdf";
            Document factura = new Document();
            
            try {
                PdfWriter.getInstance(factura, new FileOutputStream(fileName));
                factura.open();

                // Create font for header and items
                Font headerFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
                Font itemFont = new Font(Font.FontFamily.HELVETICA, 12);

                // Add header
                Paragraph header1 = new Paragraph("O Chalê - Snack Bar", headerFont);
                factura.add(header1);
                factura.add(new Paragraph("----------------------------------------"));

                // Add customer details
                Paragraph header2 = new Paragraph("Recibo ", headerFont);
                factura.add(header2);
                factura.add(new Paragraph("Cliente:    " + nomeCliente));
                factura.add(new Paragraph("\n"));
                // Add items
                for (var i : itensConsumido) {
                    String itemName = i.getClass().getName().substring(9);
                    if (itemName.equalsIgnoreCase("pizza") || itemName.equalsIgnoreCase("lanche")) itemName = itemName+"     ";
                    double itemPrice = i.precoDeVenda;

                    Paragraph item = new Paragraph(String.format("%-15s $%.2f", itemName, itemPrice), itemFont);
                    factura.add(item);
                }

                factura.add(new Paragraph("----------------------------------------"));
                factura.add(new Paragraph(String.format("Total:          $%.2f", calcularPrecoTotal())));
                factura.add(new Paragraph(String.format("Pagamento:  $%.2f", getPagamento())));
                factura.add(new Paragraph(String.format("Troco:          $%.2f", getPagamento()-calcularPrecoTotal())));
                factura.add(new Paragraph("------------- Obrigado!!! ------------"));

                factura.close();
                System.out.println("Receipt generated successfully.");
            } catch (DocumentException ex) {
                System.out.println(ex);
            }
        } catch (FileNotFoundException ex) {
             System.out.println(ex);
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Prato> getItensConsumido() {
        return itensConsumido;
    }

    public void setItensConsumido(ArrayList<Prato> itensConsumido) {
        this.itensConsumido = itensConsumido;
    }

    public Double getTaxaDeServico() {
        return taxaDeServico;
    }

    public void setTaxaDeServico(Double taxaDeServico) {
        this.taxaDeServico = taxaDeServico;
    }
}
