import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*Lanche lanche = new Lanche(1300.00, "05/06/23",0.5,"Integral","Atum", "Chexape");
        ;*/

        Salgadinho salgadinho = new Salgadinho(420.00, "03/04/22",0.2,"Frito","Doce de Coco", "Branca");
        ArrayList<Prato> pratos = new ArrayList<>();
        pratos.add(salgadinho);

        Pedido pedido = new Pedido("Uliana", 3, 5000.00, pratos, 0.10);

        PedidosDBImp novoPedido = new PedidosDBImp();
        novoPedido.pedidoSalgadinho(salgadinho, pedido);


    }

    public static void pedido(){
            Pizza prato = new Pizza(4300.00, "12/03/23",1.2,"Picante","Frnaco", "Couriço");
            //Lanche prato = new Lanche(1300.00, "05/06/23",0.5,"Integral","Atum", "Chexape");
            //Salgadinho pra = new Salgadinho(420.00, "03/04/22",0.2,"Frito","Doce de Coco", "Branca");

            ArrayList<Prato> pratos = new ArrayList<>();

            pratos.add(prato);

            Pedido pedido = new Pedido("Gustavo Alex", 1, 6000, pratos, 0.05);

            double troco = pedido.getPagamento() - pedido.calcularPrecoTotal();
            int lastId = 0;

            try {
                Connection con = ConexaoDB.getConnection();

                Statement statement = con.createStatement();
                // Inserir dados quando o nome da classe for pizza

                    String sql1 = "INSERT INTO prato(preco_de_venda,data_de_validade,peso,recheio,molho,cobertura,Prato_TIPO) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement ps1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);

                    ps1.setDouble(1, prato.getPrecoDeVenda());
                    ps1.setString(2, prato.getDataDeValidade());
                    ps1.setDouble(3, prato.getPeso());
                    ps1.setString(4, prato.getRecheio());
                    ps1.setString(5, prato.getMolho());
                    ps1.setString(6, prato.getCobertura());
                    ps1.setString(7, prato.getClass().getName());
                    ps1.executeUpdate();
                    System.out.println("Successfully Saved pizza !!!");

                    ResultSet rs = ps1.getGeneratedKeys();

                    if (rs.next()) {
                        lastId = rs.getInt(1);
                    }

                // guardar dados de pedidos
                String sql = "INSERT INTO Pedido(taxa_de_servico, preco_total, quantidades,troco , pagamento,fk_Prato_codigo,nomeCliente) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, pedido.getTaxaDeServico());
                ps.setDouble(2, pedido.calcularPrecoTotal());
                ps.setInt(3, pedido.getQuantidade());
                ps.setDouble(4, troco);
                ps.setDouble(5, pedido.getPagamento());
                ps.setInt(6, lastId);
                ps.setString(7, pedido.getNomeCliente());
                ps.executeUpdate();
                System.out.println("Successfully Saved pedido !!!");

                con.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    public static void imprimirPratosDB(){
        try {

            Connection connection = ConexaoDB.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from prato");

            while (resultSet.next()){
                if (resultSet.getString(11).equalsIgnoreCase("pizza")){
                System.out.printf("{Prato: %s, Recheio: %s, Molho: %s, Cobertura: %s, Preço de venda: %.2f}%n",
                        resultSet.getString(11),resultSet.getString(7),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getDouble(2) );
            }
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
