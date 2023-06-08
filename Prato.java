public class Prato {
    protected Double precoDeVenda;
    private String dataDeValidade;
    private Double peso;

    public Prato() {
    }

    public Prato(Double precoDeVenda, String dataDeValidade, Double peso) {
        this.precoDeVenda = precoDeVenda;
        this.dataDeValidade = dataDeValidade;
        this.peso = peso;
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
