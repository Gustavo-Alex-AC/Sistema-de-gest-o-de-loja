
package snackbar;
import java.sql.*;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
       Pizza pizza = new Pizza ( 5000.00, "21/06/23", 0.6 , "picante","frango", "queijo");
       Lanche lanche = new Lanche (1000.00, "21/06/23", 0.7, "Frances","frango","Maionese" );
    
       ArrayList<Prato> pratos = new ArrayList<>();
       pratos.add(pizza);
       pratos.add(lanche);
       
       Pedido pedido = new Pedido("EVander",2000.00, pratos,0.1);
       PedidoDBImp novopedido1 =  new PedidoDBImp();
       novopedido1.pedidoPizza(pizza, pedido);
       novopedido1.pedidoLanche(lanche, pedido);
       pedido.factura();
       
    }
   
    
}
