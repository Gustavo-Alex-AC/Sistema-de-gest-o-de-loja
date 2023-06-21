
package snackbar;

public class Salgadinho extends Prato{
      private String tipo;
    private String recheio;
    private String massa;
    
    public Salgadinho(Double precoDeVenda, String dataDeValidade, Double peso, String tipo, String recheio, String massa) {
        super(precoDeVenda, dataDeValidade, peso);
        this.tipo = tipo;
        this.recheio = recheio;
        this.massa = massa;
    }
    
    public Salgadinho() {
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }
}
