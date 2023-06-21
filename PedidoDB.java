
package snackbar;

public interface PedidoDB {
     void pedidoPizza(Pizza pizza, Pedido pedido);
    void pedidoLanche(Lanche lanche, Pedido pedido);
    void pedidoSalgadinho(Salgadinho salgadinho, Pedido pedido);

    void gerarFactura(Pedido pedido);
}
