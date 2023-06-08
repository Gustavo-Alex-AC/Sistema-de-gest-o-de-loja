import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Pedido {
    private String nomeCliente;
    private double quantidade;
    private double pagamento;
    private ArrayList<Prato> itensConsumido = new ArrayList<>();
    private Double taxaDeServico;

    public Pedido() {
    }

    public Pedido(String nomeCliente, double quantidade, double pagamento, ArrayList<Prato> itensConsumido, Double taxaDeServico) {
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.pagamento = pagamento;
        this.itensConsumido = itensConsumido;
        this.taxaDeServico = taxaDeServico;
    }

    public void calcularPrecoTotal() {
        Scanner sc = new Scanner(System.in);
        double precoTotal = 0;
        for (Prato i : itensConsumido) {
            precoTotal += i.getPrecoDeVenda() + (i.getPrecoDeVenda() * taxaDeServico);
        }

        System.out.printf("Total = %.2f%n", precoTotal);
        System.out.print("Pagamento: ");
        double valor = sc.nextDouble();
        pagamento = valor;
        mostrarFactura(precoTotal);
    }

    // exemplo de factura
    public void mostrarFactura(double precoTotal) {

        System.out.println("-".repeat(30));
        System.out.println("----Snack Bar - Chale----");
        System.out.println("-".repeat(30));
        double troco = pagamento - precoTotal;
        for (Prato i : itensConsumido) {
            System.out.printf("%s: %6.2f%n", i.getClass().getName().toUpperCase(Locale.ROOT), i.getPrecoDeVenda());
        }
        System.out.printf("TAXA DE SERVIÇO: %6.2f%n", taxaDeServico);
        System.out.println("-".repeat(30));
        System.out.printf("PREÇO TOTAL: %6.2f%n", precoTotal);
        System.out.println("-".repeat(30));
        System.out.printf("PAGAMENTO: %6.2f%n", pagamento);
        System.out.printf("TROCO: %6.2f%n", troco);
        System.out.println("-".repeat(30));
        System.out.println("----Obrigado----");
        System.out.println("-".repeat(30));
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
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

