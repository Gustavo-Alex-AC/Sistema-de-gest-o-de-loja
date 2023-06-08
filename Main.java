import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prato prato1 = new Pizza();
        Prato prato2 = new Lanche();
        Prato prato3 = new Salgadinho();

        ArrayList<Prato> pratos = new ArrayList<>();
        pratos.add(prato1);
        pratos.add(prato2);
        pratos.add(prato3);


        Pedido pedido1 = new Pedido();

        //pedido1.calcularPrecoTotal();
        getData();
    }

    public static void getData(){
        try {

            Connection connection = ConexaoDB.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from pedido");

            while (resultSet.next()){
                System.out.printf("{Cliente: %s, Pagamento: %.2f, Taxa de Serviço: %.2f, Pedido: %d}%n",
                        resultSet.getString(3),resultSet.getDouble(1),
                        resultSet.getDouble(2), resultSet.getInt(4) );
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
