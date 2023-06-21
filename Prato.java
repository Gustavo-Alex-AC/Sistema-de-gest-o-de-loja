/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snackbar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prato {
    protected Double precoDeVenda;
    private String dataDeValidade;
    private Double peso;

   
    public Prato(Double precoDeVenda, String dataDeValidade, Double peso) {
        this.precoDeVenda = precoDeVenda;
        this.dataDeValidade = dataDeValidade;
        this.peso = peso;
    }

    public Prato() {
    }
    
    public void imprimirPratosDB(){
        try {

            /*Connection connection = ConexaoDB.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from prato");*/
             Connection connection = ConexaoDB.getConnection();
                    //Statement statement = connection.createStatement();
                    //ResultSet rs = statement.executeQuery("select * from pedido where nomeCliente=?");
                    
                    String query = "SELECT * FROM clients WHERE nomeCliente = ?";
                     
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, "Gustavo");
                    ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                
                System.out.printf("{Prato: %s, Recheio: %s, Molho: %s, Cobertura: %s, Preço de venda: %.2f}%n",
                        resultSet.getString(11),resultSet.getString(7),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getDouble(2) );

            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    public Double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(Double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
