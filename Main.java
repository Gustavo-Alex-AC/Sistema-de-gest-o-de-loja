/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snackbar;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Pizza pizza = new Pizza(4500.00, "14/06/23",0.6,"Tomate","Frango_Desfiado", "Cebola_e_Alho");
        //Lanche lanche = new Lanche(850.00, "16/04/23", 0.4, "Medio", "Franco","Mayonesse" );
        //Salgadinho salgadinho = new Salgadinho(820.00, "17/05/23",0.5,"Frito","Doce_De_Coco", "Branca");

        ArrayList<Prato> pratos = new ArrayList<>();
        //pratos.add(pizza);
        //pratos.add(salgadinho);
        //pratos.add(lanche);

        Pedido pedido = new Pedido("Edvaldo",2000.00, pratos, 0.02);

        PedidoDBImp novoPedido1 = new PedidoDBImp();
        //novoPedido1.pedidoLanche(lanche, pedido);
        //System.out.println("Ultimo Id: "+novoPedido1.getLastId());

        //pedido.factura();
        //imprimirPratosDB();
        
        //novoPedido1.gerarFactura(pedido);
        
    }
    
    
}
