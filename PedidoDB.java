/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package snackbar;

/**
 *
 * @author LENOVO
 */
public interface PedidoDB {
     void pedidoPizza(Pizza pizza, Pedido pedido);
    void pedidoLanche(Lanche lanche, Pedido pedido);
    void pedidoSalgadinho(Salgadinho salgadinho, Pedido pedido);

    void gerarFactura(Pedido pedido);
}
