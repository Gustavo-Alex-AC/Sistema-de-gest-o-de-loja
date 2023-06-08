public class Pizza extends Prato{
    private String molho;
    private String recheio;
    private String cobertura;

    public Pizza() {

    }

    public Pizza(Double precoDeVenda, String dataDeValidade, Double peso, String molho, String recheio, String cobertura) {
        super(precoDeVenda, dataDeValidade, peso);
        this.molho = molho;
        this.recheio = recheio;
        this.cobertura = cobertura;
    }

    public String getMolho() {
        return molho;
    }

    public String getRecheio() {
        return recheio;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
}
