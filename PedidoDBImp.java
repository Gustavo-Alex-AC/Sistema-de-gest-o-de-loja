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
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonçalo
 */
public class PedidoDBImp implements PedidoDB {
    int lastId;

    public int getLastId() {
        return lastId;
    }

    public void pedidoPizza(Pizza pizza, Pedido pedido) {

        double troco = pedido.getPagamento() - pedido.calcularPrecoTotal();
        

        try {
            Connection con = ConexaoDB.getConnection();
            // Inserir dados quando o nome da classe for pizza

            String sql1 = "INSERT INTO prato(preco_de_venda,data_de_validade,peso,recheio,molho,cobertura,Prato_TIPO) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);

            ps1.setDouble(1, pizza.getPrecoDeVenda());
            ps1.setString(2, pizza.getDataDeValidade());
            ps1.setDouble(3, pizza.getPeso());
            ps1.setString(4, pizza.getRecheio());
            ps1.setString(5, pizza.getMolho());
            ps1.setString(6, pizza.getCobertura());
            ps1.setString(7, pizza.getClass().getName().substring(9));
            ps1.executeUpdate();
            System.out.println("Successfully Saved pizza !!!");

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                lastId = rs.getInt(1);
            }

             // guardar dados de pedidos
            String sql = "INSERT INTO Pedido(taxa_de_servico, preco_total,troco , pagamento,fk_Prato_codigo,nomeCliente,Prato_TIPO, Preco_de_venda) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pedido.getTaxaDeServico());
            ps.setDouble(2, pedido.calcularPrecoTotal());
            ps.setDouble(3, troco);
            ps.setDouble(4, pedido.getPagamento());
            ps.setInt(5, lastId);
            ps.setString(6, pedido.getNomeCliente());

            for (Prato i : pedido.getItensConsumido()) {
                if (i.getClass().getName().substring(9).equalsIgnoreCase("pizza"))
                    ps.setString(7, i.getClass().getName().substring(9));
                    ps.setDouble(8, i.getPrecoDeVenda());
            }

            ps.executeUpdate();
            System.out.println("Successfully Saved pedido !!!");

            //con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void pedidoLanche(Lanche lanche, Pedido pedido) {

        double troco = pedido.getPagamento() - pedido.calcularPrecoTotal();
        //int lastId = 0;

        try {
            Connection con = ConexaoDB.getConnection();

            // Inserir dados quando o nome da classe for lanche

            String sql1 = "INSERT INTO prato(preco_de_venda,data_de_validade,peso,tipo_de_pao, recheio,molho,Prato_TIPO) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);

            ps1.setDouble(1, lanche.getPrecoDeVenda());
            ps1.setString(2, lanche.getDataDeValidade());
            ps1.setDouble(3, lanche.getPeso());
            ps1.setString(4, lanche.getPao());
            ps1.setString(5, lanche.getRecheio());
            ps1.setString(6, lanche.getMolho());
            ps1.setString(7, lanche.getClass().getName().substring(9));

            ps1.executeUpdate();
            System.out.println("Successfully Saved Lanche !!!");

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                lastId = rs.getInt(1);
            }

             // guardar dados de pedidos
            String sql = "INSERT INTO Pedido(taxa_de_servico, preco_total,troco , pagamento,fk_Prato_codigo,nomeCliente,Prato_TIPO, Preco_de_venda) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pedido.getTaxaDeServico());
            ps.setDouble(2, pedido.calcularPrecoTotal());
            ps.setDouble(3, troco);
            ps.setDouble(4, pedido.getPagamento());
            ps.setInt(5, lastId);
            ps.setString(6, pedido.getNomeCliente());

            for (Prato i : pedido.getItensConsumido()) {
                if (i.getClass().getName().substring(9).equalsIgnoreCase("lanche")){
                ps.setString(7, i.getClass().getName().substring(9));
                ps.setDouble(8, i.getPrecoDeVenda());
            }}

            ps.executeUpdate();
            System.out.println("Successfully Saved pedido !!!");

            //con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void pedidoSalgadinho(Salgadinho salgadinho, Pedido pedido) {

        double troco = pedido.getPagamento() - pedido.calcularPrecoTotal();
        //int lastId = 0;

        try {
            Connection con = ConexaoDB.getConnection();

            // Inserir dados quando o nome da classe for salgadinh

            String sql1 = "INSERT INTO prato(preco_de_venda,data_de_validade,peso,recheio,massa,tipoSalgadinho,Prato_TIPO) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);

            ps1.setDouble(1, salgadinho.getPrecoDeVenda());
            ps1.setString(2, salgadinho.getDataDeValidade());
            ps1.setDouble(3, salgadinho.getPeso());
            ps1.setString(4, salgadinho.getRecheio());
            ps1.setString(5, salgadinho.getMassa());
            ps1.setString(6, salgadinho.getTipo());
            ps1.setString(7, salgadinho.getClass().getName().substring(9));
            ps1.executeUpdate();
            System.out.println("Successfully Saved Salgadinho !!!");

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                lastId = rs.getInt(1);
            }

            // guardar dados de pedidos
            String sql = "INSERT INTO Pedido(taxa_de_servico, preco_total,troco , pagamento,fk_Prato_codigo,nomeCliente,Prato_TIPO, Preco_de_venda) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pedido.getTaxaDeServico());
            ps.setDouble(2, pedido.calcularPrecoTotal());
            ps.setDouble(3, troco);
            ps.setDouble(4, pedido.getPagamento());
            ps.setInt(5, lastId);
            ps.setString(6, pedido.getNomeCliente());

            for (Prato i : pedido.getItensConsumido()) {
                if (i.getClass().getName().substring(9).equalsIgnoreCase("salgadinho")){
                    ps.setString(7, i.getClass().getName().substring(9));
                    ps.setDouble(8, i.getPrecoDeVenda());
            }}

            ps.executeUpdate();
            System.out.println("Successfully Saved pedido !!!");

            //con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void gerarFactura(Pedido pedido) {
        
         try {
            String fileName = "C:\\Users\\user\\Desktop\\Fatura\\factura.pdf";
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
                
                //DB
                try {

                    Connection connection = ConexaoDB.getConnection();
                    //Statement statement = connection.createStatement();
                    //ResultSet rs = statement.executeQuery("select * from pedido where nomeCliente=?");
                    
                    String query = "SELECT * FROM pedido WHERE nomeCliente = ?";
                     
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, pedido.getNomeCliente());
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()){

                         // Add customer details
                        Paragraph header2 = new Paragraph("Recibo NO. "+rs.getInt(1), headerFont);
                        factura.add(header2);
                        factura.add(new Paragraph("Cliente:    " + rs.getString(7)));
                        factura.add(new Paragraph("\n"));
                        // Add items

                        String itemName = rs.getString(9);
                        double itemPrice = rs.getDouble(8);

                        Paragraph item = new Paragraph(String.format("%-15s $%.2f", itemName, itemPrice), itemFont);
                        factura.add(item);


                        factura.add(new Paragraph("----------------------------------------"));
                        factura.add(new Paragraph(String.format("Total:          $%.2f", rs.getDouble(3))));
                        factura.add(new Paragraph(String.format("Pagamento:  $%.2f", rs.getDouble(5))));
                        factura.add(new Paragraph(String.format("Troco:          $%.2f", rs.getDouble(4))));
                        factura.add(new Paragraph("------------- Obrigado!!! ------------"));
                    }

                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    
              
                factura.close();
                System.out.println("Receipt generated successfully.");
            } catch (DocumentException ex) {
                System.out.println(ex);
            }
        } catch (FileNotFoundException ex) {
             System.out.println(ex);
        }
    }
}
